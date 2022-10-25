// sp38 TSMP

/*

Bob Marley is a jamaican singer, he loves to travel around the globe.
He planned to travel N famous places and return to the starting station.
Each place is indicated with numbers from 0 to N-1.
He will start the travel from Place-0.
 
You are given an integer N and cost matrix cost[][],a symmetric matrix, 
where cost[i][j] indiactes cost to travel from place-i to place-j and vice-versa, 
if cost[i][j]=0, indicates no way to travel from place-i to place-j and vice-versa. 

Your task is to help Bob Marley, to find the shortest possible travel plan
to visit every place and returns to starting place-0. 
Finally print the minimum cost to travel accordingly.

Input Format:
-------------
Line-1: An integer N. 
Next N lines: N space separated integers, cost of i to j.

Output Format:
--------------
Print an integer, the minimum cost to travel all the places and return to place-0.


Sample Input-1:
---------------
4
0 10 35 30
10 0 25 16
24 15 0 20
39 24 14 0

Sample Output-1:
----------------
64

Explanation:
------------
Travelling route is: 0 -> 1 -> 3 -> 2 -> 0


Sample Input-2:
---------------
5
0 22 34 33 30
14 0 11 12 31
16 14 0 38 14
38 25 37 0 23
22 37 13 23 0

Sample Output-2:
----------------
86

Explanation:
------------
Travelling route is: 0 -> 1 -> 3 -> 4 -> 2 -> 0

*/

import java.util.*;

class sp38 {
    int N;
    int final_res = Integer.MAX_VALUE; // final_res is the minimum cost.
    int final_path[];
    boolean visited[];

    sp38(int N) {
        this.N = N;
        final_path = new int[N + 1];
        visited = new boolean[N];
    }

    void copyToFinal(int curr_path[]) {
        for (int i = 0; i < N; i++) {
            final_path[i] = curr_path[i];
        }
        final_path[N] = curr_path[0];
    }

    int firstMin(int cost[][], int i) {
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < N; k++) {
            if (cost[i][k] < min && i != k) {
                min = cost[i][k];
            }
        }
        return min;
    }

    int secondMin(int cost[][], int i) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int j = 0; j < N; j++) {
            if (i == j) {
                continue;
            }
            if (cost[i][j] <= first) {
                second = first;
                first = cost[i][j];
            } else if (cost[i][j] <= second && cost[i][j] != first) {
                second = cost[i][j];
            }
        }
        return second;
    }

    void TSPRec(int cost[][], int curr_bound, int curr_weight, int level, int curr_path[]) {
        if (level == N) {
            if (cost[curr_path[level - 1]][curr_path[0]] != 0) {
                int curr_res = curr_weight + cost[curr_path[level - 1]][curr_path[0]];
                if (curr_res < final_res) {
                    copyToFinal(curr_path);
                    final_res = curr_res;
                }
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (cost[curr_path[level - 1]][i] != 0 && visited[i] == false) {
                int temp = curr_bound;
                curr_weight += cost[curr_path[level - 1]][i];
                if (level == 1) {
                    curr_bound -= ((firstMin(cost, curr_path[level - 1]) + firstMin(cost, i)) / 2);
                } else {
                    curr_bound -= ((secondMin(cost, curr_path[level - 1]) + firstMin(cost, i)) / 2);
                }
                if (curr_bound + curr_weight < final_res) {
                    curr_path[level] = i;
                    visited[i] = true;
                    TSPRec(cost, curr_bound, curr_weight, level + 1, curr_path);
                }
                curr_weight -= cost[curr_path[level - 1]][i];
                curr_bound = temp;
                Arrays.fill(visited, false);
                for (int j = 0; j <= level - 1; j++) {
                    visited[curr_path[j]] = true;
                }
            }
        }
    }

    void TSP(int cost[][]) {
        // implement your code here.
        int curr_path[] = new int[N + 1];
        int curr_bound = 0;
        Arrays.fill(curr_path, -1);
        Arrays.fill(visited, false);
        for (int i = 0; i < N; i++) {
            curr_bound += (firstMin(cost, i) + secondMin(cost, i));
        }
        curr_bound = (curr_bound == 1) ? curr_bound / 2 + 1 : curr_bound / 2;
        visited[0] = true;
        curr_path[0] = 0;
        TSPRec(cost, curr_bound, 0, 1, curr_path);
    }
}
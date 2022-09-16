/*

Budget Padmanabham planned to visit the tourist places.
There are N tourist places in the city.
The tourist places are numbered from 0 to N-1.
You are given the routes[] to travel between the tourist places in the city.
where routes[i]=[place-1, place-2, price], A route is a bi-directional route.
You can travel from place-1 to place-2 or place-2 to place-1 with the given price.

Your task is to help Budget Padmanabham to find the cheapest route plan,
to visit all the tourist places in the city. 
If you are not able to find such plan, print -1.

Input Format:
-------------
Line-1: Two space separated integers N and R,number of places and routes.
Next R lines: Three space separated integers, start, end and price.
 
Output Format:
--------------
Print an integer, minimum cost to visit all the tourist places.


Sample Input-1:
---------------
4 5
0 1 3
0 2 5
1 2 4
2 3 1
1 3 5

Sample Output-1:
----------------
8

Explanation:
------------
The cheapest route plan is as follows:
0-1, 1-2, 2-3 and cost is 3 + 4 + 1 = 8


Sample Input-2:
---------------
4 3
0 1 2
0 2 4
1 2 3

Sample Output-2:
----------------
-1

Note: Use Kruskal's Algorithm

*/

import java.util.*;

public class kruskals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(kruskalsSoln(arr, m, n));
        sc.close();
    }

    static int kruskalsSoln(int[][] arr, int m, int n) {
        int[] parent = new int[m];
        for (int i = 0; i < m; i++) {
            parent[i] = i;
        }
        Arrays.sort(arr, (a, b) -> a[2] - b[2]);
        int cost = 0;
        for (int i = 0; i < n; i++) {
            int x = find(arr[i][0], parent);
            int y = find(arr[i][1], parent);
            if (x != y) {
                cost += arr[i][2];
                parent[x] = y;
            }
        }
        for (int i = 1; i < m; i++) {
            if (find(i, parent) != find(i - 1, parent)) {
                return -1;
            }
        }
        return cost;
    }
    static int find(int x, int[] parent) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x], parent);
    }
}
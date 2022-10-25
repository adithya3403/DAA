// sp45 Traveller 
// Grade : 0/100

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
0 13 11 12
13 0 14 9
11 14 0 5
12 9 5 0

Sample Output-1:
----------------
38


Sample Input-2:
---------------
5
0 15 5 12 15
15 0 7 13 9
5 7 0 10 15
12 13 10 0 7
15 9 15 7 0

Sample Output-2:
----------------
40

*/
import java.util.*;

class sp45 {
    int minimumCost(int cost[][]) { // cost matrix is of size (n+1)*(n+1)
        // implement your logic here.
        // solve using dp
        int n = cost.length;
        int dp[][] = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][1] = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    for (int j = 0; j < n; j++) {
                        if (i != j && (mask & (1 << j)) != 0) {
                            dp[i][mask] = Math.min(dp[i][mask], dp[j][mask ^ (1 << i)] + cost[j][i]);
                        }
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.min(res, dp[i][(1 << n) - 1] + cost[i][0]);
        }
        return res;
    }
}

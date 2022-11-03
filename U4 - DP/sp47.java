// sp47 OBST

/*

You are given N nodes of a Binary search tree. To serach a node in 
the binary serach tree, it will cost some amount. 
You are given the N nodes as data[] in sorted order and the search costs of 
N nodes as amount[], where amount[i] is the cost to search data[i] in the BST.

The cost to search a BST node is the level of that node multiplied by its amount. 
The level of the root is 1.

Your task is to findout the minimum cost of a BST is defines as the total cost 
of all the BST nodes. You can form the BST with any element as the root node.


Input Format:
-------------
Line-1: An integer N, number of nodes.
Line-2: N space separate integers, node vals[].
Line-3: N space separate integers, node cost[].

Output Format:
--------------
Print an integer, minimum search cost of BST.


Sample Input-1:
---------------
3
10 20 30
23 32 14

Sample Output-1:
----------------
106

Explanation:
------------
The BST is: 
   20
  /  \
10   30


Sample Input-2:
---------------
4
8 10 12 20
26 34 8 50

Sample Output-2:
----------------
210

Explanation:
------------
The BST is: 
   10
  /  \
 8   20
    /
   12

*/

class sp47 {
    int minSearchCostBST(int data[], int amount[], int n) {
        // implement your code here.
        int dp[][] = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            dp[i][i] = amount[i];
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                int sum = 0;
                for (int k = i; k <= Math.min(amount.length - 1, j); k++) {
                    sum += amount[k];
                }
                for (int r = i; r <= j; r++) {
                    int c = sum;
                    if (r > i)
                        c += dp[i][r - 1];
                    if (r < j)
                        c += dp[r + 1][j];
                    if (c <= dp[i][j])
                        dp[i][j] = c;
                }
            }
        }
        return dp[0][n - 1];
    }
}
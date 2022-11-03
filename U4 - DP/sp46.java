// sp46 DMart

/*

Mr. Dharma went to D-mart, and picked a basket with a capacity C.
There are N products in Dharma's wishlist.
You will be given desired cost and quantity of each Product.
Out of the wishlist Mr Dharma has, he wants to purchase the products in 
the following way:
	- The sum of quantities taken into the basket is less than or equal to C.
	- The sum of cost of the products in the basket is maximum among all 
	the possible combinations of products.

Your task is to help, Mr. Dharma to purachase the products with maximum cost, 
with the given basket capacity. 

Input Format:
-------------
Line-1: Two space separated integers, N and C.
Next N lines: Two space separated integers, Ci and Qi.
        	cost and quantity of i-th product.

Output Format:
--------------
Print an integer, Maximum cost to pay to D-Mart.


Sample Input-1:
---------------
4 15
10 2
10 4
12 6
18 9

Sample Output-1:
----------------
38

Explanation:
------------
Quantity = 2 + 4 + 9 = 15
Cost = 10 + 10 + 18 = 38


Sample Input-2:
---------------
4 21
18 6
20 3
14 5
18 9

Sample Output-2:
----------------
56

Explanation:
------------
Quantity = 6 + 3 + 9 = 18
Cost = 18 + 20 + 18 = 56

*/

class sp46 {
    int maximumCost(int[] cost, int[] quantity, int N, int C) {
        // implement your code here.
        int[][] dp = new int[N + 1][C + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                if (quantity[i - 1] <= j) {
                    int prev = j - quantity[i - 1];
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][prev] + cost[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][C];
    }
}
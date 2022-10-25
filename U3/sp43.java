// sp43 MatricesMultiplications

/*

Your are given the sizes of N-1 matrices as a list[] of size N, where the matrices
are numbered from 0 to N-2 and the matrix size is defined as matrix-i 
size is list[i]*list[i+1].

Matrix multiplication follows associative rule. If you want to multiply 
4 matrices, A,B,C and D. You can perform multiplication in the following ways, 
ABCD, AB(CD), A(BC)D, ((AB)C)D, (AB)(CD)..etc.

To multiply two matrices of size m*n, n*p, you require m*n*p number of multiplications.

Your task is to return the minimum number of multiplications needed to multiply 
the N-1 matrices.

Input Format:
------------------
Line-1: An integer N
Line-2: N space separated integers, the list[]

Output Format:
--------------------
Print an integer, minimum multiplications needed.


Sample Input-1:
--------------------
4
10 30 5 60

Sample Output-1:
----------------------
4500

Explanation:
-----------------
posibilities are:
(AB)C => (10×30×5) + (10×5×60) => 1500 + 3000 = 4500 multiplications
A(BC) => (30×5×60) + (10×30×60) => 9000 + 18000 = 27000 multiplications


Sample Input-2:
--------------------
5
12 5 18 7 19

Sample Output-2:
----------------------
2435

Explanation:
-----------------
The best way is: A((BC)D) => (12*5*19) + (5*18*7) + (5*7*19)
=> 1140 + 630 + 665 = 2435 multiplications

*/

class sp43 {
    int MinMultiplications(int list[], int n) {
        // implement your code here.
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + list[i - 1] * list[k] * list[j]);
                }
            }
        }
        return dp[1][n - 1];
    }
}

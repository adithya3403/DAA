// sp50 LCS

/*

Vihaan is given a pair of words likely word1 and word2, he is asked to create 
a method which returns the numbers of characters in a word formed from long 
lasting frequent posteriority. 

Posteriority is a latest word formed from the native word with few characters 
removed without modifying the corresponding order of the left over characters. 

A frequent posteriority of two words is a posteriority that is frequent 
to both words. Return 0 if no common posteriority.

Input Format:
-------------
Two space separated strings S1, S2.

Output Format:
--------------
Print an integer, the length of longest common subsequence.


Sample Input-1:
---------------
abcde ace

Sample Output-1:
----------------
3


Sample Input-2:
---------------
acd bef

Sample Output-2:
----------------
0

*/

import java.util.*;

public class sp50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(LCS(str1, str2));
        sc.close();
    }

    static int LCS(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}
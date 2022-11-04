// Grade: 75/100

// sp49 LRS

/*

Charlie Brown is working with strings,
He is a given a string S. He wants to find out the maximum substring 'MaxSub'.

MaxSub is a substring which appears atleast twice in S with Maximum length. 

Your task is to help Charlie Brown to find the Maximum Substring MaxSub,
and print the length of MaxSub. If there is MaxSub, return 0.

Input Format:
-------------
A string S.

Output Format:
--------------
Print an integer, length of MaxSub


Sample Input-1:
---------------
babababba

Sample Output-1:
----------------
5

Explanation: 
------------
The Maximum substring is 'babab' , which occurs 2 times.


Sample Input-2:
---------------
abbbbba

Sample Output-2:
----------------
4

Explanation: 
------------
The Maximum substring is 'bbbb' , which occurs 2 times.


Sample Input-3:
---------------
vignesh

Sample Output-3:
----------------
0

*/

import java.util.*;

public class sp49 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(maxSub(s));
        sc.close();
    }

    static int maxSub(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max && j - i + 1 <= dp[i][j]) {
                        max = dp[i][j];
                    }
                }
            }
        }
        return max;
    }
}
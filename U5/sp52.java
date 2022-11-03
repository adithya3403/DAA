// sp52 Valid Abbreviations

/*

The Valid shortcuts of a string "abcd", are as follows:
abcd, abcd, a1cd, ab1d, abc1, 2cd, a2d, ab2, 1b1d, 1bc1,a1c1, 1b2, 2c1, 3d, a3, 4

You are given a string S and shortcut string  SC, 
Your task is to find out whether the string matches with the given shortcut or not.
if matched print true, else false.

Note:
String S contains only lowercase letters and String SC contains only 
lowercase letters and digits.

Input Format:
-------------
Two space separated Strings S and SC

Output Format:
--------------
Print a boolean value


Sample Input-1:
---------------
internationalization i12iz4n

Sample Output-1:
----------------
true


Sample Input-2:
---------------
apple a2e

Sample Output-2:
----------------
false

*/

import java.util.*;

public class sp52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(isAbbr(s1, s2));
        sc.close();
    }

    static boolean isAbbr(String a, String b) {
        int sum = 0;
        for (int i = 0; i < b.length(); i++) {
            if (!Character.isDigit(b.charAt(i)))
                sum++;
            else {
                int x = i, y = i;
                while (y < b.length() && Character.isDigit(b.charAt(y)))
                    y++;
                sum += Integer.parseInt(b.substring(x, y));
                i = y - 1;
            }
        }
        return sum == a.length();
    }
}
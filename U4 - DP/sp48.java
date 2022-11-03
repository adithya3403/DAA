// sp48 SpecialStrings

/*

Subhani is working with strings. He is given a word W, his task to form 
the special strings. A string said to be special, if the string is formed 
with only one alphabet or digit.

Print the number of special substrings can be formed using W.

Input Format:
-------------
A string, W consist of digits and lowercase letters.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
abcde

Sample Output-1:
----------------
5


Sample Input-2:
---------------
aaabbb

Sample Output-2:
----------------
12

Explanation:
------------
The special strings formed using the word W are:
"aaa","bbb" formed 1 time.
"aa","bb" formed 2 times.
"a","b" formed 3 times.
Total of 12 special strings can be formed.


Sample Input-3:
---------------
binary11100

Sample Output-3:
----------------
15

Explanation:
------------
The special strings formed using the word W are:
"b", "i", "n", "a", "r", "y", "111", "00" formed 1 time
"11", "0" formed 2 times 
"1" formed 3 times

*/

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(specialStrings(str));
        sc.close();
    }

    static int specialStrings(String str) {
        int count = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            int j = i + 1;
            while (j < len && str.charAt(i) == str.charAt(j)) {
                j++;
            }
            count += (j - i) * (j - i + 1) / 2;
            i = j - 1;
        }
        return count;
    }
}
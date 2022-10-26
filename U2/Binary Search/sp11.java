// sp11 LCP

/*

Jagannadham is working with a set of words[], 
He wants to find out the common substring in all the words in the set,
and the substring should be the longest and also a prefix.

Can you help Jagannadham to find such substring.
If the substring is found, print it.
Otherwise, print an empty string,"".

Input Format:
-------------
Space separated strings, set of words[].

Output Format:
--------------
Print a string, the substring.


Sample Input-1:
---------------
apple applet application append

Sample Output-1:
----------------
"app"


Sample Input-2:
---------------
ant fox cat camel fish

Sample Output-2:
----------------
""

NOTE: 
	- " ", added for clarity no need to add in the output.
    -all the words consist of lowercase letters only.

    */

import java.util.*;

public class sp11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        System.out.println(longestCommonPrefix(words, 0, words.length - 1));
        sc.close();
    }

    static String longestCommonPrefix(String[] words, int l, int r) {
        if (l == r)
            return words[l];
        else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix(words, l, mid);
            String lcpRight = longestCommonPrefix(words, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    static String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }
}
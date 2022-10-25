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
        System.out.println(longestCommonPrefix(words));
        sc.close();
    }

    public static String longestCommonPrefix(String[] words) {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String prefix = word.substring(0, i + 1);
                map.put(prefix, map.getOrDefault(prefix, 0) + 1);
            }
        }
        String ans = "";
        for (String key : map.keySet())
            if (map.get(key) == words.length)
                ans = key;
        return ans;
    }
}
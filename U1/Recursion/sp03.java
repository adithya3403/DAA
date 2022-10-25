// sp03 String

/*

Ms Sonali Sharma is given a task. She has an habit of reading the words 
from the end to the start (i.e., if the original word is Hello,  
she reads it as "olleH").

Your task is to help her to read the word properly, 
by following the rules:
    - You are given a word W,
    - Rearrange the characters from end to start in the word.
    - And print the word.

NOTE: 
 - W contains only lowercase letters.
 
Input Format:
-------------
A string W, word.

Output Format:
--------------
Print a string result.


Sample Input-1:
---------------
divide

Sample Output-1:
----------------
edivid

Explanation:
------------
After rearranging the characters from end to start, the word is : edivid 


Sample Input-2:
---------------
racing

Sample Output-2:
----------------
gnicar

Explanation:
------------
After rearranging the characters from end to start, the word is : gnicar 

*/

import java.util.*;

public class sp03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(reverseString(str));
        sc.close();
    }

    public static String reverseString(String str) {
        if (str.isEmpty())
            return str;
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}
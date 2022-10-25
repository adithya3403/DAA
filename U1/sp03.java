// Reverse a string
// input divide output edivid
// input racing output gnicar

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
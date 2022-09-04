// Reverse a string
// input divide output edivid
// input racing output gnicar

import java.util.*;
public class sp03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] str1 = str.toCharArray();
        System.out.println(rev(str1));
        sc.close();
    }
    public static char[] rev(char[] str) {
        helper(str, 0, str.length - 1);
        return str;
    }
    public static void helper(char[] str, int left, int right) {
        if (left >= right) return;
        char x = str[left];
        str[left] = str[right];
        str[right] = x;
        left++;
        right--;
        helper(str, left, right);
    }
}
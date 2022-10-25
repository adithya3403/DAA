// sp08 P_power_N

/*

A school kid named Chitti Naidu, wants to find the value of N^P
Pth power of a number N.

You will be given two integers N and P.
Your task is to help Chitti Naidu to find the value of N^P.

NOTE:
---------
Value of N and P can be both positive and negative


Input Format:
-------------
Two integers N and P, where N is the number and P is the power

Output Format:
--------------
Print a float number, N power P


Sample Input-1:
---------------
3 2

Sample Output-1:
----------------
9.000000


Sample Input-2:
---------------
2 -3

Sample Output-2:
----------------
0.125000


*/

import java.util.*;

public class sp08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        System.out.format("%.6f", findPow(x, n));
        sc.close();
    }

    public static float findPow(int x, int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 1 / findPow(x, -n);
        return x * findPow(x, n - 1);
    }
}
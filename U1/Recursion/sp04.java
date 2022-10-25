// sp04 Special Number

/*

Mr.John doe is working with Numbers.
He is given a number N. He wants to check whether N,
obeys the following conditions or not:
	- Initialize P=0, extract each digit 'd' from N, add them to P=> P = P + d^2.
	- Add set N value to P as N=P.
	- and repeat the process until the N equals 1 or 
	if N loops endlessly in a cycle without having 1. 

Your task is to help Mr John to check whether N becomes 1 or Not.
If yes, print "true", otherwise print "false".

Note: A^B indicates A to power of B.

Input Format:
-------------
An integer N

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
19

Sample Output-1:
----------------
true

Explanation:
------------
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1


Sample Input-2:
---------------
89

Sample Output-2:
----------------
false

Explanation:
------------
8^2 + 9^2 = 145
1^2 + 4^2 + 5^2 = 42
4^2 + 2^2 = 20
2^2 + 0^2 = 4
4^2  = 16
1^2 + 6^2 = 37
3^2 + 7^2 = 58
5^2 + 8^2 = 89
We got a cycle,so return"false"

*/

import java.util.*;

public class sp04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isHappyNumber(n));
        sc.close();
    }

    public static boolean isHappyNumber(int n) {
        if (n == 1)
            return true;
        if (n == 4)
            return false;
        return isHappyNumber(sumOfSquares(n));
    }

    public static int sumOfSquares(int n) {
        int total = 0;
        while (n > 0) {
            total += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return total;
    }
}
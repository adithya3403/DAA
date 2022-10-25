// sp01 Sequence

/*

Mr.Carl, a student in a school asked a question by his Math Teacher
Mr.Carl is given starting two numbers of an arithmatic sequence, 
num1, num2. He can calculate the next number in the sequence as 
the sum of the last two numbers in the arithmetic sequence so far.

Your task is to help Mr.Carl to implement the arithmetic sequence accordingly.
And return the Kth Number the in the sequence (including num1, num2).

Input Format:
-------------
Three space seprated integers, num1, num2, K.

Output Format:
--------------
Print the Kth number in the sequence starts with num1 and num2.


Sample Input-1:
---------------
1 2 5

Sample Output-1:
----------------
8

Explanation:
------------
The arithmetic sequence is:
1, 2, 3, 5, 8


Sample Input-2:
---------------
2 5 6

Sample Output-2:
----------------
31

Explanation:
------------
The arithmetic sequence is:
2, 5, 7, 12, 19, 31

*/

import java.util.Scanner;

public class sp01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(fun(a, b, c));
        sc.close();
    }

    public static int fun(int a, int b, int c) {
        if (c == 2) {
            return b;
        } else {
            c--;
            return fun(b, a + b, c);
        }
    }
}

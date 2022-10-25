// sp02 FillBuckets

/*

In a colony drinking water is supplied through water tanks.
There is a big queue of N buckets, The supplier needs to fill all the N buckets
in the queue. The supplier can fill one bucket or two buckets at a time.

Your task is to find the number of distinct ways, the supplier can fill all buckets.

Input Format:
-------------
An integer N, number of buckets in the queue 1 <= N <= 40.

Output Format:
--------------
Print the number of ways to fill all the buckets.


Sample Input-1:
---------------
2

Sample Output-1:
----------------
2

Explanation:
------------
There are two ways to fill the buckets.
1. 1 bucket + 1 bucket
2. 2 buckets


Sample Input-2:
---------------
4

Sample Output-2:
----------------
5

Explanation:
------------
There are five ways to fill the buckets.
1. 1 bucket + 1 bucket + 1 bucket + 1 bucket
2. 1 bucket + 1 bucket + 2 buckets 
3. 1 bucket + 2 buckets + 1 bucket
4. 2 buckets + 1 bucket + 1 bucket
5. 2 buckets+2 buckets

*/

import java.util.Scanner;

public class sp02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fun(n + 1));
        sc.close();
    }

    public static int fun(int n) {
        if (n <= 1)
            return n;
        return fun(n - 1) + fun(n - 2);
    }
}
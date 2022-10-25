// sp19 MinProductSetV2

/*

You are given a list of N integers List[], list contains both +ve and
-ve integers. Your task is to findout, the Lowest Product possible.
Where the product is the product of all the elements sublist 
sList[], and sub list should contain atleast 1 integer. 
The elements need not be contiguous.

Input Format:
-------------
Line-1: An integer N.
Line-2: N space separated integers, List[].

Output Format:
--------------
Print an integer output, the lowest product.

Sample Input-1:
---------------
4
2 -3 4 -5

Sample Output-1:
----------------
-40

Explanation:
------------
Product of elements sub list [2 4 -5].


Sample Input-2:
---------------
3
-2 0 -3

Sample Output-2:
----------------
-3

Explanation:
------------
Product of sub list is-3,where[-3]is the sublist

*/

import java.util.*;

public class sp19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(minProduct(arr));
        sc.close();
    }

    static long minProduct(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return arr[0];
        int negmax = Integer.MIN_VALUE;
        int posmin = Integer.MAX_VALUE;
        int cneg = 0, czero = 0;
        long prod = 1;
        for (int i : arr) {
            if (i == 0) {
                czero++;
                continue;
            }
            if (i < 0) {
                cneg++;
                negmax = Math.max(negmax, i);
            }
            if (i > 0) {
                posmin = Math.min(posmin, i);
            }
            prod = prod * i;
        }
        if (czero == n || (cneg == 0 && czero > 0))
            return 0;
        if (cneg == 0)
            return posmin;
        if (cneg % 2 == 0 && cneg != 0)
            prod = prod / negmax;
        return (long) prod;
    }
}
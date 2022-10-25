// sp14 MinProductSet

/*

You are given a list of N integers List[], list contains both +ve and
-ve integers. Your task is to findout, the Lowest Product possible,
Where the product is the product of all the elements of contiguous sublist 
sList[], and sub list should conatin atleast 1 integer.

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
2 3 -2 4

Sample Output-1:
----------------
-48

Explanation:
------------
Product of contiguous sub list [2,3,-2,4].


Sample Input-2:
---------------
3
-2 0 -3

Sample Output-2:
----------------
-3

Explanation:
------------
Product of sub list is-3,where[-3]is the contiguous sublist

*/

import java.util.*;

public class sp14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(minProduct(arr));
        sc.close();
    }

    static int minProduct(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return arr[0];
        int maxsofar = arr[0];
        int minsofar = arr[0];
        int res = minsofar;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int max = maxsofar * temp;
            int min = minsofar * temp;
            maxsofar = Math.max(temp, Math.max(min, max));
            minsofar = Math.min(temp, Math.min(min, max));
            res = Math.min(res, minsofar);
        }
        return res;
    }
}
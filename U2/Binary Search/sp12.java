// sp12 SmallestGoldBox

/*

There are B bags containing N gold boxes each. In each bag, gold boxes are 
arranged  in ascending order of their weights strictly, create a method in 
such a way that we need to return the least weight of gold box which is 
common least weight in all the given bags.
If we don’t have any common least weighted gold box, 
among all the bags then return -1.

Input Format:
Line-1: Two integers B and N, number of bags and number of goldboxes in each Bag.
Next B lines: N space separated integers, weights of GoldBoxes.
Output Format:
Print the least weight of gold box, if found
Print -1, if not found.

Sample Input:
5 5
1 2 3 4 5
2 3 6 7 9
1 2 3 5 8
1 3 4 6 8 
2 3 5 7 8
Sample Output:
3

*/

import java.util.*;

public class sp12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        System.out.println(findCommonEle(arr));
        sc.close();
    }

    public static int findCommonEle(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            int x = arr[0][i];
            for (int j = 1; j < m; j++) {
                if (!binSearch(arr[j], x)) {
                    flag = false;
                    break;
                }
            }
            if (flag == true)
                return x;
        }
        return -1;
    }

    public static boolean binSearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return true;
            else if (arr[mid] > x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }
}
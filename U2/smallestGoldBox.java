// There are B bags containing N gold boxes each. In each bag, gold boxes are 
// arranged  in ascending order of their weights strictly, create a method in 
// such a way that we need to return the least weight of gold box which is 
// common least weight in all the given bags.
// If we don’t have any common least weighted gold box, 
// among all the bags then return -1.

// Input Format:
// Line-1: Two integers B and N, number of bags and number of goldboxes in each Bag.
// Next B lines: N space separated integers, weights of GoldBoxes.
// Output Format:
// Print the least weight of gold box, if found
// Print -1, if not found.

// Sample Input:
// 5 5
// 1 2 3 4 5
// 2 3 6 7 9
// 1 2 3 5 8
// 1 3 4 6 8 
// 2 3 5 7 8
// Sample Output:
// 3

import java.util.*;

public class smallestGoldBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(findCommonEle(arr));
        sc.close();
    }

    public static int findCommonEle(int[][] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            if (map.get(key) == arr.length)
                min = Math.min(min, key);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
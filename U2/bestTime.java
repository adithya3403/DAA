// Sample Input-1:
// 6
// 7 1 5 3 6 4
// Sample Output-1:
// 5
// Explanation: 
// Purchase on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.

// Sample Input-2:
// 5 
// 7 6 5 4 2
// Sample Output-2:
// 0

import java.util.*;

public class bestTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int x = maxProfit(arr);
        System.out.println(x);
        sc.close();
    }

    static int maxProfit(int[] arr) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i < minPrice) {
                minPrice = i;
            } else if (i - minPrice > maxProfit) {
                maxProfit = i - minPrice;
            }
        }
        return maxProfit;
    }
}
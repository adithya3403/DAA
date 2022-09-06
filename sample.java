/*
5
6
-3 3 6 12 15
-20 -11 -5 1 4 10
5.0
*/

import java.util.*;

public class sample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] a1 = new int[a];
        int[] b1 = new int[b];
        for (int i = 0; i < a; i++) {
            a1[i] = sc.nextInt();
        }
        for (int i = 0; i < b; i++) {
            b1[i] = sc.nextInt();
        }
        System.out.println(findMedian(a1, b1));
        sc.close();
    }

    static double findMedian(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        if (n1 > n2) {
            return findMedian(b, a);
        }
        int low = 0;
        int high = n1;
        while (low <= high) {
            int px = (low + high) / 2;
            int py = (n1 + n2 + 1) / 2 - px;
            int maxLX = (px == 0) ? Integer.MIN_VALUE : a[px - 1];
            int maxLY = (py == 0) ? Integer.MIN_VALUE : b[py - 1];
            int minRX = (px == n1) ? Integer.MAX_VALUE : a[px];
            int minRY = (py == n2) ? Integer.MAX_VALUE : b[py];
            if (maxLX <= minRY && maxLY <= minRX) {
                if ((n1 + n2) % 2 == 0) {
                    return (double) (Math.max(maxLX, maxLY) + Math.min(minRX, minRY)) / 2;
                } else {
                    return (double) Math.max(maxLX, maxLY);
                }
            } else if (maxLX > minRY) {
                high = px - 1;
            } else {
                low = px + 1;
            }
        }
        return 0.0;
    }
}
// Example 1:
// Sample Input=
// 4                   // m
// 5                   // n
// 62 74 81 95         // Rose section marks
// 40 59 67 73 84      // Lotus section marks
// Sample Output=
// 73.0         // median
// Explanation: merged marks = [40 59 62 67 73 74 81 84 95]
// and median is 73.0

// Example 2:
// Sample Input=
// 4
// 4
// 61 71 82 95
// 42 51 64 83
// Sample Output=
// 67.5
// Explanation: merged marks = [42 51 61 64 71 82 83 95] 
// and median is (64+71)/2 is 67.5

import java.util.*;

public class medianOf2SectionMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] a = new int[n1];
        int[] b = new int[n2];
        for (int i = 0; i < n1; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n2; i++)
            b[i] = sc.nextInt();
        System.out.println(getMedian(a, b));
        sc.close();
    }

    static double getMedian(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        if (n1 > n2)
            return getMedian(b, a);
        int low = 0, high = n1;
        while (low <= high) {
            int px = (low + high) / 2;
            int py = (n1 + n2 + 1) / 2 - px;
            int maxLX = (px == 0) ? Integer.MIN_VALUE : a[px - 1];
            int maxLY = (py == 0) ? Integer.MIN_VALUE : b[py - 1];
            int minRX = (px == n1) ? Integer.MAX_VALUE : a[px];
            int minRY = (py == n2) ? Integer.MAX_VALUE : b[py];
            if (maxLX <= minRY && maxLY <= minRX) {
                if ((n1 + n2) % 2 == 0)
                    return (double) (Math.max(maxLX, maxLY) + Math.min(minRX, minRY)) / 2;
                else
                    return (double) (Math.max(maxLX, maxLY));
            } else if (maxLX > minRY)
                high = px - 1;
            else
                low = px + 1;
        }
        return 0.0;
    }
}
// In a school, 5th standard is having 2 sections called Rose and Lotus.
// Section Rose contains 'm' students and Lotus contains 'n' students.
// Each section students scored marks in Mathematics exam.
// Teacher maintained a record of marks in ascending order of each section.
// Now your task is to find out the median of the marks of 2 sections together.
// Note: The overall run time complexity should be O(log (m+n)) .

// Example 1:
// Sample Input=
// 4
// 6
// 32 45 70 95
// 40 50 59 67 73 84
// Sample Output=
// 63.0         //median

// Example 2:
// Sample Input=
// 5
// 6
// 10 20 30 40 50
// 35 44 60 70 80 90
// Sample Output=
// 44

// Input 3:
// 4
// 6
// 3 6 8 10
// 14 17 20 33 44 55
// Output:
// 15.5

// Input 4:
// 5
// 3
// 7 10 20 30 40 
// 50 60 80
// Output:
// 35

import java.util.*;

public class medianOf2SectionMarks {
    public static double getMedian(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length)
            getMedian(arr2, arr1);
        int x = arr1.length;
        int y = arr2.length;
        int low = 0;
        int high = x;
        while (low <= high) {
            int px = (low + high) / 2;
            int py = (x + y + 1) / 2 - px;
            int maxLX = (px == 0) ? Integer.MIN_VALUE : arr1[px - 1];
            int maxLY = (py == 0) ? Integer.MIN_VALUE : arr2[py - 1];
            int minRX = (px == x) ? Integer.MAX_VALUE : arr1[px];
            int minRY = (py == y) ? Integer.MAX_VALUE : arr2[py];
            if (maxLX <= minRY && maxLY <= minRX) {
                if ((x + y) % 2 == 0) {
                    return ((double) (Math.max(maxLX, maxLY) + Math.min(minRX, minRY))) / 2;
                } else {
                    return (double) Math.max(maxLX, maxLY);
                }
            } else if (maxLX > minRY) {
                high = px - 1;
            } else {
                low = px + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] A = new int[m];
        int[] B = new int[n];
        for (int i = 0; i < m; i++)
            A[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            B[i] = sc.nextInt();
        System.out.println(getMedian(A, B));
        sc.close();
    }
}
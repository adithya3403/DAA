// sp13 MedianOfTwoSectionMarks

/*

In a school, 5th standard is having 2 sections called Rose and Lotus.
Section Rose contains 'm' students and Lotus contains 'n' students.
Each section's students scored marks in the Mathematics exam.
Teacher maintained a record of marks in ascending order of each section.
Now your task is to find out the median of the marks of 2 sections together.

Note: The overall run time complexity should be O(log (m+n)) .

Example 1:
Sample Input=
4                   //m                                                                                                     
5                   //n                                                                                                    
62 74 81 95         //Rose section marks                                                                                                    
40 59 67 73 84      //Lotus section marks                                                                                                    

Sample Output=
73.0         //median

Explanation: merged marks = [40 59 62 67 73 74 81 84 95] 
and median is 73.0

Example 2:
Sample Input=
4
4
61 71 82 95
42 51 64 83

Sample Output=
67.5

Explanation: merged marks = [42 51 61 64 71 82 83 95] 
and median is (64+71)/2 is 67.5


*/

import java.util.*;

public class sp13 {
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
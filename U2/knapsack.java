// grade: 50 / 100 (1, 2, 3 test cases passed)

import java.util.*;

public class knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[] cost = new int[N];
        int[] quantity = new int[N];
        for (int i = 0; i < N; i++) {
            cost[i] = sc.nextInt();
            quantity[i] = sc.nextInt();
        }
        System.out.println(maxCost(cost, quantity, N, C));
        sc.close();
    }

    static long maxCost(int[] cost, int[] quantity, int n, int c) {
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = cost[i];
            arr[i][1] = quantity[i];
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return (b[0] / b[1]) - (a[0] / a[1]);
            }
        });
        long maxC = 0;
        for (int i = 0; i < n; i++) {
            if (c >= arr[i][1]) {
                maxC += arr[i][0];
                c = c - arr[i][1];
            } else {
                maxC += (arr[i][0] / arr[i][1]) * c;
                break;
            }
        }
        return maxC;
    }
}
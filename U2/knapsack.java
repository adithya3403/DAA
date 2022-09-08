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
        int[] ratio = new int[n];
        for (int i = 0; i < n; i++)
            ratio[i] = cost[i] / quantity[i];
        int maxC = 0, maxR = 0, maxRI = 0, totalQ = 0;
        while (totalQ < c) {
            maxR = 0;
            maxRI = 0;
            for (int i = 0; i < n; i++) {
                if (ratio[i] > maxR) {
                    maxR = ratio[i];
                    maxRI = i;
                }
            }
            if (totalQ + quantity[maxRI] <= c) {
                totalQ += quantity[maxRI];
                maxC += cost[maxRI];
            } else {
                maxC += (c - totalQ) * ratio[maxRI];
                totalQ = c;
            }
            ratio[maxRI] = 0;
        }
        return maxC;
    }
}
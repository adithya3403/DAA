import java.util.*;

public class minProductSet_V2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(minProduct(arr));
        sc.close();
    }

    static long minProduct(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return arr[0];
        int negmax = Integer.MIN_VALUE;
        int posmin = Integer.MAX_VALUE;
        int cneg = 0, czero = 0;
        long prod = 1;
        for (int i : arr) {
            if (i == 0) {
                czero++;
                continue;
            }
            if (i < 0) {
                cneg++;
                negmax = Math.max(negmax, i);
            }
            if (i > 0) {
                posmin = Math.min(posmin, i);
            }
            prod = prod * i;
        }
        if (czero == n || (cneg == 0 && czero > 0))
            return 0;
        if (cneg == 0)
            return posmin;
        if (cneg % 2 == 0 && cneg != 0)
            prod = prod / negmax;
        return (long) prod;
    }
}
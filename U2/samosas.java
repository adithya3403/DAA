import java.util.*;

public class samosas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int n = str.length;
        int[] box = new int[n];
        for (int i = 0; i < n; i++) {
            box[i] = Integer.parseInt(str[i]);
        }
        int t = sc.nextInt();
        System.out.println(minSpeed(box, t));
        sc.close();
    }

    static int maximum(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    static int minSpeed(int[] box, int t) {
        int l = 1, r = maximum(box);
        while (l < r) {
            int mid = (l + r) / 2;
            if (isMin(box, t, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    static boolean isMin(int[] box, int t, int mid) {
        int h = 0;
        for (int i = 0; i < box.length; i++) {
            h += (box[i] + mid - 1) / mid;
        }
        return h <= t;
    }
}
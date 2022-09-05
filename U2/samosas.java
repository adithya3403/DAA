import java.util.*;

public class samosas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int n = str.length;
        int[] box = new int[n];
        for (int i = 0; i < n; i++)
            box[i] = Integer.parseInt(str[i]);
        int t = sc.nextInt();
        System.out.println(minSpeed(box, t));
        sc.close();
    }

    static int minSpeed(int[] box, int t) {
        int l = 0, r = maximum(box);
        while (l < r) {
            int mid = (l + r) / 2;
            int time = 0;
            for (int i : box)
                time += (i + mid - 1) / mid;
            if (time <= t)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    static int maximum(int[] arr) {
        int max = arr[0];
        for (int i : arr)
            if (i > max)
                max = i;
        return max;
    }
}
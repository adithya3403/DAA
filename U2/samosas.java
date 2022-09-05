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
            if (isPossible(box, t, mid))
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    static boolean isPossible(int[] box, int t, int speed) {
        int time = 0;
        for (int i = 0; i < box.length; i++)
            time += ((box[i] - 1) / speed) + 1;
        return time <= t;
    }

    static int maximum(int[] box) {
        int max = box[0];
        for (int i = 1; i < box.length; i++)
            if (box[i] > max)
                max = box[i];
        return max;
    }
}
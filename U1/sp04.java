// Happy Number
// input 19 output true
// Explanation:
// 1^2 + 9^2 = 82
// 8^2 + 2^2 = 68
// 6^2 + 8^2 = 100
// 1^2 + 0^2 + 0^2 = 1

// input 89 output false
// Explanation:
// 8^2 + 9^2 = 145
// 1^2 + 4^2 + 5^2 = 42
// 4^2 + 2^2 = 20
// 2^2 + 0^2 = 4
// 4^2  = 16
// 1^2 + 6^2 = 37
// 3^2 + 7^2 = 58
// 5^2 + 8^2 = 89
// We got a cycle, so return "false"

import java.util.*;
public class sp04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isHappyNumber(n));
        // System.out.println(isHappyNumber2(n));
        sc.close();
    }
    public static boolean isHappyNumber2(int n) {
        int slow = sumOfSquares(n);
        int fast = sumOfSquares(sumOfSquares(n));
        while (true) {
            if (slow == fast)
                return false;
            if (slow == 1 || fast == 1)
                return true;
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        }
    }
    public static boolean isHappyNumber(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            int sum = sumOfSquares(n);
            if (sum == 1)
                return true;
            if (set.contains(sum))
                return false;
            set.add(sum);
            n = sum;
        }
    }
    public static int sumOfSquares(int n) {
        int total = 0;
        while (n > 0) {
            total += (n % 10) * (n % 10);
            n = n / 10;
        }
        return total;
    }
}
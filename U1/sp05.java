// GCD of min and max
// Input: 16 8 12 24 36 Output: 4
// minH is 8 and maxH is 36, and the HCF(8, 36) is 4
// Input: 19 23 2 5 7 9 11 13 Output: 1

import java.util.*;
public class sp05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<Integer> v = new Vector<>();
        while (sc.hasNext())
            v.add(sc.nextInt());
        int minH = Collections.min(v);
        int maxH = Collections.max(v);
        System.out.println(gcd(minH, maxH));
        sc.close();
    }
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
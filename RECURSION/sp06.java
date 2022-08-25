// UTurnNumbers
// input 1 output [0, 1, 8]
// input 2 output [11, 69, 88, 96]

import java.util.*;

public class sp06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(uTurnNums(n));
        sc.close();
    }

    public static Set<String> uTurnNums(int n) {
        Set<String> res = new TreeSet<>();
        if (n == 0) {
            res.add("");
            return res;
        }
        if (n == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        Set<String> rem = uTurnNums(n - 2);
        for (String s : rem) {
            res.add('0' + s + '0');
            res.add('1' + s + '1');
            res.add('6' + s + '9');
            res.add('8' + s + '8');
            res.add('9' + s + '6');
        }
        return res;
    }
}
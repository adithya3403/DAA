// UTurnNumbers
// input 1 output [0, 1, 8]
// input 2 output [11, 69, 88, 96]

import java.util.*;

public class sp06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findStrobogrammatic(n, n));
        sc.close();
    }

    static char[][] digitPair = { { '1', '1' }, { '8', '8' }, { '6', '9' }, { '9', '6' } };

    static List<String> findStrobogrammatic(int k, int n) {
        if (k <= 0)
            return new ArrayList<String>(Arrays.asList(""));
        if (k == 1)
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        List<String> subList = findStrobogrammatic(k - 2, n);
        List<String> result = new ArrayList<>();
        for (String str : subList) {
            if (k != n)
                result.add("0" + str + "0");
            for (char[] aDigitPair : digitPair)
                result.add(aDigitPair[0] + str + aDigitPair[1]);
        }
        Collections.sort(result);
        return result;
    }
}

// XY_MirrorNumber
// input 96 output true
// input 969 output false

import java.util.*;

public class sp05_mn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        int slow = 0, fast = sb.length() - 1;
        System.out.println(isMirror(sb, slow, fast));
        sc.close();
    }
    static boolean isMirror(StringBuilder sb, int slow, int fast) {
        if (slow <= fast) {
            if (!((sb.charAt(slow) == '0' && sb.charAt(fast) == '0')
                    || (sb.charAt(slow) == '1' && sb.charAt(fast) == '1')
                    || (sb.charAt(slow) == '6' && sb.charAt(fast) == '9')
                    || (sb.charAt(slow) == '9' && sb.charAt(fast) == '6')
                    || (sb.charAt(slow) == '8' && sb.charAt(fast) == '8'))) {
                return false;
            }
            slow++;
            fast--;
            return isMirror(sb, slow, fast);
        }
        return true;
    }
}

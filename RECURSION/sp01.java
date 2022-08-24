// fibonacci at cth position
// input 1 2 5 output 8
// input 2 5 6 output 31

import java.util.Scanner;

public class sp01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(fun(a, b, c));
        sc.close();
    }

    public static int fun(int a, int b, int c) {
        if (c == 2) {
            return b;
        } else {
            c--;
            return fun(b, a + b, c);
        }
    }
}

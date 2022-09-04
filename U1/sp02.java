// climbing stairs
// input 2 output 2
// input 4 output 5
// input 5 output 8

import java.util.Scanner;
public class sp02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fun(n + 1));
        sc.close();
    }
    public static int fun(int n) {
        if (n <= 1)
            return n;
        return fun(n - 1) + fun(n - 2);
    }
}
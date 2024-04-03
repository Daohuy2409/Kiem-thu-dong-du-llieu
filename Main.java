import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a,b;
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        b = input.nextInt();
        System.out.println(commonDivisors(a, b));
    }
    public static int commonDivisors(int a, int b) {
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        if (a * b == 0) {
            return 0;
        }
        int n = 0;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                n++;
            }
        }
        return n;
    }
}

import java.util.Scanner;

public class Fibonacci {
    public Fibonacci(int a, int b, int n) {

        for (int i = 0; i <= n; i++) {

            System.out.print(a + " ");

            int next = a + b;
            a = b;
            b = next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("enter the number of digits required in fibonacci: ");
        int n = sc.nextInt();

        int a = 0;
        int b = 1;

        System.out.print("the fibonacci series is: ");

        Fibonacci result = new Fibonacci(a, b, n);

        System.out.println(result);
        sc.close();
    }
}

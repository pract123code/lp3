import java.util.*;
import java.util.Scanner;

public class Fibonacci {
  static int steps=0;
    static int fib(int n) {
         steps++;
        if (n <= 1)
            return n;

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();
        System.out.println("fibo series:");
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
     System.out.println("no of steps:"+steps);
    }
}

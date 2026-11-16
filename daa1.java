import java.util.*;

import java.util.Scanner;

public class fibo{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int steps=0;
    System.out.println("enter the number of ste
                       ps:");
    int n=sc.nextInt();
    int a=0;
    int  b=1;
    System.out.println("fibo series:");
    for(int i=0;i<n; i++){
      System.out.print(a+" ");
      int c=a+b;
      a=b;
      b=c;
      steps++;

    }
    System.out.print("steps count:"+steps);
    
      }
}
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


import java.util.Scanner;

public class Fibonacci {

    static int recursiveSteps = 0;
    static int nonRecursiveSteps = 0;

    // Recursive Method
    static int recursive(int n) {
        recursiveSteps++;

        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        return recursive(n - 1) + recursive(n - 2);
    }

    // Non-Recursive Method
    static void nonRecursive(int n) {
        int a = 0, b = 1;

        for (int i = 0; i < n; i++) {

            System.out.print(a + " ");

            nonRecursiveSteps++;

            int c = a + b;
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        // Recursive Output
        System.out.println("\nRecursive Fibonacci:");

        for (int i = 0; i < n; i++) {
            System.out.print(recursive(i) + " ");
        }

        System.out.println("\nRecursive Step Count: " + recursiveSteps);

        // Non-Recursive Output
        System.out.println("\nNon-Recursive Fibonacci:");

        nonRecursive(n);

        System.out.println("\nNon-Recursive Step Count: " + nonRecursiveSteps);

        sc.close();
    }
}


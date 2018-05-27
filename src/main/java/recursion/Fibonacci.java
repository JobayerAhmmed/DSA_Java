package main.java.recursion;

import java.util.Scanner;

/**
 * Created by bsse0 on 9/12/2017.
 */
public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long fibonacciAtN = findFibonacciAt(n);
        System.out.println(n + "th Fibonacci number is " + fibonacciAtN);
        scanner.close();
    }

    public static long findFibonacciAt(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return (findFibonacciAt(n-1) + findFibonacciAt(n-2));
    }
}

package main.java.recursion;

import java.util.Scanner;

/**
 * Created by bsse0 on 9/12/2017.
 */
public class Factorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int n = scanner.nextInt();
        System.out.println(n + "! = " + factorial(n));
        scanner.close();
    }

    public static long factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n-1);
    }
}

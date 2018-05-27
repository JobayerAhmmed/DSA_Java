package main.java.utility;

import java.util.Scanner;

public class Factorial {

//    static char[] f = new char[10000];
    static StringBuilder f = new StringBuilder();
    static char[][] factorial = new char[1010][10000];

    static void multiply(int k) {
        int len = f.length();
        System.out.println("f.length = " + len);
        int sum = 0;
        int carry = 0;
        int i = 0;

        while (i < len) {
            sum = carry + (f.charAt(i) - '0') * k;
            f.insert(i, (char) ((sum % 10) + '0'));
            i++;
            carry = sum / 10;
        }

        while (carry > 0) {
            f.insert(i, (char) ((carry % 10) + '0'));
            i++;
            carry = carry / 10;
        }

//        f[i] = '\0';
        for (int j = 0; j < i; j++) {
            factorial[k][j] = f.charAt(j);
        }

//        factorial[k][i] = '\0';
    }

    static void fac() {
        factorial[0][0] = '1';
        factorial[1][0] = '1';
        f.insert(0, '1');
        for (int k = 2; k <= 1000; k++) {
            multiply(k);
        }
    }

    static void printFac(int n) {
        int len = factorial[n].length;
        System.out.println(n + "!");
        for (int i = len - 1; i >= 0; i--) {
            System.out.print(factorial[n][i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fac();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            printFac(n);
        }
        sc.close();
    }
}

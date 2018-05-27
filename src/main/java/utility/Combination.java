package main.java.utility;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/* nCr = n.(n-1).(n-2)...(n-r+1) / 1.2...r
   nCr = nCn-r

            n!
   nCr = --------
         r!(n-r)!
*/

/*
multiply two numbers from nominator
divide by 2
multiply by the 3rd number from nominator
divide by 3
...
multiply by the last number from the nominator
divide by r
*/

public class Combination {

    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = i+1;
        }
        printCombination(data, r);
        System.out.println(count);
    }

    public static void printCombination(int[] data, int r) {
        int[] temp = new int[r];
        combinationUtil(data, temp, 0, data.length-1, 0, r);
    }

    public static void combinationUtil(int[] data, int[] temp, int start, int end, int index, int r) {

        // Current combination is ready to be printed, print it
        if (index == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();
            count++;
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            temp[index] = data[i];
            combinationUtil(data, temp, i+1, end, index+1, r);
        }
    }

    public static int[][] getCombinations(int[] data, int r) {
        int n = data.length;
        int nCr = nCr(n, r);
        int[][] combinations = new int[nCr][r];
        int[] indices = new int[r];
        int index = 0;

        if (r <= n) {
            for (int i = 0; (indices[i]=i) < r-1; i++);
            combinations[index] = getSubArray(data, indices);
            index++;

            for (;;) {
                int i;
                for (i = r-1; i >= 0 && indices[i] == n-r+i; i--);
                if (i < 0)
                    break;
                indices[i]++;
                for(++i; i < r; i++) {
                    indices[i] = indices[i-1] + 1;
                }
                combinations[index] = getSubArray(data, indices);
                index++;
            }
        }
        return combinations;
    }

    public static int[] getSubArray(int[] data, int[] indices) {
        int n = indices.length;
        int[] subArray = new int[n];
        for (int i = 0; i < n; i++) {
            subArray[i] = data[indices[i]];
        }
        return subArray;
    }

    public static int nCr(int n, int r) {
        if (r == 0 || n == r)
            return 1;
        return nCr(n-1, r-1) + nCr(n-1, r);
    }

    public static BigInteger nCrBig(int n, int r) {
        BigInteger nominator = BigInteger.ONE;

        for (int i = n; i >= n - r + 1; i--) {
            nominator = nominator.multiply(BigInteger.valueOf(i));
        }
        BigInteger denominator= factorial(r);
        return nominator.divide(denominator);
    }

    public static BigInteger factorial(int n) {
        BigInteger f = new BigInteger("1");

        for (int i = 2; i <= n; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }

        return f;
    }
}

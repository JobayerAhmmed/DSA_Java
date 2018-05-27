package main.java.utility;

import java.util.Arrays;
import java.util.Scanner;

/*
            n!
    nPr = -------
          (n-r)!

    nPr = n.(n-1).(n-2)...(n-r+1)
 */

public class Permutation {

    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = i + 1;
        }
        permute(data, 0, n-1);
        System.out.println(count);
    }

    public static void permute(int[] data, int start, int end) {
        if (start == end) {
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
            count++;
        }
        else {
            for (int i = start; i <= end; i++) {
                swap(data, start, i);
                permute(data, start+1, end);
                swap(data, start, i);
            }
        }
    }

    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static int[][] getPermutations(int[] data, int r) {
        int n = data.length;
        int nPr = nPr(n, r);
        int[][] permutations = new int[nPr][r];
        int[] indices = new int[r];
        int index = 0;

        if (r <= n) {
            for (int i = 0; i < r-1; i++)
                indices[i] = i;

            permutations[index] = getSubArray(data, indices);
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
                permutations[index] = getSubArray(data, indices);
                index++;
            }
        }
        return permutations;
    }

    public static int[] getSubArray(int[] data, int[] indices) {
        int n = indices.length;
        int[] subArray = new int[n];
        for (int i = 0; i < n; i++) {
            subArray[i] = data[indices[i]];
        }
        return subArray;
    }

    public static int nPr(int n, int r) {
        if (r == 0 || n == r)
            return 1;
        return nPr(n-1, r-1) + nPr(n-1, r);
    }
}

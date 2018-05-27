package main.java.sort;

// Average case: O(n log n)
// Worst case: O(n^2) for sorted array
// Not stable sort: same values are not placed in the original place
// Divide and conquer

import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        sc.close();

        quicksort(data, 0, data.length - 1);

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public static void quicksort(int[] data, int low, int high) {
        if (low < high) {
            int p = partition(data, low, high);
            quicksort(data, low, p);
            quicksort(data, p + 1, high);
        }
    }

    public static int partition(int[] data, int low, int high) {
        int pivot = data[low + (high-low)/2];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (data[i] < pivot);

            do {
                j--;
            } while (data[j] > pivot);

            if (i >= j)
                return j;
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }
}

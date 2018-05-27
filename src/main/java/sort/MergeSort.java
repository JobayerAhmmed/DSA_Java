package main.java.sort;

// Worst case: O(n log n)
// Average case: O(n log n)
// Worst case space: O(n)

import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        sc.close();

        mergesort(data, 0, n-1);

        for (int i = 0; i < n; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public static void mergesort(int[] data, int left, int right) {
        if (left < right){
            int middle = (left + right) / 2;
            mergesort(data, left, middle);
            mergesort(data, middle+1, right);
            merge(data, left, middle, right);
        }
    }

    private static void merge(int[] data, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] dataLeft = new int[n1];
        int[] dataRight = new int[n2];

        for (int i = 0; i < n1; i++) {
            dataLeft[i] = data[left+i];
        }

        for (int i = 0; i < n2; i++) {
            dataRight[i] = data[middle+1+i];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (dataLeft[i] <= dataRight[j]) {
                data[k] = dataLeft[i];
                i++;
            }
            else {
                data[k] = dataRight[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            data[k] = dataLeft[i];
            i++;
            k++;
        }

        while (j < n2) {
            data[k] = dataRight[j];
            j++;
            k++;
        }
    }

    public static void mergesort(char[] data, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergesort(data, left, middle);
            mergesort(data, middle+1, right);
            merge(data, left, middle, right);
        }
    }

    private static void merge(char[] data, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        char[] dataLeft = new char[n1];
        char[] dataRight = new char[n2];

        for (int i = 0; i < n1; i++) {
            dataLeft[i] = data[left+i];
        }

        for (int i = 0; i < n2; i++) {
            dataRight[i] = data[middle+1+i];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (dataLeft[i] <= dataRight[j]) {
                data[k] = dataLeft[i];
                i++;
            } else {
                data[k] = dataRight[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            data[k] = dataLeft[i];
            i++;
            k++;
        }
        while (j < n2) {
            data[k] = dataRight[j];
            j++;
            k++;
        }
    }
}

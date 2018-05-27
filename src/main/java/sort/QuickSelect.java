package main.java.sort;

import java.util.Scanner;

public class QuickSelect {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] data = new int[] {10, 5, 15, 25, 50, 40, 30, 45, 35, 20};
        int k = sc.nextInt();
        sc.close();

        int kthSmallestItem = select(data, 0, data.length - 1, k);
        System.out.println(kthSmallestItem);
    }

    public static int select(int[] data, int left, int right, int k) {
        while (true) {
            if (left == right)
                return data[left];

            int pivotIndex = left + 1;
            pivotIndex = partition(data, left, right, pivotIndex);

            if (k == pivotIndex)
                return data[k];
            else if (k < pivotIndex)
                right = pivotIndex - 1;
            else
                left = pivotIndex + 1;
        }
    }

    public static int partition(int[] data, int left, int right, int pivotIndex) {
        int pivotValue = data[pivotIndex];
        data[pivotIndex] = data[right];
        data[right] = pivotValue;

        int storeIndex = left;
        int temp;
        for (int i = left; i < right; i++) {
            if (data[i] < pivotValue) {
                temp = data[storeIndex];
                data[storeIndex] = data[i];
                data[i] = temp;
                storeIndex++;
            }
        }
        temp = data[right];
        data[right] = data[storeIndex];
        data[storeIndex] = temp;
        return storeIndex;
    }
}

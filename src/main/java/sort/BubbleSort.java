package main.java.sort;

// O(N^2)

public class BubbleSort {

    public static void main(String[] args) {
        int[] data = new int[] {10, 5, 15, 20, 25};
        sort(data);

        for (int item: data) {
            System.out.print(item + " ");
        }
    }

    public static void sort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (data[j] > data[j+1]) {
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }
}

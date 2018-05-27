package main.java.sort;

// O(n + k)
// space: O(n + k)


public class CountingSort {

    public static void main(String[] args) {
        int[] data = new int[] {10, 5, 10, 15, 5, 15, 25, 10, 30, 25, 25, 30};
        int[] sortedData = countingsort(data);

        for (int i = 0; i < sortedData.length; i++) {
            System.out.print(sortedData[i] + " ");
        }
    }

    public static int[] countingsort(int[] data) {
        int n = data.length;
        int[] sortedData = new int[n];

        // find max value in data
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (data[i] > k)
                k = data[i];
        }

        // count each distinct values
        int[] count = new int[k+1];
        for (int i = 0; i < n; i++) {
            count[data[i]]++;
        }

        // set starting index of each distinct value
        int total = 0;
        for (int i = 0; i <= k; i++) {
            int oldCount = count[i];
            count[i] = total;
            total += oldCount;
        }

        // copy to output array, preserving order of inputs with equal values
        for (int i = 0; i < n; i++) {
            sortedData[count[data[i]]] = data[i];
            count[data[i]]++;
        }

        return sortedData;
    }
}

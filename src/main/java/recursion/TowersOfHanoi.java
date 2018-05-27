package main.java.recursion;

import java.util.Scanner;
import java.util.Stack;

/**
 * Move the top n – 1 disks from Source to Temporary tower,
 * Move the nth disk from Source to Destination tower,
 * Move the n – 1 disks from Temporary to Destination tower.
 */
public class TowersOfHanoi {

    public static Stack<Integer> source = new Stack<Integer>();
    public static Stack<Integer> temp = new Stack<Integer>();
    public static Stack<Integer> dest = new Stack<Integer>();
    public static int n;
    public static long moves = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        n = scanner.nextInt();
        scanner.close();

        for (int data = n; data > 0; data--) {
            source.push(data);
        }

        display();
        hanoi(n, source, temp, dest);
        System.out.println("Total Moves: " + moves);
    }

    public static void hanoi(int n, Stack<Integer> source, Stack<Integer> temp, Stack<Integer> dest) {
        if (n > 0) {
            // move n-1 disks from source to temp
            hanoi(n-1, source, dest, temp);

            // move nth disk from source to dest
            int data = source.pop();
            dest.push(data);

            moves++;
            display();

            // move n-1 disks from temp to dest
            hanoi(n-1, temp, source, dest);
        }
    }

    public static void display() {
        System.out.println("A | B | C");
        System.out.println("---------");

        for (int i = n-1; i >= 0; i--) {
            String a = "-", b = "-", c = "-";
            try {
                a = String.valueOf(source.get(i));
            } catch (Exception e){}
            try {
                b = String.valueOf(temp.get(i));
            } catch (Exception e){}
            try {
                c = String.valueOf(dest.get(i));
            } catch (Exception e){}
            System.out.println(a + " | " + b + " | " + c);
        }
        System.out.println();
    }
}

package main.java.array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    int V;
    LinkedList<Integer>[] adj;
    int[] color;

    public Solution(int v) {
        this.V = v;
        adj = new LinkedList[V];
        color = new int[V];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
            color[i] = 0;
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    public void dfs(int u) {
        color[u] = 1;

        Iterator<Integer> iterator = adj[u].listIterator();
        while (iterator.hasNext()) {
            int v = iterator.next();
            if (color[v] == 0) {
                dfs(v);
            }
        }

        color[u] = 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("F:\\Academic\\Programming\\Problem Solving\\UVa\\input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        int testcase = sc.nextInt();
        String line = sc.nextLine();
        line = sc.nextLine();

        for (int test = 0; test < testcase; test++) {
            String Vch = sc.nextLine();
            int nodes = (Vch.charAt(0) - 'A') + 1;

            Solution g = new Solution(nodes);

            String edge = sc.nextLine();
            while (edge.compareTo("") != 0) {
                g.addEdge(edge.charAt(0) - 'A', edge.charAt(1) - 'A');
                edge = sc.nextLine();
            }

            int subgraphs = 0;
            for (int u = 0; u < nodes; u++) {
                if (g.color[u] == 0) {
                    g.dfs(u);
                    subgraphs++;
                }
            }

            System.out.println(subgraphs);
            System.out.println();
        }
    }
}

package main.java.graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class DFSCycle {

    int V;
    LinkedList<Integer> adj[];

    public DFSCycle(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void detectCycle() {
        boolean[] visited = new boolean[V];
        int[] previous = new int[V];

        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                previous[u] = -1;
                visit(u, visited, previous);
            }
        }

//        if (!flag)
//            System.out.println("No cycle");
    }

    public void visit(int u, boolean[] visited, int[] previous) {
        boolean flag = false;
        if (visited[u] == false) {
            visited[u] = true;

            Iterator<Integer> iterator = adj[u].listIterator();
            while (iterator.hasNext()) {
                int v = iterator.next();
                if (!visited[v]) {
                    previous[v] = u;
                    visit(v, visited, previous);
                } else {
                    flag = true;
                    printCycle(v, u, previous);
                    break;
                }
            }
        }
        visited[u] = false;

//        if(flag)
//            printCycle(u, v, previous);
//        else
//            System.out.println("No cycle");
    }

    public void printCycle(int u, int v, int[] previous) {
        do {
            System.out.print(v + " ");
            v = previous[v];
        } while (u != v);
        System.out.println();
    }

    public void printPath(boolean[] path) {
        for (int i = 0; i < V; i++) {
            if (path[i])
                System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("F:\\Academic\\Programming\\Data Structure & Algorithm" +
                    "\\Data Structure & Algorithm\\src\\main\\java\\graph\\input\\dfscycle.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int V = sc.nextInt();
        int E = sc.nextInt();
        DFSCycle graph = new DFSCycle(V);
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        graph.detectCycle();
    }
}

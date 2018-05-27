package main.java.graph;

// Connected components - forest
// Cycle detection in a graph
// Path between two nodes
// Topological sort
// Finding strongly connected components

// traverse()
// traverseArbitrary()

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class DFS {

    private int V;
    private LinkedList<Integer>[] adj;

    public DFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void dfsIterative(int s) {
        boolean[] visited = new boolean[V];
        int[] previous = new int[V];

        for (int i = 0; i < V; i++) {
            previous[i] = -1;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        visited[s] = true;
        stack.push(s);

        while (!stack.isEmpty()) {
            int u = stack.pop();
            System.out.print(u + " ");

            Iterator<Integer> iterator = adj[u].listIterator();
            while (iterator.hasNext()) {
                int v = iterator.next();
                if (!visited[v]) {
                    visited[v] = true;
                    previous[v] = u;
                    stack.push(v);
                }
            }
        }
    }

    public void dfs(int s) {
        boolean[] visited = new boolean[V];
        int[] previous = new int[V];

        for (int i = 0; i < V; i++) {
            previous[i] = -1;
        }

        dfsUtil(s, visited, previous);
    }

    public void dfsUtil(int u, boolean[] visited, int[] previous) {
        visited[u] = true;
        System.out.print(u + " ");

        Iterator<Integer> iterator = adj[u].listIterator();
        while (iterator.hasNext()) {
            int v = iterator.next();
            if (!visited[v]) {
                previous[v] = u;
                dfsUtil(v, visited, previous);
            }
        }
    }

    // visit nodes from arbitrary sources
    // Depth First Forest
    public void dfsForest() {
        boolean[] visited = new boolean[V];
        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                int[] previous = new int[V];

                for (int i = 0; i < V; i++) {
                    previous[i] = -1;
                }

                dfsUtil(u, visited, previous);
                System.out.println();
            }
        }
    }

    public void printPath(int[] previous, int v) {
        if (previous[v] != -1) {
            printPath(previous, previous[v]);
            System.out.print(v + " ");
        } else {
            System.out.print(v + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("F:\\Academic\\Programming\\Data Structure & Algorithm\\" +
                    "Data Structure & Algorithm\\src\\main\\java\\graph\\input\\dfs.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("DFS:");
        int numberOfVertices = sc.nextInt();
        int numberOfEdges = sc.nextInt();
        DFS graph = new DFS(numberOfVertices);
        for (int i = 0; i < numberOfEdges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }
        int s = sc.nextInt();
        graph.dfs(s);
        System.out.println();

        System.out.println("DFS Forest");
        int forestV = sc.nextInt();
        int forestE = sc.nextInt();
        DFS forest = new DFS(forestV);
        for (int i = 0; i < forestE; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            forest.addEdge(u, v);
        }
        forest.dfsForest();

        System.out.println("DFS Iterative:");
        int iterativeV = sc.nextInt();
        int iterativeE = sc.nextInt();
        DFS dfsIterative = new DFS(iterativeV);
        for (int i = 0; i < iterativeE; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            dfsIterative.addEdge(u, v);
        }
        s = sc.nextInt();
        dfsIterative.dfsIterative(s);

        sc.close();
    }
}

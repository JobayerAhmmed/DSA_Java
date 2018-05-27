package main.java.graph;

// Shortest path between two nodes in a weighted graph.
// Shortest paths from source to other nodes

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

// shortestPath()
// traverse()
// printPathAll()
// printDistanceAll()

public class Dijkstra {

    int V;

    public Dijkstra(int v) {
        V = v;
    }

    public void traverse(int[][] w, int s) {
        boolean[] visited = new boolean[V];
        int[] previous = new int[V];
        int[] distance = new int[V];

        for (int i = 0; i < V; i++) {
            previous[i] = -1;
            distance[i] = Integer.MAX_VALUE;
        }

        distance[s] = 0;

        for (int i = 0; i < V-1; i++) {
            int u = minDistance(distance, visited);
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && w[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + w[u][v] < distance[v]) {
                    previous[v] = u;
                    distance[v] = distance[u] + w[u][v];
                }
            }
        }

        // print all shortest paths from source to other nodes
        printPathAll(previous, s);

        // print all shortest distances from source to other nodes
        printDistanceAll(distance, s);
    }

    public void shortestPath(int[][] w, int u, int v) {
        boolean[] visited = new boolean[V];
        int[] previous = new int[V];
        int[] distance = new int[V];

        for (int i = 0; i < V; i++) {
            previous[i] = -1;
            distance[i] = Integer.MAX_VALUE;
        }

        distance[u] = 0;

        boolean flag = false;
        for (int i = 0; i < V; i++) {
            int x = minDistance(distance, visited);
            visited[x] = true;

            if (x == v) {
                flag = true;
                break;
            }

            for (int y = 0; y < V; y++) {
                if (!visited[y] && w[x][y] != 0 && distance[x] != Integer.MAX_VALUE && distance[x] + w[x][y] < distance[y]) {
                    previous[y] = x;
                    distance[y] = distance[x] + w[x][y];
                }
            }
        }

        if (flag) {
            System.out.print("Path from " + u + " to " + v + ": ");
            printPath(previous, v);
            System.out.print(" Distance: ");
            printDistance(distance, v);
        }
        else
            System.out.println("No path exists from " + u + " to " + v);
    }

    public int minDistance(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int u = 0; u < V; u++) {
            if (!visited[u] && distance[u] <= min) {
                min = distance[u];
                minIndex = u;
            }
        }
        return minIndex;
    }

    public void printPath(int[] previous, int v) {
        if (previous[v] != -1) {
            printPath(previous, previous[v]);
            System.out.print(v + " ");
        }
        else
            System.out.print(v + " ");
    }

    public void printPathAll(int[] previous, int s) {
        for (int v = 0; v < V; v++) {
            if (v == s)
                continue;
            printPath(previous, v);
            System.out.println();
        }
    }

    public void printDistance(int[] distance, int v) {
        System.out.println(distance[v]);
    }

    public void printDistanceAll(int[] distance, int s) {
        System.out.println("Source Dest Distance");
        for (int v = 0; v < V; v++) {
            if (v == s)
                continue;
            System.out.println(" " + s + "\t\t" + v + "\t\t" + distance[v]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("F:\\Academic\\Programming\\Data Structure & Algorithm" +
                    "\\Data Structure & Algorithm\\src\\main\\java\\graph\\input\\dijkstra.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int numberOfVertices = sc.nextInt();
        Dijkstra graph = new Dijkstra(numberOfVertices);

        int numberOfEdges = sc.nextInt();
        int[][] weight = new int[numberOfVertices][numberOfVertices];

        for (int i = 0; i < numberOfEdges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            weight[u][v] = w;
        }
        sc.close();

        graph.traverse(weight, 0);
        graph.shortestPath(weight, 0, 4);
    }
}

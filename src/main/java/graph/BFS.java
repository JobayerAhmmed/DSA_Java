package main.java.graph;

// Shortest path between two nodes for unweighted or equal weighted graph
// All neighbors (peer to peer network - BitTorrent)
// All neighbors within k level (facebook - friends of friends)
// GPS navigation - find all neighboring locations
// Broadcasting in network - send broadcasted packet to all nodes
// Cycle detection in a graph

// For dense graph, use adjacency matrix
// For sparse graph, use adjacency list

// shortestPath()
// traverse()
// printAllPath()
// printAllDistance()

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    int V;
    LinkedList<Integer> adj[];

    public BFS(int v) {
        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public int[] traverse(int s) {
        boolean[] visited = new boolean[V];
        int[] previous = new int[V];

        for (int i = 0; i < V; i++) {
            previous[i] = -1;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");

            Iterator<Integer> iterator = adj[u].listIterator();
            while (iterator.hasNext()) {
                int v = iterator.next();
                if (!visited[v]) {
                    visited[v] = true;
                    previous[v] = u;
                    queue.add(v);
                }
            }
        }
        System.out.println();

        return previous;
    }

    // shortest path between two nodes
    public LinkedList<Integer> shortestPath(int u, int v) {
        boolean[] visited = new boolean[V];
        int[] previous = new int[V];
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            previous[i] = -1;
        }

        visited[u] = true;
        queue.add(u);

        boolean flag = false;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == v) {
                flag = true;
                break;
            }

            Iterator<Integer> iterator = adj[x].listIterator();
            while (iterator.hasNext()) {
                int y = iterator.next();
                if (!visited[y]) {
                    visited[y] = true;
                    previous[y] = x;
                    queue.add(y);
                }
            }
        }

        if (flag) {
            return constructPath(previous, v);
        }
        else
            return null;
    }

    public boolean isPresent(int x, LinkedList<Integer> path) {
        Iterator<Integer> iterator = path.listIterator();
        while (iterator.hasNext()) {
            int u = iterator.next();
            if (u == x)
                return true;
        }
        return false;
    }

    // paths from source to other nodes
    public void printAllPath(int s) {
        int[] previous = traverse(s);

        for (int v = 0; v < V; v++) {
            if (v == s)
                continue;
            printPath(previous, v);
            System.out.println();
        }
    }

    // distances from source to other nodes
    public void printAllDistance(int s) {
        int[] previous = traverse(s);

        for (int v = 0; v < V; v++) {
            if (v == s)
                continue;

            int count = 0;
            int u = v;
            while (previous[u] != -1) {
                u = previous[u];
                count++;
            }

            System.out.println("Distance from " + u + " to " + v + ": " + count);
        }
    }

    private LinkedList<Integer> constructPath(int[] previous, int v) {
        return constructPathUtil(previous, v, new LinkedList<>());
    }

    private LinkedList<Integer> constructPathUtil(int[] previous, int v, LinkedList<Integer> path) {
        if (previous[v] != -1) {
            path = constructPathUtil(previous, previous[v], path);
            path.add(v);
            return path;
        }
        else {
            path.add(v);
            return path;
        }
    }

    public void printPath(LinkedList<Integer> path) {
        Iterator<Integer> iterator = path.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
        System.out.println();
    }

    public void printPath(int[] previous, int v) {
        if (previous[v] != -1) {
            printPath(previous, previous[v]);
            System.out.print(v + " ");
        }
        else
            System.out.print(v + " ");
    }

    public void printPath(int u, int v) {
        LinkedList<Integer> path = shortestPath(u, v);
        printPath(path);
    }

    public void printDistance(int u, int v) {
        LinkedList<Integer> path = shortestPath(u, v);
        System.out.println("Distance from " + u + " to " + v + ": " + (path.size()-1));
    }

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("F:\\Academic\\Programming\\Data Structure & Algorithm\\" +
                    "Data Structure & Algorithm\\src\\main\\java\\graph\\input\\bfs.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int numberOfVertices = sc.nextInt();
        BFS graph = new BFS(numberOfVertices);

        int numberOfEdges = sc.nextInt();
        for (int i = 0; i < numberOfEdges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }
        int s = sc.nextInt();
        graph.traverse(s);

//        LinkedList<Integer> path = graph.shortestPath(1, 4);
//        graph.printPath(path);
//        graph.traverse();
//        graph.printAllPath(1);
//        graph.printAllDistance(1);

        sc.close();
    }
}
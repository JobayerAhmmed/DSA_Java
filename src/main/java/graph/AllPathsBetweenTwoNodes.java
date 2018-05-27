package main.java.graph;

// all possible paths between two nodes
// BFS based solution.

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AllPathsBetweenTwoNodes {

    int V;
    LinkedList<Integer> adj[];

    public AllPathsBetweenTwoNodes(int v) {
        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void allPaths(int src, int dst) {
        Queue<LinkedList<Integer>> queue = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();

        path.add(src);
        queue.offer(path);

        while (!queue.isEmpty()) {
            path = queue.poll();
            int u = path.getLast();

            if (u == dst)
                printPath(path);

            Iterator<Integer> iterator = adj[u].listIterator();
            while (iterator.hasNext()) {
                int v = iterator.next();
                if (!isPresent(v, path)) {
                    LinkedList<Integer> newPath = new LinkedList<>();
                    newPath.addAll(path);
                    newPath.add(v);
                    queue.offer(newPath);
                }
            }
        }
    }

    public boolean isPresent(int u, LinkedList<Integer> path) {
        Iterator<Integer> iterator = path.listIterator();
        while (iterator.hasNext()) {
            int x = iterator.next();
            if (x == u)
                return true;
        }
        return false;
    }

    public void printPath(LinkedList<Integer> path) {
        Iterator<Integer> iterator = path.listIterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("F:\\Academic\\Programming\\Data Structure & Algorithm" +
                    "\\Data Structure & Algorithm\\src\\main\\java\\graph\\input\\allPaths.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int V = sc.nextInt();
        int E = sc.nextInt();

        AllPathsBetweenTwoNodes graph = new AllPathsBetweenTwoNodes(V);
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        graph.allPaths(2, 3);
    }
}

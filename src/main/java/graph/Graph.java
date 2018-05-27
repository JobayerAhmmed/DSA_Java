package main.java.graph;

import java.util.*;

public class Graph<T> {

    int V;
    LinkedList<T> adj[];

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<T>();
        }
    }

//    public void addEdge(T u, T v)
}

package GraphAlgorithm;

import java.util.ArrayList;

// Graph representation using Adjacency List
public class adjacencyList {

    // Edge class to represent a connection from src -> dest
    static class Edge {
        int src;   // source vertex
        int dest;  // destination vertex

        // Constructor
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Method to create and initialize the graph
    public static void createGraph(ArrayList<Edge> graph[]) {
        // Initialize each list for every vertex
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Adding directed edges to the graph
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }

    public static void main(String[] args) {
        int v = 4;  // Number of vertices

        // Create an array of ArrayLists to hold the graph
        ArrayList<Edge> graph[] = new ArrayList[v];

        // Populate the graph with edges
        createGraph(graph);

        // Print all neighbors of vertex 2
        System.out.print("Neighbours of 2: ");
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.print(e.dest + " ");
        }
    }
}

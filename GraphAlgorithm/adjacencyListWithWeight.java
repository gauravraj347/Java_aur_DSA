package GraphAlgorithm;

import java.util.ArrayList;

// Graph representation using Adjacency List with Weights
public class adjacencyListWithWeight {

    // Inner class to represent an edge in the graph
    static class Edge {
        int src;     // source vertex
        int dest;    // destination vertex
        int weight;  // weight of the edge

        // Constructor to initialize an edge
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    // Method to create and initialize the graph
    public static void createGraph(ArrayList<Edge> graph[]) {
        // Initialize the adjacency list for each vertex
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Adding edges: new Edge(source, destination, weight)
        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, -1));
    }

    public static void main(String[] args) {
        int v = 4;  // Number of vertices

        // Create an array of ArrayLists to hold the adjacency list
        ArrayList<Edge>[] graph = new ArrayList[v];

        // Build the graph with edges and weights
        createGraph(graph);

        // Print all neighbors of vertex 2
        System.out.println("Neighbours of vertex 2:");
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println("To: " + e.dest + ", Weight: " + e.weight);
        }
    }
}

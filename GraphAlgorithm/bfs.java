package GraphAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Graph traversal using Breadth-First Search (BFS)
public class bfs {

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
        // Initialize the adjacency list for each vertex
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Adding edges (directed)
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }

    // Breadth-First Search traversal starting from node 0
    public static void bfs(ArrayList<Edge> graph[], int v) {
        Queue<Integer> q = new LinkedList<>();  // Queue for BFS
        boolean[] vis = new boolean[v];         // Visited array

        q.add(0);  // Start BFS from node 0

        while (!q.isEmpty()) {
            int curr = q.remove(); // Dequeue the current node

            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;

                // Add all unvisited neighbors to the queue
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 4;  // Number of vertices

        // Create an array of ArrayLists to represent the graph
        ArrayList<Edge>[] graph = new ArrayList[v];

        // Build the graph
        createGraph(graph);

        // Perform BFS traversal
        System.out.println("BFS traversal starting from node 0:");
        bfs(graph, v);
    }
}

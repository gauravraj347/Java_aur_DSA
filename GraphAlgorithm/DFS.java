package GraphAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// This class demonstrates BFS and DFS traversal on a directed graph
public class DFS {

    // Inner class to represent an edge between two vertices
    static class Edge {
        int src;   // source vertex
        int dest;  // destination vertex

        // Constructor to initialize edge
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Method to initialize the graph as an adjacency list
    public static void createGraph(ArrayList<Edge> graph[]) {
        // Create a new ArrayList for each vertex
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add directed edges from source to destination
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
    public static void bfs(ArrayList<Edge>[] graph, int v) {
        Queue<Integer> q = new LinkedList<>();  // Queue to store vertices
        boolean[] vis = new boolean[v];         // Visited array to avoid repetition

        q.add(0);  // Start BFS from node 0

        while (!q.isEmpty()) {
            int curr = q.remove();  // Dequeue the current node

            if (!vis[curr]) {
                System.out.print(curr + " ");  // Print the current node
                vis[curr] = true;              // Mark it visited

                // Add all adjacent vertices to the queue
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // Depth-First Search traversal starting from the current node
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        // Base case: return if the current node is already visited
        if (vis[curr]) return;

        System.out.print(curr + " ");   // Print the current node
        vis[curr] = true;               // Mark it visited

        // Recursively visit all unvisited adjacent vertices
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            dfs(graph, e.dest, vis);    // Recursive call for neighbor
        }
    }

    public static void main(String[] args) {
        int v = 4;  // Number of vertices in the graph

        // Create an array of ArrayLists to represent the adjacency list
        ArrayList<Edge>[] graph = new ArrayList[v];

        // Build the graph with edges
        createGraph(graph);

        // Perform BFS traversal
        System.out.println("BFS traversal starting from node 0:");
        bfs(graph, v);

        // Perform DFS traversal
        System.out.println("\nDFS traversal starting from node 0:");
        boolean[] vis = new boolean[v];  // Visited array for DFS
        dfs(graph, 0, vis);
    }
}

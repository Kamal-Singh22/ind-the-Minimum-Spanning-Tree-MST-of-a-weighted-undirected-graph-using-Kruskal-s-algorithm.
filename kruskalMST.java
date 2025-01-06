import java.util.*;

class KruskalMST {

    private int vertices;
    private List<Edge> edges = new ArrayList<>();

    public KruskalMST(int vertices) {
        this.vertices = vertices;
    }

    public void addEdge(int source, int destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }

    public void kruskalMST() {
        // Sort edges by weight
        edges.sort(Comparator.comparingInt(edge -> edge.weight));

        // Create a parent array for union-find
        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i; // Initialize each vertex as its own parent
        }

        List<Edge> mst = new ArrayList<>();
        int totalWeight = 0;

        for (Edge edge : edges) {
            int root1 = find(parent, edge.source);
            int root2 = find(parent, edge.destination);

            // If adding this edge doesn't form a cycle
            if (root1 != root2) {
                mst.add(edge);
                totalWeight += edge.weight;
                union(parent, root1, root2);
            }

            // Stop if we have enough edges for MST
            if (mst.size() == vertices - 1) break;
        }

        printMST(mst, totalWeight);
    }

    private int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]); // Path compression
        }
        return parent[vertex];
    }

    private void union(int[] parent, int root1, int root2) {
        parent[root2] = root1;
    }

    private void printMST(List<Edge> mst, int totalWeight) {
        System.out.println("Edges in the Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.source + " -- " + edge.destination + " == " + edge.weight);
        }
        System.out.println("Total Weight of MST: " + totalWeight);
    }

    private static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        KruskalMST graph = new KruskalMST(6);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 6);
        graph.addEdge(2, 3, 8);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 5, 10);
        graph.addEdge(3, 5, 4);

        graph.kruskalMST();
    }
}

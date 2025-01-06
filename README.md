# ind-the-Minimum-Spanning-Tree-MST-of-a-weighted-undirected-graph-using-Kruskal-s-algorithm.
Kruskal's Algorithm is used to find the Minimum Spanning Tree (MST) of a weighted, undirected graph. It selects edges in increasing order of weight, ensuring no cycles are formed, until all vertices are connected.
Explanation:
Graph Representation:

The graph is represented using an edge list. Each edge is an instance of the Edge class, containing source, destination, and weight.
Kruskal's Algorithm:

The edges are sorted by weight.
Union-Find (disjoint-set) is used to detect cycles efficiently. If two vertices belong to different sets, they can be connected without forming a cycle.
Union-Find Helper Methods:

find: Determines the root of a vertex with path compression to speed up subsequent operations.
union: Connects two sets by making one root point to the other.
Print MST:

Displays all edges in the MST and their total weight.

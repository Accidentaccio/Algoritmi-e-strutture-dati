package it.algoritmi.Grafi;

public class EdgeWeightedGraph {
    
    private final int V;
    private final Bag<Edge>[] adj;

    public EdgeWeightedGraph (int V) {
        this.V = V;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v=0; v<V; v++)
            adj[v] = new Bag<Edge>();
    }

    public void addEdge(Edge e) {
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
}

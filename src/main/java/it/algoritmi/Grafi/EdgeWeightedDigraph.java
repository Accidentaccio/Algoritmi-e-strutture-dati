package it.algoritmi.Grafi;

/**
 * Classe per la gestione di un grafo diretto e con archi pesati
 */
public class EdgeWeightedDigraph{
    private final int v; 
    private final Bag<DirectedEdge>[] adj; 

    public EdgeWeightedDigraph(int v) {
        this.v = v; 
        adj = (Bag<DirectedEdge>[]) new Bag[v]; 
        for(int x = 0; x < v; x++) 
            adj[x] = new Bag<DirectedEdge>(); 
    }

    public void addEdge(DirectedEdge edge) {
        int v = edge.from(); 
        adj[v].add(edge);
    }

    public Iterable<DirectedEdge> adj(int v) { 
        return adj[v]; 
    }

    public int V() {
        return adj.length;
    }
}

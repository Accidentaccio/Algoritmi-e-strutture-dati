package it.algoritmi.Grafi.MinimumSpanningTrees;

import it.algoritmi.IndexMinPQ;
import it.algoritmi.Grafi.Edge;
import it.algoritmi.Grafi.EdgeWeightedGraph;

/**
 * Implementazione eager dell'algoritmo di Prim, usato per trovare l'MST
 */
public class PrimEagerImplementation {
    private Edge[] edgeTo; 
    private double[] distTo; 
    private boolean[] marked; 
    private IndexMinPQ<Double> pq; 

    public PrimEagerImplementation(EdgeWeightedGraph g) {
        edgeTo = new Edge[g.V()]; 
        distTo = new double[g.V()]; 
        marked = new boolean[g.V()]; 
        for (int v = 0; v < g.V(); v++) 
            distTo[v] = Double.POSITIVE_INFINITY; 
        pq = new IndexMinPQ<>(g.V()); 

        distTo[0] = 0.0; 
        pq.insert(0, 0.0);
        while(!pq.isEmpty())
            visit(g, pq.delMin()); 
    }

    private void visit(EdgeWeightedGraph g, int v) {
        marked[v] = true; 
        for(Edge e : g.adj(v)) {
            int w = e.other(v); 
            if(marked[w]) continue; 
            if(e.weight() < distTo[w]) {
                edgeTo[w] = e; 
                distTo[w] = e.weight(); 
                if(pq.contains(w)) pq.change(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }
}

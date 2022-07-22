package it.algoritmi.Grafi.MinimumSpanningTrees;

import it.algoritmi.Grafi.DirectedEdge;
import it.algoritmi.Grafi.EdgeWeightedDigraph;
import it.algoritmi.StackEQueue.MyStackArray;
import it.algoritmi.IndexMinPQ; 

/**
 * Algoritmo per trovare percorso minimo all'interno di un grafo diretto
 */
public class DijkstraSP {
    private DirectedEdge[] edgeTo; 
    private double[] distTo; 
    private IndexMinPQ<Double> pq; 

    public DijkstraSP(EdgeWeightedDigraph g, int s) {
        edgeTo = new DirectedEdge[g.V()];
        distTo = new double[g.V()];
        pq = new IndexMinPQ<Double>(g.V()); 

        for (int v = 0; v < g.V(); v++) 
            distTo[v] = Double.POSITIVE_INFINITY; 
        distTo[s] = 0.0; 

        pq.insert(s, 0.0); 
        while(!pq.isEmpty()) {
            int v = pq.delMin(); 
            for(DirectedEdge e : g.adj(v))  
                relax(e);        
        }
    }

    private void relax(DirectedEdge e) {
        int v = e.from(), w = e.to(); 
        if(distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight(); 
            edgeTo[w] = e; 
            if(pq.contains(w)) pq.decreaseKey(w, distTo[w]); 
            else pq.insert(w, distTo[w]); 
        }
    }

    public double distTo(int v) {
        return distTo[v]; 
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        MyStackArray<DirectedEdge> path = new MyStackArray<DirectedEdge>(); 
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            path.push(e); 
        return path; 
    }
}

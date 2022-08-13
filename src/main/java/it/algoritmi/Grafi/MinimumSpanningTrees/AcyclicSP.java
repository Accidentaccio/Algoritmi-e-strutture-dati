package it.algoritmi.Grafi.MinimumSpanningTrees;

import io.undertow.server.handlers.cache.DirectBufferCache;
import it.algoritmi.Grafi.DirectedEdge;
import it.algoritmi.Grafi.EdgeWeightedDigraph;
import it.algoritmi.StackEQueue.MyStackArray;

/**
 * Algoritmo di ordinamento topologico.
 * Algoritmo per trovare il percorso minore su grafi pesati 
 * che non presentano cicli al loro interno.
 * Funziona anche con pesi negativi. 
 */
public class AcyclicSP {
    private DirectedEdge[] edgeTo; 
    private double[] distTo; 

    public AcyclicSP(EdgeWeightedDigraph g, int s) {
        edgeTo = new DirectedEdge[g.V()]; 
        distTo = new double[g.V()]; 

        for(int v = 0; v < g.V(); v++) 
            distTo[v] = Double.POSITIVE_INFINITY; 
        distTo[s] = 0.0; 

        // OTTENERE L'ORDINAMENTO TOPOLOGICO, MA BISOGNA CAMBIARE LA CLASSE O IMPLEMENTARNE UN'ALTRA 
        // TROPPO STANCO PER FARLO ORA 
        Topological top = new Topological(g); 

        for(int v : top.order()) 
            relax(g, v); 
    }

    private void relax(EdgeWeightedDigraph g, int v) {
        for (DirectedEdge e : g.adj(v)) {
            int w = e.to(); 
            if(distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight(); 
                edgeTo[w] = e; 
            }
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

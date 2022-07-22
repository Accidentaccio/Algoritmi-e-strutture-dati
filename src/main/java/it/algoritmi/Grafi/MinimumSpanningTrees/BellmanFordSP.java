package it.algoritmi.Grafi.MinimumSpanningTrees;

import it.algoritmi.Grafi.DirectedEdge;
import it.algoritmi.Grafi.EdgeWeightedCycleFinder;
import it.algoritmi.Grafi.EdgeWeightedDigraph;
import it.algoritmi.StackEQueue.MyQueueList;
import it.algoritmi.StackEQueue.MyStackArray;

/**
 * Algoritmo per trovare il percorso minimo all'interno di un
 * grafo pesato che contiene anche pesi negativi. 
 */
public class BellmanFordSP {
    private double[] distTo; 
    private DirectedEdge[] edgeTo; 
    private boolean[] onQ; 
    private MyQueueList<Integer> queue; 
    private int cost; 
    private Iterable<DirectedEdge> cycle; 

    public BellmanFordSP(EdgeWeightedDigraph g, int s) {
        distTo = new double[g.V()];
        edgeTo = new DirectedEdge[g.V()];
        onQ = new boolean[g.V()]; 
        queue = new MyQueueList<Integer>(); 

        for(int v = 0; v < g.V(); v++) 
            distTo[v] = Double.POSITIVE_INFINITY; 
        distTo[s] = 0.0; 
        queue.enqueue(s);
        onQ[s] = true; 
        while (!queue.isEmpty() && !this.hasNegativeCycle()) {
            int v = queue.dequeue(); 
            onQ[v] = false; 
            relax(g, v); 
        }
    }

    private void relax(EdgeWeightedDigraph g, int v) {
        for(DirectedEdge e : g.adj(v)) {
            int w = e.to(); 
            if(distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight(); 
                edgeTo[w] = e; 
                if(!onQ[w]) {
                    queue.enqueue(w); 
                    onQ[w] = true; 
                }
            }
            if(cost++ % g.V() == 0) 
                findNegativeCycle(); 
        }
    }

    private void findNegativeCycle() {
        int v = edgeTo.length; 
        EdgeWeightedDigraph spt = new EdgeWeightedDigraph(v); 
        
        for(int x = 0; x < v; x++) {
            if(edgeTo[v] != null)
                spt.addEdge(edgeTo[v]);
        }
    
        EdgeWeightedCycleFinder cf = new EdgeWeightedCycleFinder(spt); 
        cycle = cf.cycle(); 
    }

    public boolean hasNegativeCycle() {
        return cycle != null; 
    }

    public Iterable<DirectedEdge> negativeCycle() {
        return cycle; 
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

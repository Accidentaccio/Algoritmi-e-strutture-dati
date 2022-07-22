package it.algoritmi.Grafi;

import it.algoritmi.StackEQueue.MyStackArray;

/**
 * Classe per verificare la presenza di cicli all'interno di un grafo
 */
public class EdgeWeightedCycleFinder {
    private boolean[] marked; 
    private DirectedEdge[] edgeTo; 
    private MyStackArray<DirectedEdge> cycle; 
    private boolean[] onStack; 

    public EdgeWeightedCycleFinder(EdgeWeightedDigraph g) {
        onStack = new boolean[g.V()]; 
        edgeTo = new DirectedEdge[g.V()];
        marked = new boolean[g.V()];
        
        for(int v = 0; v < g.V(); v++) {
            if(!marked[v])
                dfs(g, v); 
        }
    }

    private void dfs(EdgeWeightedDigraph g, int v) {
        onStack[v] = true; 
        marked[v] = true; 
        for(DirectedEdge e : g.adj(v)) {
            int w = e.to(); 

            if(this.hasCycle()) return; 
            else if (!marked[w]) {
                edgeTo[w] = e; 
                dfs(g, w);
            }
            else if (onStack[w]) {
                cycle = new MyStackArray<DirectedEdge>(); 
                DirectedEdge x = e;

                for(; x.from() != w; x = edgeTo[x.from()]) {
                    cycle.push(x);
                }
                cycle.push(x);
                return; 
            }
        }

        onStack[v] = false; 
    }

    public boolean hasCycle() {
        return cycle != null; 
    }

    public Iterable<DirectedEdge> cycle() {
        return cycle; 
    }
}

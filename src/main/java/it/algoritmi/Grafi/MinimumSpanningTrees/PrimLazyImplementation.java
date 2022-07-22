package it.algoritmi.Grafi.MinimumSpanningTrees;

import it.algoritmi.MinPQ;
import it.algoritmi.Grafi.Edge;
import it.algoritmi.Grafi.EdgeWeightedGraph;
import it.algoritmi.StackEQueue.MyQueueList;

/**
 * Implementazione pigra dell'algoritmo di Prim, usato per trovare l'MST
 */
public class PrimLazyImplementation {
    // per i vertici marcati dell'MST
    private boolean[] marked; 
    // Coda per mantere gli archi all'interno dell'MST
    private MyQueueList<Edge> mst; 
    // Coda a priorità per gli archi
    private MinPQ<Edge> pq; 

    public PrimLazyImplementation(EdgeWeightedGraph g) {
        pq = new MinPQ<Edge>(); 
        mst = new MyQueueList<Edge>(); 
        marked = new boolean[g.V()]; 
        visit(g, 0); 

        while(!pq.isEmpty() && mst.size() < g.V()-1) {
            Edge e = pq.delMin(); 
            int v = e.either(), w = e.other(v); 
            // Nel caso in cui entrambi i vertici sono già marcati si va avanti senza fare più niente
            if(marked[v] && marked[w]) continue; 
            // Altrimenti si aggiunge l'arco all'albero e si esplorano i nodi non ancora marcati
            mst.enqueue(e);
            if(!marked[v]) visit(g, v);
            if(!marked[w]) visit(g, w);
        }
    }

    private void visit(EdgeWeightedGraph g, int v) {
        marked[v] = true; 
        for(Edge e : g.adj(v))
            if(!marked[e.other(v)])
                pq.insert(e);
    }

    public Iterable<Edge> mst() {
        return mst; 
    }
    
}

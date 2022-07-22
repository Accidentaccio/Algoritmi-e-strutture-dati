package it.algoritmi.Grafi.MinimumSpanningTrees;

import it.algoritmi.MinPQ;
import it.algoritmi.Grafi.Edge;
import it.algoritmi.Grafi.EdgeWeightedGraph;
import it.algoritmi.StackEQueue.MyQueueList;
import it.algoritmi.UnionFind.QuickUnion;


// NON TESTATA
public class KruskalMST {
    private MyQueueList<Edge> mst = new MyQueueList<Edge>(); 

    /* public Iterable<Edge> edges() {
        return mst; 
    } */

    public KruskalMST(EdgeWeightedGraph g) {
        MinPQ<Edge> pq = new MinPQ<Edge>();
        
        QuickUnion uf = new QuickUnion(g.V()); 
        while(!pq.isEmpty() && mst.size() < g.V()-1) {
            Edge e = pq.delMin(); 
            int v = e.either(), w = e.other(v); 

            if(!uf.connected(v, w)) {
                uf.union(v, w);
                mst.enqueue(e);
            }
        }
    }

}

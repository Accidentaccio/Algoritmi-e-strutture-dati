package it.algoritmi.Grafi;

import it.algoritmi.StackEQueue.MyStackArray;

public class DFSTopological {

    // L'array che mantiene se un nodo è marchiato o meno
    private boolean[] marked; 
    // Lo stack che mantiene il Post order
    private MyStackArray<Integer> postOrder; 

    /**
     * Algoritmo per l'ordinamento topologico.
     * @param g il grafo diretto da utilizzare per l'algoritmo.
     */
    public DFSTopological(Digraph g) {

        //Istanzio le variabili
        postOrder = new MyStackArray<Integer>(); 
        marked = new boolean[g.V()]; 

        /*
         * Per tutti i nodi viene eseguita la dfs se non sono marcati. Viene eseguita tramite ciclo, oltre che ricorsivamente nel caso in cui due nodi
         * non dovessero essere collegati e di conseguenza non vi sarebbe la "propagazione" della ricorsione.
         */
        
        for(int i = 0; i < g.V(); i++) {
            if(!marked[i])
                dfs(g, i); 
        }
    }

    /**
     * 
     * @param g Grafo diretto utilizzato per l'algoritmo.
     * @param v Il nodo di "partenza".
     */
    private void dfs(Digraph g, int v) {

        // Il nodo visitato viene marchiato
        marked[v] = true; 

        // Per tutti i nodi adiacenti a v, se non sono marchiati, viene richiamata la dfs.
        for(int w : g.getAdj(v))
            if(!marked[w]) 
                dfs(g, w); 
        
        // Il nodo v viene inserito nello stack
        postOrder.push(v);
    }

    /**
     * Iterando lo stack come una struttura dati di tipo LIFO il post order diventa così un reverse post order
     * difatto un ordinamento topologico
     * @return
     */
    public Iterable<Integer> reversePostOrder() {
        return postOrder; 
    }
}

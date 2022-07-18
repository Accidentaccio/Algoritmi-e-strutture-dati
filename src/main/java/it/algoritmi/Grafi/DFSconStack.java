package it.algoritmi.Grafi;

import java.util.Stack;

/**
 * Mancava la traccia nella rec, ma penso sia 
 * Implementare una DFS (Ricerca in profondità) iterativa utilizzando uno Stack
 */
public class DFSconStack {
    private boolean[] marked; 

    public void dfsUsingStack(Graph G, int s) {
        marked = new boolean[G.V()]; 

        // Setto tutti i nodi del grafo come non marcati
        // poiché non sono sicuro che lo siano (io pensavo lo facesse in automatico)
        for(int i = 0; i < G.V(); i++) {
            marked[i] = false; 
        }

        Stack<Integer> stack = new Stack<Integer>(); 
        // Inserisco il nodo sorgente all'interno dello stack
        stack.push(s); 

        // Accedo allo stack finché non è vuoto
        while(!stack.isEmpty()) {
            int vertex = stack.pop(); 

            // Controllo se il vertice restituito dal pop è già marcato
            // Se è già presente nell'array, non entro nell'if; 
            // altrimenti stampo il vertice e lo setto come marcato
            if(!marked[vertex]) {
                System.out.println(vertex);
                marked[vertex] = true; 
            }

            // Utilizzo un ciclo per prendere tutti quanti i vertici adiacenti 
            // al nodo restituito dall'operazione pop di prima
            for(int w : G.adj(vertex)){
                // Se i nodi adiacenti sono già marcati, non li inserisco più all'interno
                // dello stack. Nel caso contrario faccio un'operazione di push. 
                if(!marked[w]) 
                    stack.push(w); 
            }
        }
    }
}

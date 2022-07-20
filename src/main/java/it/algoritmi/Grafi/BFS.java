package it.algoritmi.Grafi;

import it.algoritmi.StackEQueue.MyQueueArray;

public class BFS {

    // L'array che mantiene se un nodo è marchiato o meno
    private boolean[] marked;
    // L'array che mantiene le informazioni sul percorso seguito
    private int[] edgeTo; 
    // L'array che mantiene la distanza da ogni nodo alla sorgente
    private int[] distTo;

    /**
     * Esegue l'algoritmo di BFS sul grafo passatogli come argomento.
     * @param g Il grafo utilizzato per l'algoritmo
     * @param s La sorgente del grafo
     */
    public BFS(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()]; 
        distTo = new int[g.V()]; 

        bfs(g, s); 
    }

    /**
     * 
     * @param g Il grafo utilizzato per l'algoritmo
     * @param s La sorgente del grafo
     */
    private void bfs(Graph g, int s) {
        
        MyQueueArray<Integer> q = new MyQueueArray<Integer>(); 
        q.enqueue(s);
        marked[s] = true; 
        distTo[s] = 0;

        while(!q.isEmpty()){
            int v = q.dequeue();  

            for(int w : g.adj(v)) {
                if(!marked[w]) {
                    q.enqueue(w);
                    marked[w] = true; 
                    edgeTo[w] = v; 
                    distTo[w] = distTo[v] + 1; 
                }
            }
        }
    }


    /**
     * Verifica se uno specifico nodo è stato visitato o meno in base a se è marchiato oppure no
     * @param v il nodo da controllare
     * @return true se il nodo è marcato, false altrimenti.
     */
    public boolean isMarked(int v) {
        return marked[v];
    }

    /**
     * Restituisce il nodo antecedente (nel percorso di esplorazione della dfs) al nodo v
     * @param v nodo di cui si vuole conoscere l'antecedente (nel percorso di esplorazione della dfs)
     * @return il nodo utilizzato per arrivare a v.
     */
    public int getEdge(int v) {
        return edgeTo[v];
    }

}

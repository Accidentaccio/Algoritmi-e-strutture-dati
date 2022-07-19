package it.algoritmi.Grafi;

public class DFS {
    
    // L'array che mantiene se un nodo è marchiato o meno
    private boolean[] marked;
    /* Indica il nodo precedente ad una determinata posizione, ovvero "mantiene"
     * una sorta di percorso.
     */ 
    private int[] edgeTo;

    /**
     * Setta le variabili di istanza e chiama la funzione di ricerca sul grafo passatogli
     * @param g il grafo su cui eseguire la ricerca
     * @param s la sorgente del grafo passato
     */
    public DFS(Graph g, int s) {
        //Istanziamo l'array marked con il numero di nodi nel grafo
        marked = new boolean[g.V()];
        //Istanziamo l'array edgeTo con il numero di nodi nel grafo
        edgeTo = new int[g.V()];

        //Metodo privato per la ricerca
        dfs(g, s);
    }

    /**
     * L'algoritmo effettivo di ricerca in profondità. Esplora il grafo andando
     * a settare in un array il percorso effettuato durante l'esplorazione.
     * @param g il grafo su cui eseguire la ricerca
     * @param v il nodo da cui partire per eseguire la ricerca.
     */
    private void dfs(Graph g, int v) {

        // Il nodo v a cui si accede è segnato come marchiato.
        marked[v] = true;

        // Per ogni nodo adiacente al nodo v
        for(int w: g.adj(v))
            
            // Se il nodo w (uno dei nodi adiacenti a v) non è marchiato
            if(!marked[w]) {
                // Si esegue ricorsivamente la funzione di ricerca su w
                dfs(g, w);
                // E infine si setta che al nodo w ci si è arrivati da v
                edgeTo[w] = v;                
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

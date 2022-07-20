package it.algoritmi.Grafi;

// Classe per la gestione delle componenti connesse
public class CC {
    
    // L'array che mantiene se un nodo è marchiato o meno
    private boolean[] marked;
    // L'array che mantiene per ogni nodo l'id della componente connessa a cui appartiene
    private int[] id;
    // Variabile di conteggio utilizzata per settare gli id delle compomenti
    private int count;

    /**
     * Esegue ripetutamente la funzione di DFS per analizzare il grafo e le componenti connesse al suo interno.
     * @param g Il grafo di cui si vogliono analizzare le componenti connesse.
     */
    public CC(Graph g) {

        marked = new boolean[g.V()];
        id = new int[g.V()];
        count = 0;

        for (int v=0; v<g.V(); v++) {
            if (!marked[v]) {
                dfs(g, v);
                count++;
            }
        }
    }

    /**
     * Funzione di DFS utilizzata per le componenti connesse.
     * @param g Il grafo di cui si vogliono analizzare le componenti connesse.
     * @param v La sorgente del grafo.
     */
    private void dfs (Graph g, int v) {

        marked[v] = true;
        id[v] = count;
        
        for (int w: g.adj(v))
            if (!marked[w])
                dfs(g, w);
    }

    /**
     * Verifica se due nodi sono connessi o meno.
     * @param v Primo nodo.
     * @param w Secondo nodo.
     * @return true se i nodi sono connessi, false altrimenti.
     */
    public boolean isConnectedTo(int v, int w) {
        return id[v] == id[w];
    }

    /**
     * Restituisce l'id della componente a cui appartiene il nodo v.
     * @param v Il nodo di cui si vuole conoscere l'id della componente a cui appartiene.
     * @return l'id della componente a cui appartiene il nodo v.
     */
    public int getID(int v) {
        return id[v];
    }

    /**
     * Restituisce il numero delle componenti connesse del grafo
     * @return il numero delle componenti connesse del grafo
     */
    public int getTotalNumberComponents() {
        return count;
    }

}

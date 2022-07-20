package it.algoritmi.Grafi;

/**
 * L'algoritmo di Korasaju-Sharir è utilizzato per ricercare in un grafo le componenti fortemente
 * connesse, ovvero un sottoinsieme massimale nel grafo i cui nodi sono tutte fortemente connessi, ovvero
 * se dato un nodo v e w, è possibile trovare un percorso diretto che va da v a w, e da w a v.
 * 
 * L'algoritmo si sviluppa in due fasi.
 * 
 * La prima consiste nel trovare il reverse post order, ovvero
 * l'ordinamento topologico, che altro non è che lo stesso grafo di partenza con i versi degli archi invertiti.
 * 
 * La seconda fase prevede che venga eseguita la DFS sul grafo visitando i nodi prima in maniera convenzionale
 * e poi seguendo l'ordinamento topologico. In questo modo si trovano le componenti connesse per entrambi i grafi.
 * Quelle in comune, ovvero le componenti connesse sia del grafo g, che del suo "reverse", saranno le componenti
 * fortemente connesse. Si mantiene inoltre in array di id, così da poter identificare a quale componente
 * appartengono i nodi.
 */
public class KosarajuSharir {

    // L'array che mantiene se un nodo è marchiato o meno
    private boolean[] marked;
    // L'array che mantiene per ogni nodo l'id della componente connessa a cui appartiene
    private int[] id;
    // Variabile di conteggio utilizzata per settare gli id delle compomenti
    private int count;

    public KosarajuSharir (Digraph g) {

        marked = new boolean[g.V()];
        id = new int[g.V()];

        DFSTopological dfs = new DFSTopological(g);
        for (int v: dfs.reversePostOrder())
            if (!marked[v]) {
                dfs(g, v);
                count++;
            }
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;
        id[v] = count;

        for (int w: g.adj(v))
            if (!marked[w])
                dfs(g, w);
    }

    public boolean isStronglyConnectedTo(int v, int w) {
        return id[v] == id[w];
    }
    
}

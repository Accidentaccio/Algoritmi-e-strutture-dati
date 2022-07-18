package it.algoritmi.Grafi;

public class Graph {
    //V numero di nodi
    private final int V; 
    /* Questo array di Bag rappresenta la matrice di adiacenza.
     * In ogni posizione dell'array di Bag vi sarà la lista di nodi adiacenti.
     */
    private Bag<Integer>[] adj; 
    
    /**
     * Istanzia in posizione dell'array di Bag un Bag creando così una matrice di adiacenza
     * che rappresenta il grafo vuoto.
     * @param V numero di nodi con cui costruire il grafo
     */
    public Graph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V]; 
        for (int i = 0; i < this.V; i++)
            adj[i] = new Bag<Integer>(); 
    }

    /**
     * Collega due nodi v e w aggiungendo un arco tra i due.
     * @param v primo nodo da collegare al secondo
     * @param w secondo nodo da collegare al primo
     */
    public void addEdge(int v, int w) {
        adj[v].add(w); 
        adj[w].add(v); 
    }

    /**
     * Restituisce la lista iterabile di nodi adiacenti ad un particolare nodo v.
     * @param v nodo di cui si vuole trovare la lista di nodi adiacenti
     * @return la lista iterabile di nodi adiacenti
     */
    public Iterable<Integer> adj(int v) {
        return adj[v]; 
    }

    /**
     * Restituisce il numero di nodi (grado) adiacenti ad un particolare nodo v.
     * @param v nodo di cui si vuole conoscere il grado
     * @return il grado di un particolare nodo v.
     */
    public int degree(int v) {
        int degree = 0; 
        for(int w : adj(v))
            degree++; 
        
        return degree; 
    }

    public int V() {
        return adj.length;
    }
}

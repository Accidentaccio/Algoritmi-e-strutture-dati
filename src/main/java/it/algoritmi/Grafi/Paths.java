package it.algoritmi.Grafi;

import it.algoritmi.StackEQueue.MyStackArray;

public class Paths {
    //Oggetto per la ricerca in profondità
    private DFS dfs;
    // Oggetto per la ricerca in ampiezza
    private BFS bfs; 
    // Nodo sorgente
    private int s; 

    /**
     * Setta le variabili d'istanza e crea un oggetto per la ricerca in profondità e in ampiezza
     * @param g grafo passato per la ricerca
     * @param s sorgente del grafo passato
     */
    public Paths(Graph g, int s) {
        this.s = s; 
        this.dfs = new DFS(g, this.s);
        this.bfs = new BFS(g, this.s); 
    }

    /**
     * Questo metodo verifica se c'è un percorso tra la sorgente e il nodo v.
     * @param v il nodo a cui arrivare partendo dalla sorgente.
     * @return true se esiste un percorso, false altrimenti.
     */
    public boolean hasPathToDFS(int v) {
        return dfs.isMarked(v);    
    }

    /**
     * Restituisce uno stack che mantiene il percorso effettuato per arrivare dalla sorgente al nodo v.
     * @param v il nodo di cui si vuole trovare il percorso utilizzato a partire dalla sorgente.
     * @return Uno stack che mantiene il percorso effettuato per arrivare dalla sorgente al nodo v.
     */
    public Iterable<Integer> pathToDFS(int v) {

        if(!hasPathToDFS(v)) 
            throw new NoPathsFindException();
            
        MyStackArray<Integer> stack = new MyStackArray<Integer> ();

        /* Si parte da v, l'ultimo nodo, e si va a ritroso fino alla sorgente
         * seguendo il percorso indicato dall'array edgeTo, che contiene le informazioni
         * sul nodo precedente utilizzato per arrivare al nodo i.
         */
        for (int i = v; i != s; i = dfs.getEdge(i))
            stack.push(i);
        
        /* Questa ultima istruzione non viene eseguita nel ciclo poichè si esce quando il nodo i è uguale a s
        quindi la si implementa manualmente. */
        stack.push(s);

        //Restituiamo stack, un oggetto iterabile che mantiene l'ordine del percorso.
        return stack;
    }    
    
    
    /**
     * Questo metodo verifica se c'è un percorso tra la sorgente e il nodo v.
     * @param v il nodo a cui arrivare partendo dalla sorgente.
     * @return true se esiste un percorso, false altrimenti.
     */
    public boolean hasPathToBFS(int v) {
        return bfs.isMarked(v);    
    }


    /**
     * Restituisce uno stack che mantiene il percorso effettuato per arrivare dalla sorgente al nodo v.
     * @param v il nodo di cui si vuole trovare il percorso utilizzato a partire dalla sorgente.
     * @return Uno stack che mantiene il percorso effettuato per arrivare dalla sorgente al nodo v.
     */
    public Iterable<Integer> pathToBFS(int v) {
        if(!hasPathToBFS(v)) 
            throw new NoPathsFindException();
            
        MyStackArray<Integer> stack = new MyStackArray<Integer> ();

        /* Si parte da v, l'ultimo nodo, e si va a ritroso fino alla sorgente
         * seguendo il percorso indicato dall'array edgeTo, che contiene le informazioni
         * sul nodo precedente utilizzato per arrivare al nodo i.
         */
        for (int i = v; i != s; i = bfs.getEdge(i))
            stack.push(i);
        
        /* Questa ultima istruzione non viene eseguita nel ciclo poichè si esce quando il nodo i è uguale a s
        quindi la si implementa manualmente. */
        stack.push(s);

        //Restituiamo stack, un oggetto iterabile che mantiene l'ordine del percorso.
        return stack;
    } 


}

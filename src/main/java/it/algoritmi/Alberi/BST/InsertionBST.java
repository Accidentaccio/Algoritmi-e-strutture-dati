package it.algoritmi.Alberi.BST;

/**
 * Algoritmo per eseguire l'inserzione di un nodo all'interno di un BST. 
 */
public class InsertionBST {

    /**
     * Inserisce un nodo in un BST. 
     * @param root La radice dell'albero in cui inserire il nodo.
     * @param key la chiave del nodo da inserire.
     */
    public static void insert(Node root, Comparable key) {
        Node tempRoot = null; 
        int cmp = 0; 

        // Se l'albero è vuoto viene inserito il nodo come radice
        if(root == null) {
            root = new Node(key); 
            return; 
        }
        
        /**
         * Con il while si trova la posizione in cui andare ad inserire il nodo.
         * In particolare si salva nella variabile tempRoot il padre a cui aggiungere il nodo come figlio.
         */
        while(root != null) {
            cmp = key.compareTo(root.key); 

            tempRoot = root; 
            if(cmp < 0) 
                root = root.left; 
            else if (cmp > 0)
                root = root.right; 
            else return; 
        }
        
        /**
         * cmp è il risultato dell'ultimo compareTo effettuato.
         * Se è minore di 0, il nodo viene inserito come figlio sinistro; 
         * altrimenti viene inserito come figlio destro. 
         * Non viene gestito il caso in cui cmp == 0, in quanto è già gestito all'interno del while. 
         */
        if(cmp < 0)
            tempRoot.left = new Node(key);  
        else 
            tempRoot.right = new Node(key);
    }

    private static class Node {
        Comparable key; 
        Node left, right;

        public Node(Comparable key) {
            this.key = key; 
            this.left = this.right = null; 
        }
    }

    public static void main(String[] args) {
        /* Creiamo il seguente BST
              100
           /     \
          20      500
         /  \    
       10   30   
             \    
             40  
       */
        Node a = new Node(100);
        Node b = new Node(20);
        Node c = new Node(10);
        Node d = new Node(30);
        Node e = new Node(40);
        Node f = new Node(500);
 
        a.left = b; 
        a.right = f;

        b.left = c; 
        b.right = d; 

        d.right = e; 


        insert(a, 25);
        System.out.println(d.left.key);

        insert(a, 27);
        System.out.println(d.left.right.key);
    }
}

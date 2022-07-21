package it.algoritmi.Alberi.BST;

public class RicercaBST {
    
    /**
     * Esegue la ricerca di uno specifico nodo in un BST.
     * @param root La radice dell'albero in cui inserire il nodo.
     * @param key La chiave del nodo da inserire.
     * @return il nodo che contiene la chiave, se esiste, altrimenti null.
     */
    public static Node searchBST(Node root, Comparable key) {
        
        if(root == null) 
            return null; 
        
        
        while(root != null) {
            int cmp = key.compareTo(root.key); 

            if(cmp < 0) 
                root = root.left; 
            else if (cmp > 0)
                root = root.right; 
            else 
                return root; 
        }

        // Se si esce dal ciclo while di sopra la chiave cercata non è presente nell'albero
        return null;
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


        Node node = searchBST(a, 11);
        System.out.println(node.key);

    }


    private static class Node {
        Comparable key; 
        Node left, right;

        public Node(Comparable key) {
            this.key = key; 
            this.left = this.right = null; 
        }
    }
}

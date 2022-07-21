package it.algoritmi.Alberi;

public class RedBlack {
    
    private static final boolean RED = true;
    private static final boolean BLACK = false;


    private static boolean isRed(Node node) {
        
        // I collegamenti NULL per default sono neri.
        if (node == null) return false;
        return node.color == RED;
    }

    /**
     * 
     * @param root La radice dell'albero da analizzare.
     * @param key La chiave del nodo da trovare.
     * @return il valore del nodo trovato se esiste, altrimenti null.
     */
    public static Object get(Node root, Comparable key) {

        if(root == null) 
            return null; 
        
        
        while(root != null) {
            int cmp = key.compareTo(root.key); 

            if(cmp < 0) 
                root = root.left; 
            else if (cmp > 0)
                root = root.right; 
            else 
                return root.value; 
        }

        // Se si esce dal ciclo while di sopra la chiave cercata non è presente nell'albero
        return null;
    }

    private static Node rotateLeft(Node h) {

        assert isRed(h.right);

        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private static Node rotateRight(Node h) {

        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    







    private static class Node {

        Comparable key;
        Object value;
        Node left, right;
        boolean color;

        public Node(Comparable key, Object value) {

            this.key = key; 
            this.value = value;
            this.left = this.right = null;
            //Quando si aggiungono nodi, di default vengono aggiunti come nodi 3, ovvero con il collegamento rosso.
            this.color = RED; 
        }
    }
}

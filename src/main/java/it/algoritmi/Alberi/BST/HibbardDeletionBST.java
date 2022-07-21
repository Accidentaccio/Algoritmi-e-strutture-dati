package it.algoritmi.Alberi.BST;

public class HibbardDeletionBST {
    public static Node delete(Node root, Comparable key) {
        if(root == null) return null; 

        int cmp = key.compareTo(root.key); 
        if(cmp < 0) root.left = delete(root.left, key); 
        else if (cmp > 0) root.right = delete(root.right, key);
        else {
            if(root.right == null) return root.left;
            if(root.left == null) return root.right;

            Node temp = root; 
            root = min(temp.right); 
            root.right = deleteMin(temp.right); 
            root.left = temp.left;
        }

        // root.count = size(root.left) + size(root.right) + 1; 
        return root; 
    }

    /**
     * Metodo per cercare il minimo all'interno di un albero binario di ricerca
     * @param padre è il nodo radice del sottoalbero
     * @return il nodo minimo 
     */
    private static Node min(Node padre) {
        while(padre.left != null) {
            padre = padre.left; 
        }
        return padre; 
    }

    private static Node deleteMin(Node n) {
        if (n.left == null)
            return n.right;
        n.left = deleteMin(n.left);      

        // n.count= 1 + size(n.left)+ size(n.right);   
                                                
        return n;
     }



    private static class Node {
        Comparable key; 
        Node left, right; 
    }



    public static void main(String[] args) {
        Node a = new Node();
        a.key = 27;
        Node b = new Node();
        b.key = 14;
        Node c = new Node();
        c.key = 10;
        Node d = new Node();
        d.key = 19;
        Node e = new Node();
        e.key = 35;
        Node f = new Node();
        f.key = 31;
        Node g = new Node();
        g.key = 42;

        a.left = b;
        a.right = e;

        b.left = c;
        b.right = d;

        e.left = f;
        e.right = g;

        Node node = delete(a, 10); 

        System.out.println(node.key);

        System.out.println(c.key); 
    }
}

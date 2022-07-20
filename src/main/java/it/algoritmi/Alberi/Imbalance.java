package it.algoritmi.Alberi;

/**
 * L'algoritmo trova l'imbalance all'interno di un albero binario. L'imbalance è la differenza in valore assoluto
 * tra il numero di nodi foglia nel sottoalbero sinistro e destro.
 * Complessità -> O(n)
 */
public class Imbalance {

    public static int imbalance(Node radice) {
        int countSx = 0, countDx = 0; 
        int sx = contaFoglie(radice.left, countSx); 
        int dx = contaFoglie(radice.right, countDx); 

        return Math.abs(sx - dx); 
    }

    private static int contaFoglie(Node padre, int count) {
        if(padre.left != null) {
            count = contaFoglie(padre.left, count); 
        }
        if(padre.right != null) {
            count = contaFoglie(padre.right, count); 
        }
        else 
            count++; 

        return count; 
    }


    public static void main(String[] args) {

        Node a = new Node();
        a.item = "a";
        Node b = new Node();
        b.item = "b";
        Node c = new Node();
        c.item = "c";
        Node d = new Node();
        d.item = "d";
        Node e = new Node();
        e.item = "e";
        Node f = new Node();
        f.item = "f";
        Node g = new Node();
        g.item = "g";
        Node h = new Node();
        h.item = "h";
        Node i = new Node();
        i.item = "i";
        Node j = new Node();
        j.item = "j";
        Node k = new Node();
        k.item = "k";
        
        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.left = f;
        c.right = g;

        g.left = h;
        g.right = i;

        h.left = j;
        h.right = k;

        System.out.println(imbalance(a));
        
        
    }
}

class Node{
    Object item; 
    Node left, right; 
}
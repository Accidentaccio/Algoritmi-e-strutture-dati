package it.algoritmi.Alberi;

/**
 * L'algoritmo trova l'imbalance all'interno di un albero binario. L'imbalance è la differenza in valore assoluto
 * tra il numero di nodi foglia nel sottoalbero sinistro e destro.
 * Complessità -> O(n)
 */
public class Imbalance {
    private int numFoglieSx = 0; 
    private class Node{
        Object item; 
        Node left, right; 
    }

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
        else if(padre.right != null) {
            count = contaFoglie(padre.right, count); 
        }
        else 
            count++; 

        return count; 
    }
}
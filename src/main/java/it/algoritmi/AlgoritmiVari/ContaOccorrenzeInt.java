package it.algoritmi.AlgoritmiVari;

import ch.qos.logback.core.joran.conditional.ElseAction;

/**
 * Conta il numero di occorrenze del numero 2 all'interno di un array di interi (che sono solo 1, 2 e 3) ordinati in maniera crescente 
 * Complessità -> O(logN)
 */
@SuppressWarnings("rawtypes")
public class ContaOccorrenzeInt {

    public static void main(String args[]) {
        Comparable[] array  = {1, 1, 1, 2, 2, 2, 3, 3, 3}; 

        System.out.println("DioCane: " + binarySearchLastOccurence(array, 3)); 
    }
    
    public static int contaOccorrenze(Comparable[] a) {
        int lastTwo = 0, lastOne = 0; 

        // Controllo se nella prima posizione c'é un 3 o se nell'ultima posizione c'é un 1. 
        // Visto che l'array è ordinato in modo crescente, se accade una delle due condizioni significa che non ci sono 2 all'interno dell'array
        if (a[a.length-1].compareTo(1) == 0 || a[0].compareTo(3) == 0) {
            return 0; 
        }

        lastTwo = binarySearchLastOccurence(a, 2); 
        lastOne = binarySearchLastOccurence(a, 1);

        return (lastTwo - lastOne); 
    }




    private static int binarySearchLastOccurence(Comparable[] a, Comparable occ) {
        int low = 0, mid = 0, high = a.length-1; 

        while (low < high) {
            mid = low + (high-low)/2; 

            if(a[mid].compareTo(occ) > 0)
                high = mid - 1; 
            else if (a[mid].compareTo(occ) < 0)
                low = mid; 
            else if ((a[mid].compareTo(occ) == 0) && (a[mid] != a[mid+1]))
                return mid;
            else
                low = mid+1;

        }
        return low; 
    }

/*     private static int binarySearchLastOccurence(Comparable[] a, Comparable occ) {
        int low = 0, mid = 0, high = a.length-1; 

        while (low < high) {
            mid = low + (high-low)/2; 

            if(a[mid].compareTo(occ) > 0)
                high = mid - 1; 
            else if (a[mid].compareTo(occ) < 0)
                low = mid + 1; 
            else if(high == low + 1 && (a[high].compareTo(a[low]) == 0))
                return high;
            else if(high == low + 1 && (a[high].compareTo(a[low]) != 0))
                return low;
            else
                low = mid;

        }
        return low; 
    } */
} 

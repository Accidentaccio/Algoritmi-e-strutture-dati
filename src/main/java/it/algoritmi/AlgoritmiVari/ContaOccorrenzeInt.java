package it.algoritmi.AlgoritmiVari;


/**
 * Conta il numero di occorrenze del numero 2 all'interno di un array di interi (che sono solo 1, 2 e 3) ordinati in maniera crescente 
 * Complessità -> O(logN)
 */
@SuppressWarnings("rawtypes")
public class ContaOccorrenzeInt {

    public static void main(String args[]) {
        Comparable[] array  = {1, 1, 1, 2, 2, 2, 3, 3, 3}; 
        int[] arrayInt  = {1, 1, 1, 2, 2, 2, 3, 3, 3}; 

        System.out.println("\n\n");
        System.out.println("Conta occorrenze di 2: " + contaOccorrenze(array)); 
        System.out.println("Conta occorrenze di 2 (professore): " + FindElements.numberOfTwo(arrayInt));
        System.out.println("\n\n");
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



    /**
     * Implementazione del professore
     */
    public static class FindElements {

        public static int numberOfTwo(int[] A) {
            int n = A.length-1; 

            // Gli indici h e k rappresentano rispettivamente l'indice dell'ultimo 1 e dell'ultimo 2
            int h, k; 

            // Se nell'ultima posizione dell'array c'è un 1, significa che 
            // non ci sono 2 all'interno dell'array
            if(A[n] == 1) {
                return 0; 
            }

            // Se nella prima posizione dell'array c'è un 2 significa che
            // non ci sono 1 all'interno dell'array, quindi setto l'indice h = 0
            if(A[0] == 2) {
                h = 0; 
            }
            else {
                // Utilizzo la ricerca binaria per trovare l'indice h
                h = binarySearchLastX(A, 1, 1, n); 
            }

            // Se nell'ultima posizione dell'array c'è un 2 significa che
            // non ci sono 3 all'interno dell'array, quindi setto l'indice k = n
            if(A[n] == 2) {
                k = n; 
            }
            else {
                // Utilizzo la ricerca binaria per trovare l'indice k
                k = binarySearchLastX(A, 2, 0, n-1); 
            }

            return (k-h); 
        }

        private static int binarySearchLastX(int[] A, int x, int i, int j) {
            if(i > j) {
                return -1; 
            }

            int m = (i+j)/2; 

            if(A[m] == x && A[m+1] > x) {
                return m;
            }

            if(A[m] > x) {
                return binarySearchLastX(A, x, i, m-1);
            }
            else {
                return binarySearchLastX(A, x, m+1, j);
            }
        }

    }
} 

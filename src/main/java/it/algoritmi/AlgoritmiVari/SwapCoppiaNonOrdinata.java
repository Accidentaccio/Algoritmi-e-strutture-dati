package it.algoritmi.AlgoritmiVari;

/**
 * Questo algoritmo esegue uno swap dell'unica coppia non ordinata all'interno di una array ordinato in modo crescente.
 * Complessità -> O(n)
 */
public class SwapCoppiaNonOrdinata {
    public static void swapCoppia(int[] a) {
        int min = -1, max = -1; 

        for(int i = 0; i < a.length-1; i++) {
            if(a[i] > a[i+1]) {
                if(max != -1) {
                    min = i+1; 
                    break; 
                }

                max = i; 
                min = i+1; 
            }
        }

        exch(a, min, max); 
    }

    private static void exch(int[] a, int min, int max) {
        int temp = a[min]; 
        a[min] = a[max]; 
        a[max] = temp;
    }


    public static void main(String[] args) {
        int[] a = {3, 8, 6, 10, 11, 12}; 

        swapCoppia(a); 
        for(int el : a) 
            System.out.println(el);
    }
}

package it.algoritmi.AlgoritmiOrdinamento;

/* Confronti in qualsiasi caso = N^2/2
   Numero di scambi = N */

public class SelectionSort {
    
    public static void selectionSort (Comparable a[]) {
        
        for (int i = 0; i < a.length; i++) {

            int min = i;
            for (int j=i+1; j<a.length; j++)
                if (less(a[j], a[min]))
                    min = j;
            
                exch(a, i, min); 
            
        }
    }


    private static boolean less (Comparable a, Comparable b) {
        
        return a.compareTo(b) < 0;
    }

    private static void exch (Comparable a[], int x, int y) {

        Comparable temp = a[x];
        a[x] = a[y];
        a[y] = temp;

    }

    
}



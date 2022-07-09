package it.algoritmi.AlgoritmiOrdinamento;

import it.algoritmi.Shuffle.ShuffleSort;

public class QuickSort {
    
    public static void quickSort (Comparable[] a) {
        ShuffleSort.shuffle(a);
        sort(a, 0, a.length-1);
        
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int j = partition(a, low, high);
        sort(a, low, j-1);
        sort(a, j+1, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low, j=high+1;

        while (true) {
            while(less(a[++i], a[low]))
                if (i == high) break;
            
            while (less(a[low], a[--j]))
                if (j == low) break;

            if (i>=j) break;

            exch(a, i, j);
        }

        exch (a, low, j);
        return j;
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

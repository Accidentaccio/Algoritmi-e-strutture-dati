package it.algoritmi.AlgoritmiOrdinamento;

@SuppressWarnings("rawtypes")
public class prova {

    public static void mergeSort(Comparable[] a) {
        
        Comparable[] aux = a.clone();
        sort (a, aux, 0, a.length-1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int low, int high) {
        if (high <= low) return;
        int mid = low + (high-low)/2;
        sort(aux, a, low, mid);
        sort(aux, a, mid+1, high);
        merge(aux, a, low, mid, high);
    }

    private static void merge (Comparable[] a, Comparable[] aux, int low, int mid, int high) {
        
        int i = low, j=mid+1;

        for (int k=low; k<=high; k++) {
            if (i>mid) aux[k] = a[j++];
            else if (j>high) aux[k] = a[i++];
            else if (less(a[i], a[j])) aux[k] = a[i++];
            else aux[k] = a[j++];
        }
    }
    
    private static boolean less (Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch (Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}


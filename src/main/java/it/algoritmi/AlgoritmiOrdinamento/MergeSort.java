package it.algoritmi.AlgoritmiOrdinamento;

@SuppressWarnings("rawtypes")
public class MergeSort {
    
    private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
        aux = a.clone(); 

        int i = low, j = mid+1; 
        for(int k = low; k <= high; k++) {
            if(i > mid) a[k] = aux[j++]; 
            else if(j > high) a[k] = aux[i++]; 
            else if(less(aux[j], aux[i])) a[k] = aux[j++]; 
            else a[k] = aux[i++];
        }
    }

    private static void mergeMigliorato(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
        
        int i = low, j = mid+1; 
        for(int k = low; k <= high; k++) {
            if(i > mid) aux[k] = a[j++]; 
            else if(j > high) aux[k] = a[i++]; 
            else if(less(a[j], a[i])) aux[k] = a[j++]; 
            else aux[k] = a[i++];
        }
    }

    private static boolean less(Comparable j, Comparable i){
        return (j.compareTo(i) < 0); 
    }

    private static void sort(Comparable[] a, Comparable[] aux, int low, int high) {
        if (high <= low) return; 
        int mid = low + (high - low)/2; 
        sort(a, aux, low, mid); 
        sort(a, aux, mid+1, high); 
        merge(a, aux, low, mid, high); 
    }

    private static void sortMigliorato(Comparable[] a, Comparable[] aux, int low, int high) {
        if (high <= low) return; 
        int mid = low + (high - low)/2; 
        sortMigliorato(aux, a, low, mid); 
        sortMigliorato(aux, a, mid+1, high); 
        mergeMigliorato(aux, a, low, mid, high); 
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length]; 
        sort(a, aux, 0, a.length-1); 
    }

    public static void sortMigliorato(Comparable[] a) {
        Comparable[] aux = a.clone(); 
        sortMigliorato(a, aux, 0, a.length-1); 
    }


}

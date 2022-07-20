package it.algoritmi.AlgoritmiVari;

import it.algoritmi.AlgoritmiOrdinamento.MergeSort;

/**
 * Questo algoritmo trova il massimo prodotto tra due elementi dell'array. 
 * Complessità -> inferiore a O(n^2)
 */
public class MassimoProdottoArray {
    public static int massimoProdotto(int[] a) {
        if(a.length < 2) {
            System.out.println("L'array è composto da meno di due elementi.");
            return 0; 
        }

        sortMigliorato(a);
        int maxN = a[0] * a[1]; 
        int maxP = a[a.length-1] * a[a.length-2]; 

        if(maxP > maxN) {
            System.out.println("Il massimo prodotto è " + maxP + ", ottenuto moltiplicando: " + a[a.length-1] + " e " + a[a.length-2]);
            return maxP;
        }
        else {
            System.out.println("Il massimo prodotto è " + maxN + ", ottenuto moltiplicando: " + a[0] + " e " + a[1]);
            return maxN;
        }
    }
 
    public static void main(String[] args) {
        int[] a = {0, 10, 5, -10, 5, -10}; 

        massimoProdotto(a); 
    }


    
    private static void sortMigliorato(int[] a) {
        int n = a.length; 
        int[] aux = new int[n]; 
        for(int i = 0; i < n; i++)
            aux[i] = a[i]; 
        
            
        sort(a, aux, 0, n-1); 
    }

    private static void sort(int[] a, int[] aux, int low, int high) {
        if(high <= low) return; 
        
        int mid = low + (high-low)/2;
        sort(aux, a, low, mid); 
        sort(aux, a, mid+1, high); 
        merge(aux, a, low, mid, high); 
    }

    private static void merge(int[] a, int[] aux, int low, int mid, int high) {
        int i = low, j = mid + 1; 

        for(int k = low; k <= high; k++) {
            if(i > mid) aux[k] = a[j++]; 
            else if (j > high) aux[k] = a[i++];
            else if(a[j] < a[i]) aux[k] = a[j++];
            else aux[k] = a[i++];
        }
    }

}  

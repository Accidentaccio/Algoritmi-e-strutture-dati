package it.algoritmi.AlgoritmiRicerca;

import it.algoritmi.AlgoritmiOrdinamento.InsertionSort;

public class BinarySearch {

    public static void main (String[] args) {
        Comparable num[] = {1, 5, 6, 7, 9, 10, 44, 78, 2, 54, 10, 21, 45, 63, 97, 87, 54, 23, 12, 15, 64, 52, 97, 35, 45, 78};
        InsertionSort.insertionSort(num);

        int[] copia = new int[num.length];
        
        for (int count = 0; count < num.length; count++) 
            copia[count] = (Integer) num[count];
        
            
        int posizione = binarySearch(copia, 44);
        System.out.println("Posizione: " + posizione + "\nElemento: " + copia[posizione]);
    }
    
    public static int binarySearch (int[] array, int key) {
        int low = 0, high = array.length-1;

        while (low <= high) {

            int mid = low + (high - low)/2;
            if (key > array[mid])
                low = mid+1;
            else if (key < array[mid])
                high = mid-1;
            else
                return mid;
        }

        return -1;
    }
}

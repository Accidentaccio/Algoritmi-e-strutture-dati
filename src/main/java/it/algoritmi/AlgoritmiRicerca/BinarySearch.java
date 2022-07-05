package it.algoritmi.AlgoritmiRicerca;

import java.util.Random;

import it.algoritmi.AlgoritmiOrdinamento.InsertionSort;

@SuppressWarnings("rawtypes")
public class BinarySearch {

    public static void main (String[] args) {

        final int MAX_NUMBER = 5000;

        Comparable[] num = new Comparable[MAX_NUMBER];

        Random rand = new Random();
        for (int count=0; count<MAX_NUMBER; count++)
            num[count] = rand.nextInt(5000);
        

        InsertionSort.insertionSort(num);

        /* Creazione di un array di int dove copiare gli elementi comparable per eseguire una ricerca binaria */
        int[] copia = new int[MAX_NUMBER];
        
        for (int count=0; count<MAX_NUMBER; count++) 
            copia[count] = (Integer) num[count];
        
            
        int posizione = binarySearch(copia, 44);
        System.out.println("Posizione: " + posizione);
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

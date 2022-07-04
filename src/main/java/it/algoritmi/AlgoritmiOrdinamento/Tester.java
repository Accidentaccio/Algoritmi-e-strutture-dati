package it.algoritmi.AlgoritmiOrdinamento;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

public class Tester {
    
    public static void main(String[] args) {

        StopWatch s = new StopWatch();
        s.start();

        testSelectionSort();
        //testInsertionSort();

        System.out.println("\n" + s.getTime(TimeUnit.MILLISECONDS));

    }



    private static void testSelectionSort () {

        // Variabili
        Comparable num[] = {1, 5, 6, 7, 9, 10, 44, 78, 2, 54, 10, 21, 45, 63, 97, 87, 54, 23, 12, 15, 64, 52, 97, 35, 45, 78};
        Comparable arrayChar[] = {'I', ' ', 't', 'o', 'p', 'i', ' ', 'n', 'o', 'n', ' ', 'a', 'v', 'e', 'v', 'a', 'n', 'o', ' ', 'n', 'i', 'p', 'o', 't', 'i'};

        //Testo di ordinamento numerico
        SelectionSort.selectionSort(num);
        for (Comparable c: num)
            System.out.print(c + " ");


        System.out.println();


        // Test con un array di caratteri
        SelectionSort.selectionSort(arrayChar);
        for (Comparable c: arrayChar)
            System.out.print(c + " ");
    }


    private static void testInsertionSort () {

        Comparable num[] = {1, 5, 6, 7, 9, 10, 44, 78, 2, 54, 10, 21, 45, 63, 97, 87, 54, 23, 12, 15, 64, 52, 97, 35, 45, 78};
        Comparable arrayChar[] = {'I', ' ', 't', 'o', 'p', 'i', ' ', 'n', 'o', 'n', ' ', 'a', 'v', 'e', 'v', 'a', 'n', 'o', ' ', 'n', 'i', 'p', 'o', 't', 'i'};

        //Testo di ordinamento numerico
       InsertionSort.insertionSort(num);
        for (Comparable c: num)
            System.out.print(c + " ");


        System.out.println();


        // Test con un array di caratteri
        InsertionSort.insertionSort(arrayChar);
        for (Comparable c: arrayChar)
            System.out.print(c + " ");

    }
}

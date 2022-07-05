package it.algoritmi.AlgoritmiOrdinamento;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

@SuppressWarnings("rawtypes")
public class Tester {    
    
    public static void main(String[] args) throws InterruptedException {

        final int MAX_NUMBER = 60000;

        Comparable[] num1 = new Comparable[MAX_NUMBER];
        Comparable[] num2 = new Comparable[MAX_NUMBER];
        Comparable arrayChar[] = {'I', ' ', 't', 'o', 'p', 'i', ' ', 'n', 'o', 'n', ' ', 'a', 'v', 'e', 'v', 'a', 'n', 'o', ' ', 'n', 'i', 'p', 'o', 't', 'i'};

        Random rand = new Random();
        for (int count=0; count<MAX_NUMBER; count++)
            num1[count] = rand.nextInt(5000);
        
        num2 = num1.clone();

        StopWatch s = new StopWatch();
        s.start();
        SelectionSort.selectionSort(num1);
        //SelectionSort.selectionSort(arrayChar);
        System.out.println("SelectionSort's time: " + s.getTime(TimeUnit.MILLISECONDS));

       s.reset();
       s.start();
        
        InsertionSort.insertionSort(num2);
        //SelectionSort.selectionSort(arrayChar);
        System.out.println("InsertionSort's time: " + s.getTime(TimeUnit.MILLISECONDS));

    }

}

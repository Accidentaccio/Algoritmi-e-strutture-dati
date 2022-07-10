package it.algoritmi.AlgoritmiOrdinamento;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

@SuppressWarnings("rawtypes")
public class Tester {    
    
    public static void main(String[] args) {

        final int MAX_NUMBER = 30000;

        Comparable[] num1 = new Comparable[MAX_NUMBER];
        Comparable[] num2 = new Comparable[MAX_NUMBER];
        Comparable[] num3 = new Comparable[MAX_NUMBER]; 
        Comparable[] num4 = new Comparable[MAX_NUMBER]; 
        Comparable[] num5 = new Comparable[MAX_NUMBER];
        Comparable[] num6 = new Comparable[MAX_NUMBER]; 
        Comparable[] num7 = new Comparable[MAX_NUMBER]; 
        Comparable arrayChar[] = {'I', ' ', 't', 'o', 'p', 'i', ' ', 'n', 'o', 'n', ' ', 'a', 'v', 'e', 'v', 'a', 'n', 'o', ' ', 'n', 'i', 'p', 'o', 't', 'i'};

        Random rand = new Random(System.currentTimeMillis());
        for (int count=0; count<MAX_NUMBER; count++)
            num1[count] = rand.nextInt(5000);
        
        num2 = num1.clone();
        num3 = num1.clone(); 
        num4 = num1.clone();
        num5 = num1.clone();
        num6 = num1.clone();
        //num7 = num1.clone();
        for (int i=0; i<MAX_NUMBER; i++)
            num7[i] = i;


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


        s.reset(); 
        s.start();

        MergeSort.sort(num3); 
        System.out.println("MergeSort's time: " + s.getTime(TimeUnit.MILLISECONDS));

        s.reset(); 
        s.start();

        MergeSort.sortMigliorato(num4);
        System.out.println("MergeSort's improved time: " + s.getTime(TimeUnit.MILLISECONDS));

        s.reset(); 
        s.start();

        ShellSort.shellSort(num5);
        System.out.println("ShellSort's time: " + s.getTime(TimeUnit.MILLISECONDS));

        s.reset(); 
        s.start();        

        QuickSort.quickSort(num6);
        System.out.println("QuickSort's time: " + s.getTime(TimeUnit.MILLISECONDS));
        
        s.reset(); 
        s.start();

        QuickSort.ThreeWayQuickSort(num7);
        System.out.println("3WayQuickSort's time: " + s.getTime(TimeUnit.MILLISECONDS));
        
    }

}

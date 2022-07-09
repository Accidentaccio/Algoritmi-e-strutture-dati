package it.algoritmi.Shuffle;

import java.util.Random;

public class ShuffleSort {
    
    public static void shuffle (Comparable[] a) {
        Random random = new Random(System.currentTimeMillis());

        for (int i=0; i<a.length; i++)
            exch(a, random.nextInt(0, i+1), i);

    }

    private static void exch (Comparable a[], int x, int y) {

        Comparable temp = a[x];
        a[x] = a[y];
        a[y] = temp;

    }
}

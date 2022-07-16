package it.algoritmi.AlgoritmiOrdinamento;

@SuppressWarnings("rawtypes")
public class BinaryInsertion {

    
    public static void binaryInsertion(Comparable[] a) {
        
        for (int i=1; i<a.length; i++) {
            int pos = binarySearchPosition(a, i);
            exch(a, pos, i);
        }
    }

    private static int binarySearchPosition(Comparable[] a, int i) {

        int low = 0, high = i;

        int mid = 0;
        while (high > low) {
            mid = low + (high-low)/2;
            if (less(a[i], a[mid]))
                high = mid;
            else if (less(a[mid], a[i]))
                low = mid+1;
            else
                return mid;
        }

        return high;
    }

    private static void exch (Comparable[] a, int pos, int i) {

        Comparable temp = a[i];

        for (int j=i; j>pos; j--)
            a[j] = a[j-1];

        a[pos] = temp;
    }



    private static boolean less (Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
}

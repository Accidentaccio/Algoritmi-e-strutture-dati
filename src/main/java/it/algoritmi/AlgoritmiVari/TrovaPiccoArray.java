package it.algoritmi.AlgoritmiVari;

/**
 * Questo algoritmo trova un elemento di picco all'interno di un'array. Un picco è un elemento i cui vicini sono entrambi minori o il suo unico vicino, nel caso 
 * in cui si trovi ad una delle estremità dell'array. 
 * Complessità -> inferiore a O(n)
 */
public class TrovaPiccoArray {
    // Funzione ricorsiva per trovare l'indice di un elemento di picco in un array
    public static int findPeakElement(int[] a, int left, int right)
    {
        // trova l'elemento centrale. 
        int mid = (left + right) / 2;
 
        // controlla se l'elemento centrale è maggiore dei suoi vicini
        if ((mid == 0 || a[mid - 1] <= a[mid]) &&
                (mid == a.length - 1 || a[mid + 1] <= a[mid])) {
            return mid;
        }
 
        // Se il vicino sinistro di `mid` è maggiore dell'elemento centrale,
        // trova il picco in modo ricorsivamente nel subarray sinistro
        if (mid - 1 >= 0 && a[mid - 1] > a[mid]) {
            return findPeakElement(a, left, mid - 1);
        }
 
        // Se il vicino destro di `mid` è maggiore dell'elemento centrale,
        // trova il picco in modo ricorsivamente nel subarray di destra
        return findPeakElement(a, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] a = {8, 9, 10, 2, 5, 6}; 
        System.out.println(a[findPeakElement(a, 0, a.length-1)]);
    }
}

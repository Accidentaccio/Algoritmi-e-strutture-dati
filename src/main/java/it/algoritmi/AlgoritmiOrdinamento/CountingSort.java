package it.algoritmi.AlgoritmiOrdinamento;

public class CountingSort {

    public static void main(String[] args) {
        int[] array = {2, 1, 4, 1, 3};
        countingSort(array);

        for(int n: array)
            System.out.println(n);
    }
    

    /**
     * 
     * @param a array su cui effettuare l'algoritmo
     * 
     * In questa versione, gli elementi nell'array NON possono essere maggiori del riempimento dell'array stesso
     */
    public static void countingSort(int[] a) {

        int[] counter = new int[a.length];

        //Incrementiamo i valori dell'array utilizzato per il conteggio nella specifica posizione
        for (int num: a)
            counter[num]++;

        sort(a, counter);
        

    }

    private static void sort(int[] a, int[] counter) {

        int j = 0;

        for (int i=0; i<counter.length; i++) 
            while (counter[i]-- > 0) 
                a[j++] = i;           
        
    }
    
}

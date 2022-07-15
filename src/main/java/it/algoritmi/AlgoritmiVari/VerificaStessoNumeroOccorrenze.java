package it.algoritmi.AlgoritmiVari;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

/*
 * Scrivere un programma per verificare se esistono almeno due valori
 * distinti che compaiono lo stesso numero di volte in un dato array.
 * Complessità < O(n^2)
 */
public class VerificaStessoNumeroOccorrenze {
    
    public static void main (String[] args) {

        //int[] a = {3, 5, 5, 3, 4, 7, 4, 3, 5, 5, 3, 4, 7, 4, 21, 56, 87, 7};

        int[] a = new int[1000];

        //Creazione di un array randomico
        Random rand = new Random(System.currentTimeMillis());
        for (int count=0; count<a.length; count++)
            a[count] = rand.nextInt(1000);

        StopWatch s = new StopWatch();
        s.start();

        boolean esito = verificaStessoNumeroOccorrenze(a);
                
        System.out.println(s.getTime(TimeUnit.MILLISECONDS));
        System.out.println(esito);
       
    }

    public static boolean verificaStessoNumeroOccorrenze(int[] a) {

        //Costruisco l'array counter sulla base del massimo intero dell'array A.
        int max = findMax(a);

        int[] counter = new int[max+1];

        //Incrementiamo i valori dell'array counter utilizzato per il conteggio nella specifica posizione
        for (int num: a)
            counter[num]++;
        

        
        //Ordinamento dell'array counter. Non è importante infatti mantenere le posizioni, basta solo che due di questi siano uguali
        mergeSort(counter);
       
        //Se due elementi vicini (esclusi gli 0) sono uguali, vuol dire che sono presenti nello stesso numero.
        for (int i=0; i<counter.length; i++) {
            if (counter[i] == 0)
                i++;
            else if (counter[i] == counter[i+1])
                return true;  
        }
        return false;       

    }

    private static int findMax (int[] a) {
        int max = 0;
        for (int num: a) {
            if (num > max)
                max = num;
        }
        return max;
    }


    public static void mergeSort(int[] a) {
        int[] aux = a.clone(); 
        sortMigliorato(a, aux, 0, a.length-1); 
    }

    private static void sortMigliorato(int[] a, int[] aux, int low, int high) {
        if (high <= low) return; 
        int mid = low + (high - low)/2; 
        sortMigliorato(aux, a, low, mid); 
        sortMigliorato(aux, a, mid+1, high);
        mergeMigliorato(aux, a, low, mid, high); 
    }

    private static void mergeMigliorato(int[] a, int[] aux, int low, int mid, int high) {
        
        int i = low, j = mid+1; 
        for(int k = low; k <= high; k++) {
            if(i > mid) aux[k] = a[j++]; 
            else if(j > high) aux[k] = a[i++]; 
            else if(a[j] < a[i]) aux[k] = a[j++]; 
            else aux[k] = a[i++];
        }
    }

}

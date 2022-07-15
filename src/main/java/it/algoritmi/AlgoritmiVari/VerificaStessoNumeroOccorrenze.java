package it.algoritmi.AlgoritmiVari;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
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

        // Utilizza la seconda implementazione
        Object[] array = {5, 5, 7, 3, 7, 7};
        esito = VerificaOccorrenze.sameValues(array);
        System.out.println("\nEsito: " + esito + "\n");
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





    /**
     * IMPLEMENTAZIONE DEL PROFESSORE
     */

    public static class VerificaOccorrenze {
        
        public static boolean sameValues(Object array[]) {
    
            // Si utilizza una HashMap per contare le occorrenze di ogni oggetto
            HashMap<Object, Integer> counts = new HashMap<Object, Integer>();
            // Se la chiave non è all'interno della mappa viene aggiunta
            // altrimenti si prende l'occorrenza della chiave e si incrementa di 1
            for(Object o : array) {
                if(!counts.containsKey(o))
                    counts.put(o, 1); 
                else {
                    int count = counts.get(o); 
                    counts.put(o, count+1); 
                }
            }

            return hasDuplicates(counts.values().toArray(new Integer[counts.values().size()])); 
        }
    
        // Mediante questo metodo si costruisce un HashSet al cui interno vengono 
        // inseriti i valori corrispondenti alle occorrenze dei vari oggetti
        private static boolean hasDuplicates(Integer[] values) {
            Set<Integer> checkDup = new HashSet<Integer>(); 
            for (int i = 0; i < values.length; i++) {
                // Appena si tenta di inserire un valore che è già presente all'interno del Set
                // il metodo ritorna true, in quanto ciò significa che sono stati trovati due oggetti
                // che occorrono lo stesso numero di volte all'interno dell'array
                // Se si esce dal ciclo si ritorna false, poiché non sono state trovate due occorrenze uguali
                if(checkDup.contains(values[i])) return true; 
                checkDup.add(values[i]); 
            }
            
            return false; 
        }
    }

}

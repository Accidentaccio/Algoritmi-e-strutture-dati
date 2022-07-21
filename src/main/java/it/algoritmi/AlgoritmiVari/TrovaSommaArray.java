package it.algoritmi.AlgoritmiVari;

import java.util.HashMap;

/**
 * Questo algoritmo verifica se all'interno di un array esiste una combinazione di due elementi 
 * la cui somma è pari ad x, fornito come parametro. 
 * Complessità -> O(N)
 */
public class TrovaSommaArray {
    
    public static boolean trovaSommaArray(int[] a, int x) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        
        for(int i = 0; i < a.length; i++) {
            if(map.containsKey(x - a[i])) {
                // Stampa gli elementi e la loro posizione
                System.out.println("Gli elementi all'interno dell'array la cui somma è " + x + " sono " + a[i] + " e " + (x - a[i]) + " le cui posizioni all'interno " +
                "dell'array sono rispettivamente: " + i + " e " + map.get(x - a[i]));
                
                return true; 
            }

            map.put(a[i], i); 
        }

        return false;
    }


    public static void main(String[] args) {
        int[] array = {10, 4, 6, 8, 2, 5, 1, 5, 3};

        trovaSommaArray(array, 3); 
    }
}

package it.algoritmi.AlgoritmiVari;

import java.util.HashMap;

/**
 * Questo algoritmo esegue un prodotto tra una matrice ed un vettore
 */
public class ProdottoMatrici {
    
    public static double[] prodottoMatrice(double[][] matrice, double[] vettore) {
        int lengthVec = vettore.length; 
        int lengthMat = matrice.length; 

        if(lengthVec != lengthMat)
            return null; 
        
        double[] prodotto = new double[lengthVec]; 
        for(int i = 0; i < lengthVec; i++) {
            double somma = 0.0; 
            for(int j = 0; j < lengthVec; j++)
                somma += matrice[i][j] * vettore[j]; 
            prodotto[i] = somma; 
        }

        return prodotto; 
    }


    /**
     * Calcola il prodotto tra una matrice sparsa (formata da un array di vettori sparsi)
     * e un vettore. 
     * Questo permette di eseguire solo le operazioni che non comportano un prodotto
     * con gli 0. Ciò rende le prestazioni dell'algoritmo lineari. 
     * @param vetSparso -> matrice sparsa
     * @param vettore -> vettore da moltiplicare
     * @return il vettore prodotto
     */
    public static double[] prodottoMatriceSparsa(SparseVector[] vetSparso, double[] vettore) {
        double[] prodotto = new double[vettore.length]; 

        for (int i = 0; i < vettore.length; i++)
            prodotto[i] = vetSparso[i].dot(vettore); 
        
        return prodotto; 
    }




    /**
     * Classe per un vettore sparso.
     * Un vettore (o una matrice) sparso è un vettore in cui gran parte degli 
     * elementi è uguale a 0.  
     */
    public class SparseVector {
        private HashMap<Integer, Double> sv; 
        
        public SparseVector() {
            sv = new HashMap<Integer, Double>(); 
        }

        public void put(int key, double value) {
            sv.put(key, value); 
        }

        public double get(int key){
            if(!sv.containsKey(key)) return 0.0; 
            else return sv.get(key); 
        }

        public Iterable<Integer> indices() {
            return sv.keySet(); 
        }

        public double dot(double[] that) {
            double somma = 0.0; 
            for(int i : indices()) {
                somma += that[i] * this.get(i); 
            }

            return somma; 
        }
    }
}



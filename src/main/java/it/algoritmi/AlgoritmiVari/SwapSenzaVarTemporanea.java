package it.algoritmi.AlgoritmiVari;

public class SwapSenzaVarTemporanea {
    
    public static void main(String[] args) {
        int a = 3;
        int b = 7;

        swap(a, b);
        
    }


    public static void swap (int a, int b) {

        a += b;
        b = a-b;
        a -= b;

        System.out.println(a + " " + b);

    }
}

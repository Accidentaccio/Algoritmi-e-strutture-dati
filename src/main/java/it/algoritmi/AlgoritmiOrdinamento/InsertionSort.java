package it.algoritmi.AlgoritmiOrdinamento;


    /* Spiegazione dell'algoritmo:
     * 
     * Si tratta di dividere concettualmente l'array in due parti,
    di cui la sinistra ordinata e la destra da ordinare. Inizialmente la parte sinistra potrebbe essere nulla, ovvero
    con un array tutto disordinato.
    Questo algoritmo segue la logica di ordinamento che seguirebbe un essere umano.
    Il ciclo esterno come al solito è per il confronto con il singolo elemento, il ciclo interno invece questa volta
    va a spostare volta per volta nella giusta posizione l'elemento analizzato, shiftando eventualmente i più grandi
    verso destra. Appunto un "inserzione" nel giusto punto dell'array, come suggerisce il nome.

    Gli scambi ripetuti fino alla corretta posizione, effettuati con la funzione "exch", permettono di "shiftare"
    gli elementi più grandi.

    Il caso peggiore si ha quando l'array è reversed, cioè ordinato al contrario. In questo caso bisognerebbe portare ogni
    elemento nella posizione diametralmente opposta, e quindi effettuare più scambi.
    In questo caso infatti, bisogna eseguire confronti multipli per tutti gli elementi dell'array, quasi come se fosse un
    selection sort, e infatti il numero di confronti coincide con (N^2 + N)/2, quindi con una complessità di O(n^2).

    Nel caso medio, possiamo possiamo ipotizzare che gli elementi si trovino appunto a metà del loro massimo tragitto
    e che quindi il numero di confronti medio possa essere la metà di quello nel caso peggiore, ovvero (N^2 + N)/4,
    e quindi ancora con una complessità di O(n^2).

    Nel caso migliore, l'array è già ordinato, quindi vengono eseguiti N-1 confronti, quindi complessità O(N) e logicamente
    0 scambi.

    Questo algoritmo lavora bene con array parzialmente ordinati, in particolare quando il numero di scambi effettuati
    si avvicina, o è addirittura uguale al numero di inversioni effettuate, ovvero quando ogni scambio va a mettere
    nella sua corretta posizione un elemento (invece di dover fare tanti scambi per una sola inversione).

     */
   
@SuppressWarnings("rawtypes")
public class InsertionSort {

    public static void insertionSort(Comparable a[]) {

        for (int i=0; i<a.length; i++)
            for (int j=i; j>0; j--)
                if (less(a[j], a[j-1]))
                    exch(a, j, j-1);
                else
                    break;

    }

    private static boolean less (Comparable a, Comparable b) {

        return a.compareTo(b) < 0;
    }

    private static void exch (Comparable a[], int i, int j) {

        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

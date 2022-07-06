package it.algoritmi.AlgoritmiOrdinamento;

   /* Spiegazione dell'algoritmo:
    * 
    * L'algoritmo di ordinamento più basilare in assoluto. Si tratta di dividere concettualmente l'array in due parti,
    di cui la sinistra ordinata e la destra da ordinare. Inizialmente la parte sinistra potrebbe essere nulla, ovvero
    con un array tutto disordinato.
    Con i due cicli for implementiamo un controllo molto semplice. Per ogni nuovo elemento
    da inserire nella parte ordinata andiamo alla ricerca del minimo assoluto nella parte disordinata, questo mediante il
    ciclo for interno. Di conseguenza è necessario scorrere tutto l'array per fare i confronti. Una volta trovato il minimo
    questo viene scambiato con l'elemento con cui era stato confrontato.
    Si procede quindi facendo avanzare il ciclo più esterno, in maniera tale da non andare più a toccare la parte di
    array già ordinata.

    Ogni scambio (effettuato qui con la funzione "exch") pone un elemento nella sua posizione finale, quindi il numero
    di scambi effettuati dall'algoritmo è pari a N-1 (dato che l'ultimo elemento non deve essere scambiato).
    Questo numero di scambi è costante in ogni caso, dal momento che lo scambio avviene in ogni caso, stupidamente.
    Infatti se il ciclo for interno non trova nessun valore più piccolo dell'elemento di confronto, il valore di min
    all'uscita del ciclo interno è ancora pari a "i". Lo "scambio", se ancora così lo si può chiamare, avviene
    sulla stessa casella dell'array. [SINCERAMENTE NON CAPISCO COSA COSTASSE AGGIUNGERE UN IF CHE CONTROLLASSE CHE MIN FOSSE
    DIVERSO DA "I" PRIMA DI EFFETTUARE QUESTO INUTILE SCAMBIO. CAPISCO CHE QUESTO ALGORITMO NON SE LO CAGA NESSUNO 
    MA DAI CAZZO]. 

    Sul numero di confronti (complessità computazionale) invece possiamo dire che è pari a (N^2 + N)/2 (calcolato con una sommatoria di Gauss).
    Da notare che i confronti (andando alla ricerca del minimo), devono avvenire in ogni caso, anche nel caso in cui 
    l'array fosse già ordinato in partenza. La complessità di questo algoritmo infatti dipende dal numero di elementi
    dell'array, e non da come sono disposti inizialmente.

    La complessità temporale dell'algoritmo è dell'ordine O(N^2).
    Ciò vuol dire che raddoppiando gli elementi nell'array, quadruplica il tempo necessari ad ordinarli, triplicando gli
    elementi, il tempo sarà 9 volte maggiore.

    Unica nota positiva di questo algoritmo il numero di scambi (N-1).

    */

@SuppressWarnings("rawtypes")
public class SelectionSort {
    
    public static void selectionSort (Comparable a[]) {
        
        for (int i = 0; i < a.length; i++) {

            int min = i;
            for (int j=i+1; j<a.length; j++)
                if (less(a[j], a[min]))
                    min = j;
            
            if (i != min)
                exch(a, i, min); 
            
        }
    }


    private static boolean less (Comparable a, Comparable b) {
        
        return a.compareTo(b) < 0;
    }

    private static void exch (Comparable a[], int x, int y) {

        Comparable temp = a[x];
        a[x] = a[y];
        a[y] = temp;

    }

    
}



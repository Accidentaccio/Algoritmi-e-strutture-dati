package it.algoritmi.AlgoritmiOrdinamento;

    /* Spiegazione dell'algoritmo:
        * 
        * Il mergeSort è un algoritmo di ordinamento basato sul concetto di "divide et impera".
        Il funzionamento di base è dividere ricorsivamente l'array in due parti, andare a operare prima
        sulla sinistra e poi sulla destra, quindi dividere ancora la sinistra in due parti, e poi il sinistro
        dei risultati ancora in due fino ad ottenere un array di un singolo elemento.
        A questo punto, sempre ricorsivamente, viene effettuata l'operazione di merging, che ha come scopo
        unire due array ordinati, il sinistro e il destro. I due array sinistro e destri composti da un
        solo elemento, infatti, risultano ordinati (ovviamente), quindi viene creato un array ordinato di
        due elementi. Questo verrà unito con l'array risultante di due elementi del lato destro, e così
        fino a risalire in cima.

        Il motivo per cui viene "ordinato" prima il ramo sinistro e poi il destro è di rendere
        l'algoritmo stabile, ovvero preservare l'ordine per due elementi con chiave uguale.

        Per queste operazioni si utilizza un array ausiliario, di conseguenza il mergeSort
        NON è un algoritmo in-place.

        Ad ogni iterazione nell'array principale vi saranno due sub-array ordinati da fondere.
        L'operazione di merge copia il contenuto dell'array A nell'ausiliario AUX, in maniera tale
        da non perdere l'attuale ordine degli elementi.
        Con due puntatori in aux si procede al merging e i dati in A vengono sovrascritti con
        l'ordine corretto dei due sub-array.

        Il numero di confronti è pari a N*logN (in base 2). (Spiegazione sulle slides)
        Il numero di scambi è <= di 6 volte i confronti, ovvero <= 6N*logN. Il motivo di questa cosa è
        che nell'algoritmo vengono eseguiti ricorsivamente 2 sort e 1 merge, e tutti e tre accedono 2
        volte all'array. (2x3 = 6 volte).

        Alcuni miglioramenti dell'algoritmo possono essere eseguiti:

        1) Evitando di dividere gli array fino alla minima dimensione, ma ad una certa lasciare ordinarli
        da altri algoritmi di ordinamento, tipicamente l'insertionSort, e poi eseguire il merge. (Dai nostri
        test migliora poco e niente, se non in alcuni casi peggiore dell'algoritmo originale).

        2) Si confronta l'ultimo elemento del sub-array di sinistra con il primo del sub-array di destra.
        Se quello di destra è maggiore, essendo i due sub-array ordinati, non va effettuato nessun confronto
        ma semplicemente gli array possono essere uniti così come sono.

        3) Il terzo miglioramento è il più importante. Si effettua una sola volta la copia (e non tutte le volte
        che si esegue il merge) di A in AUX. A questo punto si invertono i ruoli dei due array. A sarà l'ausiliario.
        A ricopiare gli elementi in A, in posizione corretta, sarà il merge effettuato sul principale, in questo caso
        AUX.
        Questo ci permette di evitare tutte le volte la copia, e di ottenere tutti gli elementi ordinati in A.
        Dai nostri test questo miglioramento consente di ridurre i tempi dell'algoritmo anche, in alcuni casi,
        di decine di volte rispetto a un normale mergeSort.
        Nel caso in cui applichiamo questo miglioramento non è più possibile adottare il numero 2.
        Questo perchè il 2 "evita" il merging, che di per sè è un'ottima cosa. Ovvero evita che A venga ricopiato in AUX
        e che vengano ricopiati in A gli elementi ordinati (visto che erano già ordinati). Ma nel caso del miglioramento
        3, è proprio il merging che va a copiare gli elementi in A, che è l'ausiliario.
        Non effettuare il merge vorrebbe dire non aggiornare i valori di A (ausiliario) con quelli
        dell'array effettivamente ordinato (AUX).



        */

@SuppressWarnings("rawtypes")
public class MergeSort {
    
    private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
        aux = a.clone(); 

        int i = low, j = mid+1; 
        for(int k = low; k <= high; k++) {
            if(i > mid) a[k] = aux[j++]; 
            else if(j > high) a[k] = aux[i++]; 
            else if(less(aux[j], aux[i])) a[k] = aux[j++]; 
            else a[k] = aux[i++];
        }
    }

    private static void mergeMigliorato(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
        
        int i = low, j = mid+1; 
        for(int k = low; k <= high; k++) {
            if(i > mid) aux[k] = a[j++]; 
            else if(j > high) aux[k] = a[i++]; 
            else if(less(a[j], a[i])) aux[k] = a[j++]; 
            else aux[k] = a[i++];
        }
    }

    private static boolean less(Comparable j, Comparable i){
        return (j.compareTo(i) < 0); 
    }

    private static void sort(Comparable[] a, Comparable[] aux, int low, int high) {
        if (high <= low) return; 
        int mid = low + (high - low)/2; 
        sort(a, aux, low, mid); 
        sort(a, aux, mid+1, high); 
        //if (!less(a[mid+1], a[mid])) return;
        merge(a, aux, low, mid, high); 
    }

    private static void sortMigliorato(Comparable[] a, Comparable[] aux, int low, int high) {
        if (high <= low) return; 
        int mid = low + (high - low)/2; 
        sortMigliorato(aux, a, low, mid); 
        sortMigliorato(aux, a, mid+1, high);
        mergeMigliorato(aux, a, low, mid, high); 
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length]; 
        sort(a, aux, 0, a.length-1); 
    }

    public static void sortMigliorato(Comparable[] a) {
        Comparable[] aux = a.clone(); 
        sortMigliorato(a, aux, 0, a.length-1); 
    }


}

package it.algoritmi.StackEQueue;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class MyStackArray<T extends Comparable> implements Iterable<T> {

    //Variabili d'istanza
    int first;
    T[] array;

    public MyStackArray() {
        
        // L'unica soluzione è questa, dal momento che non è possibile istanziare array di tipi generici
        array = (T[]) new Comparable[1];
        first = 0;
    }

    public void push(T item) {

        //Eseguo il controllo per l'eventuale ingrandimento dell'array
        fixedPushCapacity();

        //Inserisco l'oggetto nella posizione first e incremento first
        array[first++] = item;
    }

    public T pop() {

        
        //Salva l'oggetto in posizione first-1 (ovvero l'ultimo inserito, visto che first punta già alla "prossima posizione utile" in cui inserire)
        T item = array[--first];
        
        //Eliminiamo il riferimento dell'oggetto nell'array
        array[first] = null;
        
        //Eseguo il controllo per l'eventuale rimpicciolimento dell'array
        fixedPopCapacity();

        return item;

    }


    /**
     * Il metodo controlla l'effettivo riempimento dell'array. Nel caso in cui fosse pieno, l'array viene riallocato con il doppio della dimensione
     */
    private void fixedPushCapacity() {

        if (size() == array.length) {

            T[] aux = (T[]) new Comparable[array.length*2];

            for (int i=0; i<array.length; i++)
                aux[i] = array[i];
            
            array = aux;
        }        
    }

    /**
     * Il metodo controlla l'effettivo riempimento dell'array. Nel caso in cui fosse minore di 1/4 del totale, l'array viene riallocato con la metà della dimensione
     */
    private void fixedPopCapacity() {

        if (size() == array.length/4) {

            T[] aux = (T[]) new Comparable[array.length/2];

            for (int i=0; i<array.length; i++)
                aux[i] = array[i];
            
            array = aux;
        }        
    }


    /**
     * 
     * @return il numero effettivo di elementi nello stack
     */
    public int size() {

        int count = 0;

        for (T item: array)
            if (item != null)
                count++;
            
        return count;
    }



    @Override
    public Iterator<T> iterator() {
        
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {

        int i = first;
        T[] a = array;

        @Override
        public boolean hasNext() {
            
            return a[i] != null;
        }

        @Override
        public T next() {
            
            //Ritorna l'oggetto in posizione i, e sposta la variabile di conteggio i "indietro" nell'array
            return a[i--];
        }

    }
    
}

package it.algoritmi.StackEQueue;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class MyQueueArray<T extends Comparable> implements Iterable<T> {
    
    int head, tail; 
    T[] array; 

    public MyQueueArray() {
        array = (T[]) new Comparable[1]; 
        head = tail = 0; 
    }

    public void enqueue(T item) {
        
        // Controllo sul riempimento dell'array
        fixedEnqueueCapacity(); 

        // Aggiungo l'elemento alla coda
        array[tail++] = item; 
    }

    public T dequeue() {
        T item = array[head]; 

        // Elimino l'elemento in testa alla coda e faccio puntare head al prossimo elemento
        array[head++] = null; 

        // Controllo il riempimento dell'array
        fixedDequeueCapacity(); 

        /**
         * Se dopo aver rimosso l'elemento la coda è vuota, faccio puntare entrambi 
         * gli indici head e tail alla prima posizione dell'array
         */
        
        if(isEmpty())
            tail = head; 

        return item; 
    }

    /**
     * Questo metodo verifica il riempimento dell'array dopo un'operazione di inserzione. 
     * Se è pieno, l'array viene riallocato con il doppio della dimensione. 
     */
    private void fixedEnqueueCapacity() {
        if(lastPositionOccupied() == array.length-1) {
            T[] aux = (T[]) new Comparable[array.length*2]; 

            for (int i = 0; i < array.length; i++) {
                aux[i] = array[i]; 
            }

            array = aux;
        }
    }

    /** 
     * Questo metodo verifica il riempimento dell'array dopo un'operazione di rimozione. 
     * Se è pieno per 1/4, l'array viene riallocato con la dimensione dimezzata. 
     */
    private void fixedDequeueCapacity() {

        if(lastPositionOccupied() == array.length/4) {
            T[] aux = (T[]) new Comparable[array.length/2];

            for (int i = 0, j = 0; i < array.length && array[i] != null; i++)
                aux[j++] = array[i]; 
            

            array = aux;
            head = 0;
            tail = array.length-1;
        }
    }

    /**
     * 
     * @return l'ultima posizione non NULL occupata nell'array, diversa ovviamente da size
     */
    private int lastPositionOccupied() {
        for (int i=array.length-1; i >= 0; i--)
            if (array[i] != null)
                return i;
        return 0;
    }

    
    /**
     * Metodo per verificare se la coda è vuota
     * @return true se la Queue è vuota
     * @return false se la Queue non è vuota
     */
    public boolean isEmpty(){
        return array[head] == null; 
    }

    
    /**
     * Metodo che restituisce il numero effettivo di elementi presenti all'interno della coda
     * @return il numero di elementi non NULL nella Queue
     */
    public int size() {
        int count = 0; 

        for (T item : array) {
            if (item != null)
                count++; 
        }

        return count; 
    }

    @Override
    public Iterator<T> iterator() {
        
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {
        int i = head; 
        T[] a = array; 

        @Override
        public boolean hasNext() {
            return a[i] != null; 
        }

        @Override
        public T next() {
            T item = a[i++];
            return item;
        }
    }
    
} 

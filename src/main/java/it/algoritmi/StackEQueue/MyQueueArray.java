package it.algoritmi.StackEQueue;

import java.util.Iterator;

import org.jsoup.select.Evaluator.IsEmpty;

public class MyQueueArray<T extends Comparable> implements Iterable<T> {
    
    int head, tail; 
    T[] array; 

    public static void main(String args[]) {

    }

    public MyQueueArray() {
        array = (T[]) new Comparable[1]; 
        head = tail = 0; 
    }

    public void enqueue(T item) {
        

        // Aggiungo l'elemento alla coda
        array[tail++] = item; 

        // Controllo sul riempimento dell'array
        fixedEnqueueCapacity(); 

        /**
         * Nel caso in cui la coda era vuota, faccio in modo che head (il quale deve puntare alla 
         * prima posizione piena all'interno dell'array) punti a tail, ovvero dove è appena stato inserito
         * l'elemento. 
         * A prescindere da se entro o meno in questo if, procedo con l'incrementare 
         * l'indice tail
         */
        /* if(isEmpty())
            head = tail; 
        tail++;  */
    }

    public T dequeue() {
        T item = array[head]; 

        // Elimino l'elemento in testa alla coda e faccio puntare head al prossimo elemento
        array[head] = null; 

        // Controllo il riempimento dell'array
        fixedDequeueCapacity(); 

        /**
         * Se dopo aver rimosso l'elemento la coda è vuota, faccio puntare entrambi 
         * gli indici head e tail alla prima posizione dell'array
         */
        if(isEmpty())
            tail = head; 
        head++;

        return item; 
    }

    /**
     * Questo metodo verifica il riempimento dell'array dopo un'operazione di inserzione. 
     * Se è pieno, l'array viene riallocato con il doppio della dimensione. 
     */
    private void fixedEnqueueCapacity() {
        if(size() == array.length) {
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

        if(size() == array.length/4) {
            T[] aux = (T[]) new Comparable[array.length/2];

            for (int i = 0; i < array.length; i++) {
                aux[i] = array[i]; 
            }

            array = aux; 
        }
    }

    // Metodo per verificare se la coda è vuota
    public boolean isEmpty(){
        return array[head] == null; 
    }

    // Metodo che restituisce il numero effettivo di elementi presenti all'interno della coda
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

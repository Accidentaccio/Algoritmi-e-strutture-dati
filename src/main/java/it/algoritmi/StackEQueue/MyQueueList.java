package it.algoritmi.StackEQueue;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class MyQueueList<T extends Comparable> implements Iterable<T> {
    
    private Node first, last; 

    public static void main(String[] args)
    {
        /* MyQueueList q = new MyQueueList();
        q.enqueue(10);
        q.enqueue(20);
        q.dequeue();
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.dequeue();
        System.out.println("Queue first : " + q.first.item);
        System.out.println("Queue last : " + q.last.item);
        System.out.println("\n\n"); */

    }

    // Classe per il nodo
    private class Node {
        T item; 
        Node next; 
    }

    // Costruttore
    public MyQueueList() {
        this.first = this.last = null; 
    }

    // Operazione per inserzione all'interno della coda
    public void enqueue(T item) {
        Node oldlast = last; 

        last = new Node(); 
        last.item = item; 
        last.next = null; 

        /**
         * Nel caso in cui la coda era vuota si fanno puntare entrambi i puntatori 
         * al nodo appena aggiunto, altrimenti si fa puntare il vecchio ultimo nodo 
         * al nodo appena aggiunto. 
         */
        if(isEmpty()) 
            first = last; 
        else 
            oldlast.next = last; 
    }

    // Operazione per rimozione dalla coda 
    public T dequeue() {
        T item = first.item; 
        first = first.next; 

        /** 
         * Nel caso in cui rimuovendo l'oggetto la coda si svuota, si fa puntare 
         * il puntatore last a null
         */
        if(isEmpty()) last = null; 
        return item; 
    }

    // Metodo per verificare se la coda è vuota
    public boolean isEmpty(){
        return first == null; 
    }

    // Metodo che restituisce il numero effettivo di elementi presenti all'interno della coda
    public int size() {
        int count = 0; 
        Node c = first; 

        while(c != null){
            c = c.next; 
            count++; 
        }

        return count; 
    }

    @Override
    public Iterator<T> iterator() {
       
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

    }
}

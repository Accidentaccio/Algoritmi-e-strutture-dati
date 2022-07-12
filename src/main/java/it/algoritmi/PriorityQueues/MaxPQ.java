package it.algoritmi.PriorityQueues;

@SuppressWarnings("rawtypes")
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int n;

    public MaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity+1];
    }

    public boolean isEmpty() {
        return n==0;
    }

    public void insert (Key key) {
        pq[++n] = key;
        swim(n);
    }
    
    private void swim (int k) {

        while (k>1 & less(k/2, k)) {
            exch(k/2, k);
            k /= 2;
        }
    }

    private void sink(int k) {

        while (2*k <= n) {
            int j = 2*k;
            /*Se esiste un figlio (j<n, dove n è il numero totale degli elementi nell'array),
            e il suo successivo, che al più sarà n, è maggiore di lui, spostiamo il cursore di j
            sul figlio destro (più grande).*/
            if (j<n && less(j, j+1)) j++;
            //Se il maggiore tra i figli (j) è più piccolo del padre (k), è finito il sink.
            if (less(j, k)) break;
            //Altrimenti si scambiano
            exch(j, k);
            /*Spostiamo il cursore di k sull'elemento che abbiamo "affondato", per poter
            effettuare nuovi confronti e capire se va ancora affondato o meno per rispettare
            la struttura del binary heap*/
            k = j;
        }
    }



    private boolean less (int a, int b) {
        return pq[a].compareTo(pq[b]) < 0;
    }

    private void exch (int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    
}


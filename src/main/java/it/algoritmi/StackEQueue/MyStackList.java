package it.algoritmi.StackEQueue;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class MyStackList<T extends Comparable> implements Iterable<T> {


    public static void main (String[] args) {

        MyStackList<Integer> stack = new MyStackList<Integer>();
        stack.push(18);
        stack.push(21);

        for (Integer num: stack)
            System.out.println(num);

    }


    Node first;

    public MyStackList() {
        this.first = null;
    }

    public void push(T item) {
        
        Node oldfirst = first;
        first = new Node();
        first.item = item;

        first.next = oldfirst;
    }

    public T pop() {

        T item = first.item;
        first = first.next;
        return item;
    }



    private class Node {
        T item;
        Node next;
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

package it.algoritmi.StackEQueue;

public class Tester {
    
    public static void main(String[] args) {
        
        MyStackArray<Integer> stackArray = new MyStackArray<>();
        stackArray.push(18);
        stackArray.push(21);
        stackArray.push(18);
        stackArray.push(21);
        stackArray.push(18);
        stackArray.push(21);
        stackArray.push(18);
        stackArray.push(21);

        System.out.println("Rimozione 1: " + stackArray.pop());
        System.out.println("Rimozione 2: " +stackArray.pop());

        System.out.println("\nStampa degli elementi nello stack sfruttando l'iteratore");
        for (Integer num: stackArray)
            System.out.println(num);

        System.out.println("\nNumero elementi rimasti nello stackArray: " + stackArray.size());


        System.out.println("\n--------------------------------------------");


        MyStackList<Integer> stackList = new MyStackList<Integer>();
        stackList.push(18);
        stackList.push(21);

        System.out.println("\nStampa degli elementi nello stack sfruttando l'iteratore");
        for (Integer num: stackList)
            System.out.println(num);
        
        System.out.println("\nNumero elementi rimasti nello stackList: " + stackList.size());


        System.out.println("\n--------------------------------------------");
        MyQueueList<Integer> queueList = new MyQueueList<>(); 
        queueList.enqueue(10);
        queueList.enqueue(20);
        System.out.println("Dequeue 1: " + queueList.dequeue());
        System.out.println("Dequeue 2: " + queueList.dequeue());
        queueList.enqueue(30);
        queueList.enqueue(40);
        queueList.enqueue(50);
        System.out.println("Dequeue 3: " + queueList.dequeue());

        System.out.println("\nStampa degli elementi rimanenti nella queue sfruttando l'iteratore");
        for(Integer n : queueList) {
            System.out.println(n);
        }


        System.out.println("\n--------------------------------------------");
        /* MyQueueArray<Integer> queueArray = new MyQueueArray<>(); 
        queueArray.enqueue(10);
        queueArray.enqueue(20);
        System.out.println("Dequeue 1: " + queueArray.dequeue());
        System.out.println("Dequeue 2: " + queueArray.dequeue());
        queueArray.enqueue(30);
        queueArray.enqueue(40);
        queueArray.enqueue(50);
        System.out.println("Dequeue 3: " + queueArray.dequeue());

        System.out.println("\nStampa degli elementi rimanenti nella queue sfruttando l'iteratore");
        for(Integer n : queueArray) {
            System.out.println(n);
        } */


        
    }

}

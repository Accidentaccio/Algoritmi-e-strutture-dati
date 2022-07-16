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
        
    }

}

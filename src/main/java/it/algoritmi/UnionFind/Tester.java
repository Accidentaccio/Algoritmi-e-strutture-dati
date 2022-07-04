package it.algoritmi.UnionFind;

public class Tester {
    
    public static void main (String[] args) {


        System.out.println("\n\nTest QuickFind\n\n");

        // Creazione di un nuovo oggetto quickFind
        QuickFind quickFind = new QuickFind(10);
        // Stampa a schermo del nuovo oggetto creato
        System.out.print("Initial array: ");
        quickFind.print();


        // Test del metodo find con stampa a schermo
        System.out.println("\nResult's find method: " + quickFind.find(8));


        // Test del metodo union con stampa a schermo dei cambiamenti
        quickFind.union(2, 7);
        System.out.print("Results's union method: ");
        quickFind.print();



        System.out.println("\n\n\n\nTest QuickUnion\n");
        QuickUnion quickUnion = new QuickUnion(10);
        System.out.println("\nResult's find method: " + quickUnion.find(8));

        quickUnion.union(2, 7);
        System.out.print("Results's union method: ");
        quickUnion.print();



    }
}

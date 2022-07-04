package it.algoritmi.UnionFind;

public class QuickFind implements UnionFind {

    private int id[];

    public QuickFind (int num) {

        // Istanzio l'array di interi
        id = new int[num];

        // Lo riempio banalmente con numeri progressivi (eventualmente si può mettere quello che si vuole per vedere vari casi)
        for (int i = 0; i<num; i++)
            id[i] = i;

    }

    @Override
    public int find(int p) {
        
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        
        for (int i = 0; i < id.length; i++)

            if (id[i] == id[p])
                id[i] = id[q];
    }

    public void print() {

        for (int n : id)
            System.out.print(n + " ");
    }

    
}
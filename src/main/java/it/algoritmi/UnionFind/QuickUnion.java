package it.algoritmi.UnionFind;

public class QuickUnion implements UnionFind {

    private int id[];

    public QuickUnion (int num) {

        // Istanzio l'array di interi
        id = new int[num];

        // Lo riempio banalmente con numeri progressivi (eventualmente si può mettere quello che si vuole per vedere vari casi)
        for (int i = 0; i<num; i++)
            id[i] = i;

    }
    

    @Override
    public int find(int p) {
        
        while (p != id[p])
            p = id[p];
        
        return p;

    }

    @Override
    public void union(int p, int q) {
        
        int r1 = find(p);
        int r2 = find(q);
    
        id[r1] = r2;
        
    }

    public void print() {

        for (int n : id)
            System.out.print(n + " ");
    }


    public boolean connected(int v, int w) {
        if(find(v) == find(w))
            return true; 
        return false; 
    }

    
}

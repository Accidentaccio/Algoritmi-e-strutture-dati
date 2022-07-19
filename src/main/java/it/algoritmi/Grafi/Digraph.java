package it.algoritmi.Grafi;

public class Digraph extends Graph{
    
    public Digraph(int v) {
        super(v); 
    }

    @Override
    public void addEdge(int v, int w) {
        getAdj(v).add(w); 
    }
}

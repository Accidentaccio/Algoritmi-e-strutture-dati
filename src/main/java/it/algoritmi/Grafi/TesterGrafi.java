package it.algoritmi.Grafi;

public class TesterGrafi {

    public static void main(String[] args) {

        Graph g = new Graph(10);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);

        // 7 e 8 sono nodi staccati
        g.addEdge(7, 8);
        
        // 9 è un nodo solitario

        System.out.println("Nodi del grafo: " + g.V());
        System.out.println("Grado del nodo 3: " + g.degree(3));
        System.out.println("Grado del nodo 9: " + g.degree(9));

        Paths path = new Paths(g, 0);
        System.out.println(path.hasPathTo(7));
        
        try {
            for (Integer i: path.pathTo(7))
                System.out.println(i);
        }
        catch(NoPathsFindException e) {
            e.printStackTrace();
        }
        
        
    }
   



}

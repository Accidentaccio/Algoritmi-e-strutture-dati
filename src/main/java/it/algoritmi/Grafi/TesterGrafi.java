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

        Paths path = new Paths(g, 7);
        System.out.println(path.hasPathToDFS(0));
        
        try {
            for (Integer i: path.pathToDFS(7))
                System.out.println(i);
        }
        catch(NoPathsFindException e) {
            e.printStackTrace();
        }


        // Tester BFS
        System.out.println(path.hasPathToBFS(9));
        
        try {
            for (Integer i: path.pathToBFS(8))
                System.out.println(i);
        }
        catch(NoPathsFindException e) {
            e.printStackTrace();
        }


        // Tester per grafo diretto
        System.out.println("\n------------- TESTER GRAFO DIRETTO --------------\n");
        Digraph dg = new Digraph(6);
        dg.addEdge(0, 1);
        dg.addEdge(2, 0);
        dg.addEdge(4, 2);
        dg.addEdge(2, 3);
        dg.addEdge(3, 2);
        dg.addEdge(4, 3);
        dg.addEdge(3, 5);
        dg.addEdge(0, 5);
        dg.addEdge(5, 4);


        System.out.println("Nodi del grafo: " + dg.V());
        System.out.println("Grado del nodo 3: " + dg.degree(3));
        System.out.println("Grado del nodo 2: " + dg.degree(2));

        path = new Paths(dg, 0);
        try {
            for (Integer i: path.pathToDFS(3))
                System.out.println(i);

            System.out.println("\n---------\n");

            for (Integer i: path.pathToBFS(4))
                System.out.println(i);
        }
        catch(NoPathsFindException e) {
            e.printStackTrace();
        }




        // Tester per postoder
        System.out.println("\n\n------------- TESTER ORDINAMENTO TOPOLOGICO --------------\n");
        dg = new Digraph(7);
        dg.addEdge(0, 1);
        dg.addEdge(0, 5);
        dg.addEdge(0, 2);
        dg.addEdge(1, 4);
        dg.addEdge(3, 2);
        dg.addEdge(3, 4);
        dg.addEdge(3, 5);
        dg.addEdge(3, 6);
        dg.addEdge(5, 2);
        dg.addEdge(6, 0);
        dg.addEdge(6, 4);


        DFSTopological dt = new DFSTopological(dg); 
        for (Integer n : dt.reversePostorder())
            System.out.println(n);
    }
}

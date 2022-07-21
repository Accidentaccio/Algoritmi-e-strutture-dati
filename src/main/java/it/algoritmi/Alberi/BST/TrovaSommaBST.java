package it.algoritmi.Alberi.BST;

import java.util.HashMap;
import java.util.Stack;

public class TrovaSommaBST {

    public static int[] trovaSommaBST(Node padre, int somma) {
        int[] coppia = new int[2]; 
        dfs(coppia, padre, somma); 

        return coppia; 
    } 

    /**
     * All'interno del metodo, esclusa la parte relativa al controllo nella mappa, è presenta la DFS per i BST.
     * @param coppia
     * @param padre
     * @param somma
     */
    private static void dfs(int[] coppia, Node padre, int somma) {
        Stack<Node> stack = new Stack<Node>();
        HashMap<Integer, Node> map = new HashMap<Integer, Node>(); 

        stack.push(padre); 

        while(!stack.isEmpty()) {
            Node node = stack.pop(); 

            if(map.containsKey(somma - (node.key))) {
                coppia[0] = node.key; 
                coppia[1] = somma - (node.key);
                break;
            }
            else {
                map.put(node.key, node); 
            }


            if(node.left != null)
                stack.push(node.left); 
            if(node.right != null)
                stack.push(node.right); 
        }
    }
    

    private static class Node {
        Integer key; 
        Node left, right; 
    }

    public static void main(String[] args) {
        Node a = new Node();
        a.key = 27;
        Node b = new Node();
        b.key = 14;
        Node c = new Node();
        c.key = 10;
        Node d = new Node();
        d.key = 19;
        Node e = new Node();
        e.key = 35;
        Node f = new Node();
        f.key = 31;
        Node g = new Node();
        g.key = 42;

        a.left = b;
        a.right = e;

        b.left = c;
        b.right = d;

        e.left = f;
        e.right = g;


        int[] coppia = TrovaSommaBST.trovaSommaBST(a, 52); 
        System.out.println("I due numeri per ottenere la somma sono: " + coppia[0] + " e " + coppia[1]);
    }
    
}
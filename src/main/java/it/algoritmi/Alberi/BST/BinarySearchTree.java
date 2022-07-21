package it.algoritmi.Alberi.BST;

import it.algoritmi.StackEQueue.MyQueueList;

@SuppressWarnings("rawtypes")
public class BinarySearchTree {
    
    private Node root;
    private int count;

    /**
     * Costruttore per un BST vuoto.
     */
    public BinarySearchTree() {
        root = null;
        count = 0;
    }

    /**
     * Costruttore che inizializza l'albero con la radice.
     * @param root Il nodo che farà da radice dell'albero.
     */
    public BinarySearchTree(Node root) {
       this.root = root;
       count = 1;
    }

    /**
     * Get della radice dell'albero.
     * @return la radice dell'albero.
     */
    public Node getRoot() {
        return this.root;
    }
    

    /**
     * Inserisce un nodo in un BST rispettando la struttura dell'albero.
     * @param node Il nodo da inserire nel BST.
     */
    public void insert(Node node) {
        Node tempRoot = null; 
        int cmp = 0; 

        // Se l'albero è vuoto viene inserito il nodo come radice
        if(this.root == null) {
            this.root = node;
            return; 
        }
        
        
        /**
         * Con il while si trova la posizione in cui andare ad inserire il nodo.
         * In particolare si salva nella variabile tempRoot il padre a cui aggiungere il nodo come figlio.
         * Inoltre inizializzo una variabile, rootCopy, per non perdere il riferimento alla root dell'albero.
         */
        Node rootCopy = root;

        while(rootCopy != null) {
            cmp = node.key.compareTo(rootCopy.key); 

            tempRoot = rootCopy; 
            if(cmp < 0) 
                rootCopy = rootCopy.left; 
            else if (cmp > 0)
                rootCopy = rootCopy.right; 
            else return; 
        }
        
        /**
         * cmp è il risultato dell'ultimo compareTo effettuato.
         * Se è minore di 0, il nodo viene inserito come figlio sinistro; 
         * altrimenti viene inserito come figlio destro. 
         * Non viene gestito il caso in cui cmp == 0, in quanto è già gestito all'interno del while. 
         */
        if(cmp < 0)
            tempRoot.left = node;  
        else 
            tempRoot.right = node;

        this.count++;
    }

    /**
     * Ricerca il nodo in un BST con la chiave passata al metodo.
     * @param key la chiave del nodo da cercare.
     * @return il nodo se è presente nel BST, null altrimenti.
     */
    public Node searchInBST(Comparable key) {
        
        Node rootCopy = root;

        if(rootCopy == null) 
            return null; 
        
        
        while(rootCopy != null) {
            int cmp = key.compareTo(rootCopy.key); 

            if(cmp < 0) 
                rootCopy = rootCopy.left; 
            else if (cmp > 0)
                rootCopy = rootCopy.right; 
            else 
                return rootCopy; 
        }

        // Se si esce dal ciclo while di sopra la chiave cercata non è presente nell'albero
        return null;
    }

    /**
     * Elimina il nodo con chiave passata al metodo dal BST.
     * @param key la chiave del nodo da eliminare dal BST.
     * @return
     */
    public Node delete(Comparable key) {
        Node rootCopy = root;
        return privateDelete(rootCopy, key);
    }

    /**
     * Metodo privato chiamato dal "delete" pubblico per l'eliminazione
     * di un nodo.
     * @param root Nodo dell'albero passatogli ricorsivamente. Alla prima iterazione
     * è la radice dell'albero.
     * @param key la chiave del nodo da eliminare dal BST.
     * @return
     */
    private Node privateDelete(Node root, Comparable key) {
        if(root == null) return null; 

        int cmp = key.compareTo(root.key); 
        if(cmp < 0) root.left = privateDelete(root.left, key); 
        else if (cmp > 0) root.right = privateDelete(root.right, key);
        else {
            this.count--;
            if(root.right == null) return root.left;
            if(root.left == null) return root.right;

            Node temp = root; 
            root = min(temp.right); 
            root.right = deleteMin(temp.right); 
            root.left = temp.left;
            
        }

        // root.count = size(root.left) + size(root.right) + 1; 
        return root; 
    }

    /**
     * Metodo per cercare il minimo all'interno di un albero binario di ricerca
     * @param root La radice dell'albero in cui cercare (passato come argomento perchè
     * potrebbe non essere necessariamente la radice)
     * @return il nodo minimo del BST.
     */
    public Node min(Node root) {
        while(root.left != null) {
            root = root.left; 
        }
        return root; 
    }
    /**
     * 
     * @param n
     * @return
     */
    private Node deleteMin(Node n) {
        if (n.left == null)
            return n.right;
        n.left = deleteMin(n.left);      

        // n.count= 1 + size(n.left)+ size(n.right);   
                                                
        return n;
    }

    /**
     * Metodo per cercare il minimo all'interno di un albero binario di ricerca
     * @param root La radice dell'albero in cui cercare (passato come argomento perchè
     * potrebbe non essere necessariamente la radice)
     * @return il nodo massimo del BST.
     */
    public Node max(Node root) {
        while(root.right != null) {
            root = root.right; 
        }
        return root; 
    }

    /**
     * 
     * @param root La radice dell'albero in cui misurare l'altezza (passato come argomento perchè
     * potrebbe non essere necessariamente la radice)
     * @return l'altezza del BST.
     */
    public int height(Node root) {

        if (root == null)
            return 0;
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight > rightHeight)
            return (leftHeight + 1);
        else
            return (rightHeight + 1);
        
    }

    /**
     * Restituisce le chiavi dell'albero come stringa.
     */
    public String toString() {

        MyQueueList<Node> q = new MyQueueList<Node>();
        Comparable[] keys = new Comparable[this.count+1];
        int index = 0;

        q.enqueue(root);

        while(!q.isEmpty()) {
        
            Node node = q.dequeue();
            keys[index++] = node.key;

            if (node.left != null)
                q.enqueue(node.left);
            if (node.right != null)
                q.enqueue(node.right);
        }

        String s = "";
        for (Comparable c: keys) {
            s = s.concat(c.toString()).concat(" ");
       }

        return s;
    }

    private static class Node implements Comparable{
        Comparable key;
        Object value; 
        Node left, right;

        public Node(Comparable key) {
            this.key = key; 
            this.left = this.right = null; 
        }

        
        @Override
        public int compareTo(Object o) {
            Node that = (Node) o;
            if (key.compareTo(that.key) < 0) return -1;
            else if (key.compareTo(that.key) < 0) return 1;
            else return 0;
        }
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(new Node(100));
        bst.insert(new Node(15));
        bst.insert(new Node(78));
        bst.insert(new Node(178));
        bst.insert(new Node(121));
        bst.insert(new Node(190));
        bst.insert(new Node(200));

        System.out.println(bst.toString());
        System.out.println(bst.searchInBST(121).key);
        System.out.println(bst.height(bst.root));
        bst.delete(121);
        System.out.println(bst.toString());
        
    }
}

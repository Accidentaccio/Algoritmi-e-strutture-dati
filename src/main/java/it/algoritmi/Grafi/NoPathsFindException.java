package it.algoritmi.Grafi;

public class NoPathsFindException extends RuntimeException{

    
    final static String msg = "Non esiste un percorso valido dalla sorgente a questo nodo.";

    public NoPathsFindException() {
        
        super(msg);
    }

}

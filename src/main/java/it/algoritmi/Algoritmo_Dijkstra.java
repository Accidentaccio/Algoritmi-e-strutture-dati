package it.algoritmi;

import java.util.Stack;
import java.util.StringTokenizer;

public class Algoritmo_Dijkstra {

    public static void main (String[] args) {

        Stack<String> operazioni = new Stack<String> ();
        Stack<Double> valori = new Stack<Double> ();

        String expression = "(1+((2+3)*(4*5)))";

        StringTokenizer strTok = new StringTokenizer(expression, "()+-*/", true);

        
        String token;

        while (strTok.hasMoreTokens()) {
            
            token = strTok.nextToken();

            /* La parentesi aperta va skippata */
            if (token.equals("("));

            /* Se l'elemento inserito è un operatore qualsiasi viene inserito nello stack degli operatori*/
            else if (token.equals("+") || token.equals("*") || token.equals("-") || token.equals("/")) {
                operazioni.push(token);
            }

            /* Se si chiude la parentesi bisogna eseguire i calcoli */
            else if (token.equals(")")) {

                //Questa operazione deve essere eseguita qui, una sola volta, perchè se l'andassimo ad eseguire in ogni if else verrebbero rimossi ogni volta operatori.
                String operatore = operazioni.pop();

                if (operatore.equals("+"))
                    valori.push(valori.pop() + valori.pop());
                else if (operatore.equals("*"))
                    valori.push(valori.pop() * valori.pop());
                else if (operatore.equals("-"))
                    valori.push(valori.pop() - valori.pop());
                else if (operatore.equals("/"))
                    valori.push(valori.pop() / valori.pop());

            }

            /* In tutti gli altri casi sono necessariamente numeri */
            else 
                valori.push(Double.parseDouble(token));
        }

        System.out.println("Risultato finale " + valori.pop());
    }

}

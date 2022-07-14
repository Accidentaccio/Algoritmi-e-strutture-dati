package it.algoritmi.AlgoritmiVari;

public class ParolaPalindroma {
    
    public static boolean palindroma(String s) {

        if (s.length() < 2)
            return true;

        if (s.charAt(0) == s.charAt(s.length()-1))
            return palindroma((s.substring(1, s.length()-1)));
        else
            return false;
    }
}


package com.com470.p4app.service;


public class Palindromo {
    
    public boolean buscaPalindromo(String cadena){
        cadena=cadena.toLowerCase();
        System.out.println("la cadena es::"+cadena);
        int largoCadena = cadena.length();
        int rango = largoCadena/2;
        boolean esPalindromo = true;
        if (largoCadena%2==0) {
            rango--;
        }
        for (int i = 0; i < rango; i++) {
            if (cadena.charAt(i)!=cadena.charAt(largoCadena-i-1)) {
                esPalindromo=false;
            }
        }
        return esPalindromo;
    }
    
}

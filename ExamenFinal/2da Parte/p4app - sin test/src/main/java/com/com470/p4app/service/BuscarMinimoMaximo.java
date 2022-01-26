
package com.com470.p4app.service;

import com.com470.p4app.model.MinimoMaximo;
import java.util.List;


public class BuscarMinimoMaximo {
    public MinimoMaximo buscaMinimoMaximo(List<Integer> lista){
        int smallest=lista.get(0);
        int largest=lista.get(0);
        System.out.println("la lista es>>"+lista.toString());
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i)<smallest) smallest=lista.get(i);
            if (lista.get(i)>largest) largest=lista.get(i);
        }
        System.out.println("el menor es >>"+smallest);
        System.out.println("el mayor es >>"+largest);
        return new MinimoMaximo(smallest, largest);
    }
   
}

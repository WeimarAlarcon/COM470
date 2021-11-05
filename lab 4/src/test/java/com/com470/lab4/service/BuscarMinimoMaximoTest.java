/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.com470.lab4.service;

import com.com470.lab4.model.MinimoMaximo;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alarcon
 */
public class BuscarMinimoMaximoTest {
    
    private BuscarMinimoMaximo utils = new BuscarMinimoMaximo();

    @Test
    public void testBuscarMinimoMaximoUNO() {
        List<Integer> lista = Arrays.asList(3,2,1,-55,2,4,-8,200);
        //MinimoMaximo resultado = utils.buscaMinimoMaximo(lista);
        MinimoMaximo esperado = new MinimoMaximo(-55,200);
        //assertEquals(esperado, resultado);
        //assertThat(utils.buscaMinimoMaximo(lista),Matchers.is(esperado));
        test(esperado, lista);
    }
    
    @Test
    public void testBuscarMinimoMaximoDOS() {
        List<Integer> lista = Arrays.asList(3,2,1,55,2,4,-8,200);
        //MinimoMaximo resultado = utils.buscaMinimoMaximo(lista);
        MinimoMaximo esperado = new MinimoMaximo(-8,200);
        test(esperado, lista);
        
        //assertEquals(esperado, resultado);
        //assertThat(utils.buscaMinimoMaximo(lista),Matchers.is(esperado));
    }
    
    @Test
    public void testBuscarMinimoMaximoTRES() {
        List<Integer> lista = Arrays.asList(3,2,1,-55,2,4,-8,20);
        //MinimoMaximo resultado = utils.buscaMinimoMaximo(lista);
        MinimoMaximo esperado = new MinimoMaximo(-55,20);
        test(esperado, lista);
        
        //assertEquals(esperado, resultado);
        //assertThat(utils.buscaMinimoMaximo(lista),Matchers.is(esperado));
    }
    
    private void test(MinimoMaximo esperado, List<Integer> lista){
        assertThat(utils.buscaMinimoMaximo(lista),Matchers.is(esperado));
    }
}

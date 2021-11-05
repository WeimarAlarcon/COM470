/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejertestparam;

import java.util.List;
import org.assertj.core.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Alarcon
 */

@RunWith(Parameterized.class)
public class CalculadoraTest {

    @Parameterized.Parameters
    //devolvera un array de objetos --> coleccion
    public static List<Object> datos() {
        //devolvera una lista
        return Arrays.asList(new Object[][]{
            {10, 0},{1, 2}, {3, 5}, {4, 2}, {5, 0}
        });
    }
    @Parameterized.Parameter(0)
    public int v1;
    @Parameterized.Parameter(1)
    public int v2;

    Calculadora calc = new Calculadora();
    
    @Test
    public void testSuma() {
        int resultado = calc.suma(v1,v2);
        assertEquals(v1 + v2, resultado);
    }

    @Test
    public void testResta() {
        int resultado = calc.resta(v1,v2);
        assertEquals(v1 - v2, resultado);
    }

    @Test
    public void testMultimplicacion() {
        int resultado = calc.multimplicacion(v1,v2);
        assertEquals(v1 * v2, resultado);
    }

    @Test
    public void testDivision() {
        try {
            int resultado = calc.division(v1, v2);

            assertEquals(v1 / v2, resultado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertEquals("No se puede dividir entre 0", e.getMessage());
        }
    }
}

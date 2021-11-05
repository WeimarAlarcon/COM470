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
public class NumeroPrimoTest {

    @Parameterized.Parameters

    public static List<Object> datos() {
        return Arrays.asList(new Object[][]{
            {2, true}, {3, true}, {50, false}
        });
    }
    @Parameterized.Parameter(0)
    public int valor1;
    @Parameterized.Parameter(1)
    public boolean valor2;

    NumeroPrimo utils = new NumeroPrimo();

    @Test
    public void testValidate() {
        boolean resultado = utils.validate(valor1);
        boolean esperado = valor2;
        assertEquals(esperado, resultado);
    }
}

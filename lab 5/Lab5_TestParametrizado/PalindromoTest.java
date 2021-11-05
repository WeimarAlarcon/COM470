/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejertestparam;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Alarcon
 */
@RunWith(Parameterized.class)
public class PalindromoTest {
    
    @Parameterized.Parameters

    public static List<Object> datos() {
        //devolver lista
        return org.assertj.core.util.Arrays.asList(new Object[][]{
            {"oso", true}, {"ottos", false}, {"narran", true}
        });
    }
    @Parameterized.Parameter(0)
    public String valor1;
    @Parameterized.Parameter(1)
    public boolean resultado;

    Palindromo utils = new Palindromo();

    @Test
    public void testBuscaPalindromo() {
        assertEquals(resultado, utils.buscaPalindromo(valor1));
    }
    
}

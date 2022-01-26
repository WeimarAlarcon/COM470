/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.com470.p4app.service;

import java.util.List;
import org.hamcrest.Matchers;
import org.junit.Before;
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
    
    public static List<Object> datos()
    {
        //devolver lista
    return org.assertj.core.util.Arrays.asList(new Object[][]{{"recocer",true},{"sergio",false}});
    }
    @Parameterized.Parameter(0)
    public String valor1;
    @Parameterized.Parameter(1)
    public boolean resultado;
            
    Palindromo utils = new Palindromo();

    @Test
    public void buscaPalindromoTest() {
        assertThat(utils.buscaPalindromo(valor1),Matchers.is(resultado));
        
    }
}

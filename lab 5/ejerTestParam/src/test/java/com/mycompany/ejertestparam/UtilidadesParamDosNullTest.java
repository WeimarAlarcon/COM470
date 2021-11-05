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
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Alarcon
 */
@RunWith(Parameterized.class)
public class UtilidadesParamDosNullTest {
    @Parameters
    public static List<Object> datos() {
        //devolvera una lista
        return Arrays.asList(new Object[][]{
            {null,"b","c"},{"d",null,"f"},{"g","h",null},{null,null,null}
        });
    }
    @Parameter(0)
    public String valor1;
    @Parameter(1)
    public String valor2;
    @Parameter(2)
    public String valor3;
    
    Utilidades utils=new Utilidades();
    
    @Test
    public void testConcatenar() {
        System.out.println("Ejecucion:: "+valor1+" "+valor2+" "+valor3);
        assertNull("el valor es null", utils.concatenar(valor1, valor2, valor3));
        //fail("The test case is a prototype.");
    }
}

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
public class TrianguloTest {
    
    @Parameterized.Parameters
    public static List<Object> datos() {
        //devolvera una lista
        return Arrays.asList(new Object[][]{
            {4,4,4}, {3,4,5}, {3,7,3}
        });
    }
    
    @Parameterized.Parameter(0)
    public int valor1;
    @Parameterized.Parameter(1)
    public int valor2;
    @Parameterized.Parameter(2)
    public int valor3;
    Triangulo triangulo = new Triangulo();

    @Test
    public void testTipoTriangulo() {
        
        String resultado;
        System.out.println("Para : "+valor1+" "+valor2+" "+valor3);
        String esperado1 = "Equilatero";
        String esperado2 = "Escaleno";
        String esperado3 = "Isosceles";
        resultado = triangulo.tipoTriangulo(valor1, valor2, valor3);
        System.out.println(resultado);
        
        
        if(valor1==4 && valor2==4 && valor3==4){
            assertEquals(esperado1, resultado);
        }
        if(valor1==3 && valor2==4 && valor3==5){
            assertEquals(esperado2, resultado);
        }
        if(valor1==3 && valor2==7 && valor3==5){
            assertEquals(esperado3, resultado);
        }
    }
}

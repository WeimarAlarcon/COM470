/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.com470.ApiParcialUno;


import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Alarcon
 */
@RunWith(Parameterized.class)
public class NumComplejoTest {
    
    @Parameters
    public static Iterable datos() {
        return Arrays.asList(new Object[][]{
            {3, 2, 4, 1},
            {4, 2, -2, -3},
            {2, 0, 1, 0},
            {-1, 0, 8, 5},
            {0, 0, 0, 0},
            {2, -1, 5, 4},
            {0, -1, 0, 4},
            {-4, -2, -8, -7},
            {0, 0, 2, 5},
            {5, 8, 0, 0}});
    }

    @Parameterized.Parameter(0)
    public int a;
    @Parameterized.Parameter(1)
    public int bi;
    @Parameterized.Parameter(2)
    public int c;
    @Parameterized.Parameter(3)
    public int di;

    @Test
    public void testSumar() {
        NumComplejo complejo1 = new NumComplejo(a, bi);
        NumComplejo complejo2 = new NumComplejo(c, di);
        NumComplejo resultado = complejo1.sumar(complejo2);
        NumComplejo esperado = new NumComplejo(a + c, bi + di);

        assertEquals(resultado.getParteReal(), esperado.getParteReal());
        assertEquals(resultado.getParteImaginaria(), esperado.getParteImaginaria());
    }

    @Test
    public void testRestar() {
        NumComplejo complejo1 = new NumComplejo(a, bi);
        NumComplejo complejo2 = new NumComplejo(c, di);
        NumComplejo resultado = complejo1.restar(complejo2);
        NumComplejo esperado = new NumComplejo(a - c, bi - di);

        assertEquals(resultado.getParteReal(), esperado.getParteReal());
        assertEquals(resultado.getParteImaginaria(), esperado.getParteImaginaria());
    }
}

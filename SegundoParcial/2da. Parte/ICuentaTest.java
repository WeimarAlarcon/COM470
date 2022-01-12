/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.com470.mockito1app.controller;

import com.com470.mockito1app.service.GestorLogin;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Matchers.anyString;
import org.mockito.Mockito;
import static org.mockito.Mockito.never;

/**
 *
 * @author Alarcon
 */
public class ICuentaTest {
    /*
    public ICuentaTest() {
    }

    @Test
    public void testSomeMethod() {
        fail("The test case is a prototype.");
    }
    */
    
    private IRepositorioCuentas repo;
    
    ICuenta cuenta;
    
    @Before
    public void inicializarTest() {
        repo = Mockito.mock(IRepositorioCuentas.class);
        cuenta = Mockito.mock(ICuenta.class);
        Mockito.when(repo.buscar("pepe")).thenReturn(cuenta);
    }
    
    @Test
    public void testAccesoConcedidoALaPrimera() {
        Mockito.when(cuenta.claveCorrecta("1234")).thenReturn(true);
        GestorLogin login = new GestorLogin(repo);
        login.acceder("pepe", "1234");
        Mockito.verify(cuenta).entrarCuenta();
    }

    @Test
    public void testAccesoDenegadoALaPrimera() {
        Mockito.when(cuenta.claveCorrecta("1234")).thenReturn(false);
        GestorLogin login = new GestorLogin(repo);
        login.acceder("pepe", "1234");
        Mockito.verify(cuenta, never()).entrarCuenta();
    }

    @Test(expected = ExcepcionUsuarioDesconocido.class)
    public void testUsuarioIncorrecto() {
        Mockito.when(repo.buscar("bartolo")).thenReturn(null);
        GestorLogin login = new GestorLogin(repo);
        login.acceder("bartolo", "1234");
        Mockito.verify(cuenta, never()).entrarCuenta();
    }

    @Test
    public void testBloquearTrasTresIntentos() {
        Mockito.when(cuenta.claveCorrecta("1234")).thenReturn(false);
        GestorLogin login = new GestorLogin(repo);
        login.acceder("pepe", "1234");
        login.acceder("pepe", "1234");
        login.acceder("pepe", "1234");
        Mockito.verify(cuenta, never()).entrarCuenta();
        Mockito.verify(cuenta).bloquearCuenta();
    }

    @Test
    public void testAccederTrasDosIntentos() {
        Mockito.when(cuenta.claveCorrecta(anyString())).thenReturn(false);
        Mockito.when(cuenta.claveCorrecta("1234")).thenReturn(true);
        GestorLogin login = new GestorLogin(repo);
        login.acceder("pepe", "1242");
        login.acceder("pepe", "1234");
        Mockito.verify(cuenta).entrarCuenta();
    }

    @Test
    public void testAccederTrasUnIntentos() {
        Mockito.when(cuenta.claveCorrecta("1234")).thenReturn(true);
        GestorLogin login = new GestorLogin(repo);
        login.acceder("pepe", "1234");
        Mockito.verify(cuenta).entrarCuenta();
    }

    @Test
    public void testAccederTrasCuatroIntentos() {
        Mockito.when(cuenta.claveCorrecta(anyString())).thenReturn(false);
        Mockito.when(cuenta.claveCorrecta(anyString())).thenReturn(false);
        Mockito.when(cuenta.claveCorrecta(anyString())).thenReturn(false);
        Mockito.when(cuenta.claveCorrecta("1234")).thenReturn(true);
        
        GestorLogin login = new GestorLogin(repo);
        login.acceder("pepe", "1242");
        login.acceder("pepe", "1234");
        Mockito.verify(cuenta).entrarCuenta();
    }

    @Test
    public void testAccesoDenegadoCuentaBloqueada() {
        Mockito.when(cuenta.claveCorrecta("1234")).thenReturn(true);
        Mockito.when(cuenta.estaBloqueada()).thenReturn(true);
        
        GestorLogin login = new GestorLogin(repo);
        login.acceder("pepe", "1234");
        Mockito.verify(cuenta, never()).entrarCuenta();
    }

    @Test (expected = ExcepcionCuentaEnUso.class)
    public void testCuentaEnUso() {
        Mockito.when(cuenta.claveCorrecta("1234")).thenReturn(true);
        Mockito.when(cuenta.estaEnUso()).thenReturn(true);
        Mockito.when(cuenta.claveCorrecta(anyString())).thenReturn(false);

        GestorLogin login = new GestorLogin(repo);
        login.acceder("pepe", "1242");
    }
}

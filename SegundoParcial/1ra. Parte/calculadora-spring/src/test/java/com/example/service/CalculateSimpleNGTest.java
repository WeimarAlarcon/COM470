/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 *
 * @author Alarcon
 */
public class CalculateSimpleNGTest {

    public CalculateSimpleNGTest() {
        
    }
    /*
    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
    }
    */
    private WebDriver driver;

    @BeforeMethod
    public void setUpMethod() throws Exception {

        DesiredCapabilities cap = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://localhost:8080/calculadora/");
        segundosPausa(2);
    }
    
//------  Calculadora Simple:  --------
    
    //Suma
    @Test
    public void sumaTest() {
        calculdoraSimple("5", "7", "12", "add");
        segundosPausa(2);
    }

    //Resta
    @Test
    public void restaTest() {
        calculdoraSimple("8", "3", "5", "subtract");
        segundosPausa(2);
    }

    //Multiplicacion
    @Test
    public void multiplicacionTest() {
        calculdoraSimple("5", "2", "10", "multiply");
        segundosPausa(2);
    }

    //Division
    @Test
    public void divideTest() {
        calculdoraSimple("20", "4", "5.0", "divide");
        segundosPausa(2);
    }

    //Limpiar(Clear)
    @Test
    public void clearSimpleTest() {
        calculdoraSimple("5", "7", "0", "clearSimple");
        segundosPausa(2);
    }
    
//------ Calculadora Avanzada --------
    
    //Fibonacci
    @Test
    public void fibonacciTest() {
        calculadoraAvanzada("8", "21", "fibonacci");
        segundosPausa(2);
    }

    //Factorial
    @Test
    public void factorialTest() {
        calculadoraAvanzada("5", "120", "factorial");
        segundosPausa(2);
    }

    //Raiz Cuadrada
    @Test
    public void sqrtTest() {
        calculadoraAvanzada("4", "2.0", "sqrt");
        segundosPausa(2);
    }

    //Potencia
    @Test
    public void potenciaTest() {
        calculadoraAvanzada("4", "16", "power");
        segundosPausa(2);
    }

    //(Clear)Limpiar Avanzado
    @Test
    public void clearAdvancedTest() {
        calculadoraAvanzada("4", "0", "clearAdvanced");
        segundosPausa(2);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.quit();
    }

    public static void segundosPausa(int sleep) {
        try {
            Thread.sleep(sleep * 1000);
        } catch (InterruptedException e) {
        }
    }

//  Calculdora Simple 
    public void calculdoraSimple(String a, String b, String resultado, String operacion) {
        driver.findElement(By.id("a")).clear();
        driver.findElement(By.id("b")).clear();

        driver.findElement(By.id("a")).sendKeys(a);
        driver.findElement(By.id("b")).sendKeys(b);

        driver.findElement(By.name(operacion)).click();
        assertTrue(driver.findElement(By.xpath("/html/body/form/h1[2]/p")).getText().contains("Resultado: " + resultado));
    }
//  Calculadora Avanzada
    public void calculadoraAvanzada(String c, String resultado, String operacion) {
        driver.findElement(By.id("c")).clear();

        driver.findElement(By.id("c")).sendKeys(c);

        driver.findElement(By.name(operacion)).click();
        assertTrue(driver.findElement(By.xpath("/html/body/form/h1[2]/p")).getText().contains("Resultado: " + resultado));
    }

}

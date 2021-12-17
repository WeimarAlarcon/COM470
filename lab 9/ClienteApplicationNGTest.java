/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.seleniumcliente;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
public class ClienteApplicationNGTest {
    
    private WebDriver driver;
    
    public ClienteApplicationNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://localhost:5050/listar");
        segundosPausa(1);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

    //registrar Test
    @Test
    public void registrarTest() throws InterruptedException {
        By btnCrearCliente = By.xpath("/html/body/div/div/div[2]/h4/a");
        By localizadorPaginas = By.xpath("//div[@class='card bg-dark text-white']");
        driver.findElement(btnCrearCliente).click();
        segundosPausa(1);
        if (driver.findElement(localizadorPaginas).isDisplayed()) {
            Thread.sleep(2000);

            By nombre = By.xpath("//*[@id='nombre']");
            driver.findElement(nombre).sendKeys("garumax");
            By apellido = By.xpath("//*[@id=\'apellido\']");
            driver.findElement(apellido).sendKeys("choque");
            By email = By.xpath("//*[@id='email']");
            driver.findElement(email).sendKeys("rolax@gmail.com");
            By foramtoDeFechaDenegado = By.xpath("//*[@id='createAt']");

            driver.findElement(foramtoDeFechaDenegado).sendKeys("2021-12-16");
            By archivo = By.xpath("/html/body/div/div/div[2]/form/div[5]/div/input");
            driver.findElement(archivo).sendKeys("D:/Weimar/Fotos/yo.jpg");

            By btnEnviar = By.xpath("//input[@id=\"un\"]");
            driver.findElement(btnEnviar).click();
            Thread.sleep(1000);

            By linkUltimo = By.linkText("Última");
            driver.findElement(linkUltimo).click();
            List<WebElement> btnVeri = driver.findElements(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[1]/a"));
            Thread.sleep(1000);
            (btnVeri.get((btnVeri.size()) - 1)).click();
            segundosPausa(2);
        }

    }

    //editar cliente
    @Test
    public void editarTest() throws InterruptedException {

        By linkUltimo = By.linkText("Última");
        driver.findElement(linkUltimo).click();
        List<WebElement> btnEditar = driver.findElements(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[6]/a"));
        segundosPausa(1);

        (btnEditar.get((btnEditar.size()) - 1)).click();
        By localizadorPaginas = By.xpath("//div[@class='card bg-dark text-white']");
        if (driver.findElement(localizadorPaginas).isDisplayed()) {

            By nombre = By.xpath("//*[@id='nombre']");
            driver.findElement(nombre).clear();
            driver.findElement(nombre).sendKeys("update");
            By apellido = By.xpath("//*[@id=\'apellido\']");
            driver.findElement(apellido).clear();
            driver.findElement(apellido).sendKeys("update");
            By email = By.xpath("//*[@id='email']");
            driver.findElement(email).clear();
            driver.findElement(email).sendKeys("update@gmail.com");
            By fecha = By.xpath("//*[@id='createAt']");
            driver.findElement(fecha).clear();
            driver.findElement(fecha).sendKeys("2020-02-03");
            By archivo = By.xpath("/html/body/div/div/div[2]/form/div[5]/div/input");
            driver.findElement(archivo).clear();
            driver.findElement(archivo).sendKeys("D:/Weimar/Fotos/yo.jpg");
            By btnEnviar = By.xpath("//input[@id=\"un\"]");
            driver.findElement(btnEnviar).click();

            driver.findElement(linkUltimo).click();
            List<WebElement> buttonsVer = driver.findElements(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[1]/a"));
            (buttonsVer.get((buttonsVer.size()) - 1)).click();
            segundosPausa(2);

        }

    }

    //elimnar Cliente
    @Test
    public void eliminarTest() throws InterruptedException {
        By linkUltimo = By.linkText("Última");
        driver.findElement(linkUltimo).click();
        List<WebElement> btnEliminar = driver.findElements(By.xpath("/html/body/div/div/div[2]/table/tbody/tr/td[7]/a"));
        (btnEliminar.get((btnEliminar.size()) - 1)).click();
        driver.switchTo().alert().accept();
        driver.findElement(linkUltimo).click();
        segundosPausa(2);

    }
//falla

    @Test
    public void failTest() throws InterruptedException {

        By linkCrearCliente = By.xpath("/html/body/div/div/div[2]/h4/a");
        By registerPageLocator = By.xpath("//div[@class='card bg-dark text-white']");

        By errorFormatoDate = By.xpath("//*[contains(text(),'Failed to convert property value of type java.lang.String to required type java.util.Date for property createAt; nested exception is org.springframework.core.convert.ConversionFailedException: Failed to convert from type [java.lang.String] to type [@javax.validation.constraints.NotNull @javax.persistence.Column @javax.persistence.Temporal @org.springframework.format.annotation.DateTimeFormat java.util.Date] for value 20-02-2020; nested exception is java.lang.IllegalArgumentException: Parse attempt failed for value [20-02-2020]')]");

        driver.findElement(linkCrearCliente).click();
        if (driver.findElement(registerPageLocator).isDisplayed()) {
            Thread.sleep(2000);
            By nombre = By.xpath("//*[@id='nombre']");
            driver.findElement(nombre).sendKeys("garumax");
            By apellido = By.xpath("//*[@id=\'apellido\']");
            driver.findElement(apellido).sendKeys("choque");
            By email = By.xpath("//*[@id='email']");
            driver.findElement(email).sendKeys("rolax@gmail.com");
            By fecha_formato_denegado = By.xpath("//*[@id='createAt']");
            driver.findElement(fecha_formato_denegado).sendKeys("20-02-2020");
            By btn_Enviar = By.xpath("//input[@id=\"un\"]");
            driver.findElement(btn_Enviar).click();
            assertTrue(driver.findElement(errorFormatoDate).isDisplayed());
        }
        segundosPausa(2);
    }

    public static void segundosPausa(long sleeptime) {
        try {
            Thread.sleep(sleeptime * 1000);
        } catch (InterruptedException e) {
        }
    }
}

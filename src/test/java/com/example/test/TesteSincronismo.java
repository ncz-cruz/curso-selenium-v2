package com.example.test;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.core.DSL;
import com.example.core.DriverFactory;
import static com.example.core.DriverFactory.getDriver;

public class TesteSincronismo {

    private DSL dsl;

   @Before
   public void inicializa(){
       getDriver().get("file:///"+ System.getProperty("user.dir") + "/src/resources/componentes.html");     
       dsl = new DSL();
   }

   @After
   public void finaliza(){
         DriverFactory.killDriver();
   }

   @Test
   public void interageRespostDemorada(){
    dsl.clickButtonId("buttonDelay");
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5)); // Espera de até 5 segundos
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("novoCampo")));
    dsl.escrevePorId("novoCampo", "Deu certo?");
    WebDriverWait wait2 = new WebDriverWait(getDriver(), Duration.ofSeconds(0)); // Espera de até 5 segundos
    wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("novoCampo")));


   }
 
}

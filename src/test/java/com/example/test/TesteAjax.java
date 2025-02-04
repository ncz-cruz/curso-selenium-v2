package com.example.test;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.core.DSL;
import com.example.core.DriverFactory;
import static com.example.core.DriverFactory.getDriver;

public class TesteAjax {

    private DSL dsl;

   @Before
   public void inicializa(){
       getDriver().get("http://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=80f7a");     
       dsl = new DSL();
   }

   @After
   public void finaliza(){
         DriverFactory.killDriver();
   }

    @Test
    public void testAjax(){
        dsl.escrevePorId("j_idt248:name", "Teste");
        dsl.clickButtonId("j_idt248:j_idt252");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(By.id("j_idt248:display"), "Teste"));

        Assert.assertEquals("Teste", dsl.getIdText("j_idt248:display"));
    }

}

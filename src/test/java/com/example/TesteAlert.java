package com.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAlert {
     
    
    private WebDriver driver;
    private DSL dsl;

   @Before
   public void inicializa(){
       driver = new FirefoxDriver();
       driver.manage().window().setSize(new Dimension(800, 800));
       driver.get("file:///"+ System.getProperty("user.dir") + "/src/resources/componentes.html"); 
       dsl = new DSL(driver);    
   }
   @After
   public void finaliza(){
      
   }


     @Test
           public void checkAlert(){
             dsl.clickButton("alert");
              Alert alert = driver.switchTo().alert();
              Assert.assertEquals("Alert Simples", alert.getText());
              alert.accept();
            }

     @Test
            public void checkAlertConfirm(){
                //teste de OK
                dsl.clickButton("confirm");               
                Alert alert = driver.switchTo().alert();
                Assert.assertEquals("Confirm Simples", alert.getText());
                alert.accept();
                Assert.assertEquals("Confirmado", alert.getText());
                alert.accept();
                //teste de cancel
                dsl.clickButton("confirm");                  
                alert = driver.switchTo().alert();
                Assert.assertEquals("Confirm Simples", alert.getText());
                alert.dismiss();
                Assert.assertEquals("Negado", alert.getText());
                alert.dismiss();        
            }
            
            @Test
            public void checkAlertPrompt(){
                dsl.clickButton("prompt");               
                Alert prompt = driver.switchTo().alert();
                Assert.assertEquals("Digite um numero", prompt.getText());
                prompt.sendKeys("12");
                prompt.accept();    
                Assert.assertEquals("Era 12?", prompt.getText());
                prompt.accept();                
                Assert.assertEquals(":D", prompt.getText());
                prompt.accept();   
            }

            
}
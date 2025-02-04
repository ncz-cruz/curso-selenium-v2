package com.example.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;

import com.example.core.DSL;
import com.example.core.DriverFactory;
import static com.example.core.DriverFactory.getDriver;


public class TesteAlert {
     
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
           public void checkAlert(){
             dsl.clickButtonId("alert");
              Alert alert = getDriver().switchTo().alert();
              Assert.assertEquals("Alert Simples", alert.getText());
              alert.accept();
            }

     @Test
            public void checkAlertConfirm(){
                //teste de OK
                dsl.clickButtonId("confirm");               
                Alert alert = getDriver().switchTo().alert();
                Assert.assertEquals("Confirm Simples", alert.getText());
                alert.accept();
                Assert.assertEquals("Confirmado", alert.getText());
                alert.accept();
                //teste de cancel
                dsl.clickButtonId("confirm");                  
                alert = getDriver().switchTo().alert();
                Assert.assertEquals("Confirm Simples", alert.getText());
                alert.dismiss();
                Assert.assertEquals("Negado", alert.getText());
                alert.dismiss();        
            }
            
            @Test
            public void checkAlertPrompt(){
                dsl.clickButtonId("prompt");               
                Alert prompt = getDriver().switchTo().alert();
                Assert.assertEquals("Digite um numero", prompt.getText());
                prompt.sendKeys("12");
                prompt.accept();    
                Assert.assertEquals("Era 12?", prompt.getText());
                prompt.accept();                
                Assert.assertEquals(":D", prompt.getText());
                prompt.accept();   
            }

            
}
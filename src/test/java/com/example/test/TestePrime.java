
package com.example.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.example.core.DSL;
import com.example.core.DriverFactory;
import static com.example.core.DriverFactory.getDriver;


public class TestePrime{
        
    private DSL dsl;
    
   @Before
   public void inicializa(){
       getDriver().get("http://primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=30736");
       dsl = new DSL();  
   }

   @After
   public void finaliza(){
      DriverFactory.killDriver();
   }

   @Test
    public void deveInteragirComRadioPrime(){    
        //option 1  
        dsl.clickButtonBy(By.xpath("//input[@id='j_idt249:line:0']/../..//span"));
        //option 2
        dsl.clickButtonBy(By.xpath("//input[@id='j_idt249:line:1']/../..//span"));
    }
} 

package com.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TesteRules {
   
    private WebDriver driver;
    private CampoTreinamentoPage page;
    private DSL dsl;

    @Before
    public void inicializa(){
        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(800, 800));
        driver.get("file:///"+ System.getProperty("user.dir") + "/src/resources/componentes.html");     
        page = new CampoTreinamentoPage(driver);

    }
    @After
    public void finaliza(){
        driver.quit();
    }

        @Test
        public void ruleName(){
           page.cadastrar();

           
            Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoeAceita(null));
                  
        }

        @Test
        public void rulesSurname(){
           page.setName("Jose");
           page.cadastrar();
            Alert alert = driver.switchTo().alert();
            Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
            alert.accept(); 
        }

        @Test
        public void rulesSex(){
            page.setName("Jose");
            page.setSurname("Eduardo");
            page.cadastrar();            
            Alert alert = driver.switchTo().alert();
            Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
            alert.accept(); 
        }

        @Test
        public void rulesFood(){
            page.setName("Jose");
            page.setSurname("Eduardo");           
            page.setSexoMasculino();
            page.setComidaCarne();  
            page.setComidaVeg();
            page.cadastrar();             
            Alert alert = driver.switchTo().alert();
            Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
            alert.accept(); 
    }
        @Test
        public void rulesSport(){
            page.setName("Jose");
            page.setSurname("Eduardo");           
            page.setSexoMasculino();
            page.setComidaCarne();  
            page.setEsportes("Karate");
            page.setEsportes("O que eh esporte?");           
            page.cadastrar(); 
            Alert alert = driver.switchTo().alert();
            Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
            alert.accept(); 
        }
}
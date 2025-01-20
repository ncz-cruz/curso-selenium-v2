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
    private DSL dsl;

    @Before
    public void inicializa(){
        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(800, 800));
        driver.get("file:///"+ System.getProperty("user.dir") + "/src/resources/componentes.html");     
    }
    @After
    public void finaliza(){
        driver.quit();
    }

        @Test
        public void ruleName(){
            dsl.clickButton("elementosForm:cadastrar");
            Alert alert = driver.switchTo().alert();
            Assert.assertEquals("Nome eh obrigatorio", alert.getText());
            alert.accept();      
        }

        @Test
        public void rulesSurname(){
            dsl.escreve("elementosForm:nome", "Jose");
            dsl.clickButton("elementosForm:cadastrar");
            Alert alert = driver.switchTo().alert();
            Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
            alert.accept(); 
        }

        @Test
        public void rulesSex(){
            dsl.escreve("elementosForm:nome", "Jose");
            dsl.escreve("elementosForm:nome", "Eduardo");
            dsl.clickButton("elementosForm:cadastrar");
            Alert alert = driver.switchTo().alert();
            Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
            alert.accept(); 
        }

        @Test
        public void rulesFood(){
           dsl.escreve("elementosForm:nome", "Jose");
           dsl.escreve("elementosForm:nome", "Eduardo");
           dsl.clickButton("elementosForm:sexo:0");
           dsl.clickButton("elementosForm:comidaFavorita:0");
           dsl.clickButton("elementosForm:comidaFavorita:3");
           dsl.clickButton("elementosForm:cadastrar");
            Alert alert = driver.switchTo().alert();
            Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
            alert.accept(); 
    }
        @Test
        public void rulesSport(){
            dsl.escreve("elementosForm:nome", "Jose");
            dsl.escreve("elementosForm:nome", "Eduardo");
            dsl.clickButton("elementosForm:sexo:0");
            dsl.clickButton("elementosForm:comidaFavorita:0");
            dsl.comboSelect("elementosForm:esportes", "Karate");
            dsl.comboSelect("elementosForm:esportes", "O que eh esporte?");            
            dsl.clickButton("elementosForm:cadastrar");
            Alert alert = driver.switchTo().alert();
            Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
            alert.accept(); 
        }
}
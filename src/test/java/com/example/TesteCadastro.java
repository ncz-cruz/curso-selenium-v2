package com.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteCadastro {

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
       driver.quit();
   }
 
    @Test
    public void testeTextField(){
       
        dsl.escreve("elementosForm:nome", "Jose");
        dsl.escreve("elementosForm:sobrenome", "Eduardo"); 
        dsl.clickRadioOrBox("elementosForm:sexo:0");
        dsl.clickRadioOrBox("elementosForm:comidaFavorita:2");
        dsl.comboSelect("elementosForm:escolaridade", "Superior");
        dsl.comboSelect("elementosForm:esportes", "Corrida");
        dsl.clickButton("elementosForm:cadastrar");
   

          Assert.assertTrue(dsl.getText("resultado").startsWith("Cadastrado!")); 
          Assert.assertTrue(dsl.getText("descNome").endsWith("Jose"));
          Assert.assertEquals("Sobrenome: Eduardo", dsl.getText("descSobrenome"));
          Assert.assertEquals("Sexo: Masculino", dsl.getText("descSexo"));
          Assert.assertEquals("Comida: Pizza", dsl.getText("descComida"));
          Assert.assertEquals("Escolaridade: superior", dsl.getText("descEscolaridade"));
          Assert.assertEquals("Esportes: Corrida", dsl.getText("descEsportes"));

          driver.quit();
       
      
      }
}

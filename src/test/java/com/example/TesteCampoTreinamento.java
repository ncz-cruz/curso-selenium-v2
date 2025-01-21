
package com.example;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

@SuppressWarnings("deprecation")

public class TesteCampoTreinamento {


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
      dsl.escreve("elementosForm:nome", "Teste escrita");
      Assert.assertEquals("Teste escrita", dsl.obterValorCampo("elementosForm:nome"));
      }

        @Test
        public void testeArea(){
         dsl.escreve("elementosForm:sugestoes", "Teste de área");  
           Assert.assertEquals("Teste de área", dsl.obterValorCampo("elementosForm:sugestoes"));
        }

        @Test
        public void radioInteraction(){
         dsl.clickButton("elementosForm:sexo:0");
         Assert.assertTrue(dsl.isSelected("elementosForm:sexo:0"));
     
         }   
           @Test
           public void boxInteraction(){
              dsl.clickButton("elementosForm:comidaFavorita:2");
              Assert.assertTrue(dsl.isSelected("elementosForm:comidaFavorita:2"));
            }   

            @Test
            public void comboInteraction(){
               dsl.comboSelect("elementosForm:escolaridade", "2o grau completo");
               Assert.assertEquals("2o grau completo", dsl.comboValue("elementosForm:escolaridade"));
            }		
            @Test
            public void valoresCombosMultiplo(){
               dsl.comboSelect("elementosForm:esportes", "Natacao");
               dsl.comboSelect("elementosForm:esportes", "Corrida");
             dsl.comboSelect("elementosForm:esportes", "O que eh esporte?");

             WebElement element = driver.findElement(By.id("elementosForm:esportes"));
             Select combo = new Select(element);
             List<WebElement> allSelectedOptionss = combo.getAllSelectedOptions();
             Assert.assertEquals(3, allSelectedOptionss.size());
             combo.deselectByVisibleText("Corrida");
             allSelectedOptionss = combo.getAllSelectedOptions();
             Assert.assertEquals(2, allSelectedOptionss.size());
              
            }
            @Test
            public void buttonInteraction(){
               dsl.clickButton("buttonSimple");
               WebElement botao =  driver.findElement(By.id("buttonSimple"));
                Assert.assertEquals ("Obrigado!", botao.getAttribute("value"));
               }

               @Test
               public void linkInteraction(){
                 dsl.clickLink("Voltar"); 
                  Assert.assertEquals("Voltou!", dsl.getText("resultado"));
               }
               
               @Test
               public void findText(){
                  Assert.assertTrue(dsl.getTagText("h3").contains("Campo de Treinamento"));
                  Assert.assertEquals("Campo de Treinamento", dsl.getTagText("h3"));
                  Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
                  driver.findElement(By.className("facilAchar")).getText());
               }

   }   


package com.example.test;

import static com.example.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.core.DSL;
import com.example.core.DriverFactory;

@SuppressWarnings("deprecation")

public class TesteCampoTreinamento {

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
    public void testeTextField(){
      dsl.escrevePorId("elementosForm:nome", "Teste escrita");
      Assert.assertEquals("Teste escrita", dsl.obterValorCampo("elementosForm:nome"));
      }

        @Test
        public void testeArea(){
         dsl.escrevePorId("elementosForm:sugestoes", "Teste de área");  
           Assert.assertEquals("Teste de área", dsl.obterValorCampo("elementosForm:sugestoes"));
        }

        @Test
        public void radioInteraction(){
         dsl.clickButtonId("elementosForm:sexo:0");
         Assert.assertTrue(dsl.isSelected("elementosForm:sexo:0"));
     
         }   
           @Test
           public void boxInteraction(){
              dsl.clickButtonId("elementosForm:comidaFavorita:2");
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

             WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
             Select combo = new Select(element);
             List<WebElement> allSelectedOptionss = combo.getAllSelectedOptions();
             Assert.assertEquals(3, allSelectedOptionss.size());
             combo.deselectByVisibleText("Corrida");
             allSelectedOptionss = combo.getAllSelectedOptions();
             Assert.assertEquals(2, allSelectedOptionss.size());
              
            }
            @Test
            public void buttonInteraction(){
               dsl.clickButtonId("buttonSimple");
               WebElement botao =  getDriver().findElement(By.id("buttonSimple"));
                Assert.assertEquals ("Obrigado!", botao.getAttribute("value"));
               }

               @Test
               public void linkInteraction(){
                 dsl.clickLink("Voltar"); 
                  Assert.assertEquals("Voltou!", dsl.getIdText("resultado"));
               }
               
               @Test
               public void findText(){
                  Assert.assertTrue(dsl.getTagText("h3").contains("Campo de Treinamento"));
                  Assert.assertEquals("Campo de Treinamento", dsl.getTagText("h3"));
                  Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
                  getDriver().findElement(By.className("facilAchar")).getText());
               }

               @Test
               public void testJavaScript(){
                  JavascriptExecutor js = (JavascriptExecutor) getDriver();
                  js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via Js'");
                  js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'Radio'");

                  WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
                  js.executeScript("arguments[0].style.border = arguments [1]", element, "solid 4px purple");
               }

               @Test
               public void deveClicarBotao(){
                 dsl.tabelaClickButton("Escolaridade", "Doutorado", "Botao", "//*[@id='elementosForm:tableUsuarios']");
               }

   }   

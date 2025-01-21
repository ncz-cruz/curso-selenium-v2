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
    private CampoTreinamentoPage page;

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
    public void deveValidarPessoaIndecisa(){
        page.setName("Nome");
        page.setSurname("Sobrenome");
        page.setSexoFeminino();
        page.setComidaCarne();
        page.setEscolaridade("Mestrado");
        page.setEsportes("Corrida");
        page.cadastrar();
   

          Assert.assertTrue(page.obterResultado().startsWith("Cadastrado!")); 
          Assert.assertTrue(page.obterNomeCadastro().endsWith("Nome"));
          Assert.assertEquals("Sobrenome: Sobrenome", page.obterSobrenomeCadastro());
          Assert.assertEquals("Sexo: Feminino", page.obterSexoCadastro());
          Assert.assertEquals("Comida: Carne", page.obterComidaCadastro());
          Assert.assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastro());
          Assert.assertEquals("Esportes: Corrida", page.obterEsportesCadastro());
          driver.quit();
       
      
      }
}

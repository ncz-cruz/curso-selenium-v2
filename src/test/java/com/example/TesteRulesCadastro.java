package com.example;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class TesteRulesCadastro {

    private WebDriver driver;
    private CampoTreinamentoPage page;
    private DSL dsl;

    @Parameter
    public String nome;
    @Parameter(value=1)
    public String sobrenome;
    @Parameter(value=2)
    public String sexo;
    @Parameter(value=3)
    public List <String> comidas;
    @Parameter(value=4)
    public String[] esportes;
    @Parameter(value=5)
    public String msg;
    

   @Before
   public void inicializa(){
       driver = new FirefoxDriver();
       driver.manage().window().setSize(new Dimension(800, 800));
       driver.get("file:///"+ System.getProperty("user.dir") + "/src/resources/componentes.html");     
       dsl = new DSL(driver);
       page = new CampoTreinamentoPage(driver);
   }
   @After
   public void finaliza(){
       driver.quit();
   }
    @Parameters
   public static Collection<Object[]> getCollection(){
    return Arrays.asList(new Object [][]{
        {"","","", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
        {"Jose","","", Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
        {"Jose","Eduardo","", Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
        {"Jose","Eduardo","Masculino", Arrays.asList("Carne", "Vegetariano"), new String[]{}, "Tem certeza que voce eh vegetariano?"},
        {"Jose","Eduardo","Masculino", Arrays.asList("Carne"), new String[]{"Karate", "O que eh esporte?"}, "Voce faz esporte ou nao?"}

    });
   }

    @Test
    public void deveValidarRules(){
        page.setName(nome);
        page.setSurname(sobrenome);           
        if(sexo.equals ("Masculino")){
            page.setSexoMasculino();
        } if(sexo.equals("Feminino")){ 
            page.setSexoFeminino();
        }   
        if (comidas.contains("Carne")) page.setComidaCarne();
        if (comidas.contains("Vegetariana")) page.setComidaVeg();
        page.setEsportes(esportes);
        page.cadastrar(); 
       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(msg, alert.getText());
        alert.accept(); 
       
    
            
    }

}

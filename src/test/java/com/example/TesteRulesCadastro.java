package com.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
       page = new CampoTreinamentoPage(driver);
       dsl = new DSL(driver);
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
        if (comidas.contains("Vegetariano")) page.setComidaVeg();
        page.setEsportes(esportes);
        page.cadastrar();
        dsl.alertaObterTextoEAceita(msg);
        
            
    }

}

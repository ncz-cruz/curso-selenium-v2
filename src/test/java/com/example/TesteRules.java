package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
        dsl = new DSL(driver);

    }
    @After
    public void finaliza(){
        driver.quit();
    }

        @Test
        public void ruleName(){
           page.cadastrar();
           dsl.alertaObterTextoEAceita("Nome eh obrigatorio");
        }

        @Test
        public void rulesSurname(){
           page.setName("Jose");
           page.cadastrar();
           dsl.alertaObterTextoEAceita("Sobrenome eh obrigatorio");         
        }

        @Test
        public void rulesSex(){
            page.setName("Jose");
            page.setSurname("Eduardo");
            page.cadastrar();            
            dsl.alertaObterTextoEAceita("Sexo eh obrigatorio");
        }

        @Test
        public void rulesFood(){
            page.setName("Jose");
            page.setSurname("Eduardo");           
            page.setSexoMasculino();
            page.setComidaCarne();  
            page.setComidaVeg();
            page.cadastrar();       
            dsl.alertaObterTextoEAceita("Tem certeza que voce eh vegetariano?");      
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
            dsl.alertaObterTextoEAceita("Voce faz esporte ou nao?");
            
        }
}
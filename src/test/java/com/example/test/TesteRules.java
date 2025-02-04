package com.example.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.core.DSL;
import com.example.core.DriverFactory;
import static com.example.core.DriverFactory.getDriver;
import com.example.page.CampoTreinamentoPage;

public class TesteRules {
   
  
    private CampoTreinamentoPage page;
    private DSL dsl;

    @Before
    public void inicializa(){
        getDriver().get("file:///"+ System.getProperty("user.dir") + "/src/resources/componentes.html");     
        page = new CampoTreinamentoPage();
        dsl = new DSL();

    }
    @After
    public void finaliza(){
        DriverFactory.killDriver();
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
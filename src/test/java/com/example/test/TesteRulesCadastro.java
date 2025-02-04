package com.example.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.example.core.BaseTest;
import com.example.core.DSL;
import static com.example.core.DriverFactory.getDriver;
import com.example.page.CampoTreinamentoPage;


@RunWith(Parameterized.class)
public class TesteRulesCadastro extends BaseTest{

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
       getDriver().get("file:///"+ System.getProperty("user.dir") + "/src/resources/componentes.html");     
       page = new CampoTreinamentoPage();
       dsl = new DSL();
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

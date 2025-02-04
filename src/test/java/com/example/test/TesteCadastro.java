package com.example.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.core.BaseTest;
import static com.example.core.DriverFactory.getDriver;
import com.example.page.CampoTreinamentoPage;

public class TesteCadastro extends BaseTest{

    private CampoTreinamentoPage page;

   @Before
   public void inicializa(){
        getDriver().get("file:///"+ System.getProperty("user.dir") + "/src/resources/componentes.html");     
        page = new CampoTreinamentoPage();
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
   
        Assert.assertEquals("Cadastrado!", page.obterResultado());
        Assert.assertEquals("Nome", page.obterNomeCadastro());
        Assert.assertEquals("Sobrenome", page.obterSobrenomeCadastro());  
        Assert.assertEquals("Feminino", page.obterSexoCadastro());
        Assert.assertEquals("Carne", page.obterComidaCadastro());
        Assert.assertEquals("mestrado", page.obterEscolaridadeCadastro());
        Assert.assertEquals("Corrida", page.obterEsportesCadastro());
      
      }
}

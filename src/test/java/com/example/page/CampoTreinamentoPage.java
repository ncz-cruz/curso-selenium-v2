package com.example.page;

import org.openqa.selenium.By;

import com.example.core.BasePage;

public class CampoTreinamentoPage extends BasePage {
  
    public void setName(String nome){
        dsl.escrevePorId("elementosForm:nome", nome);
    }
    public void setSurname(String nome){
        dsl.escrevePorId("elementosForm:sobrenome", nome);
    }

    public void setSexoMasculino(){
        dsl.clickButtonId("elementosForm:sexo:0");
    }
    public void setSexoFeminino(){
        dsl.clickButtonId("elementosForm:sexo:1");
    }

    public void setComidaCarne(){
        dsl.clickButtonId("elementosForm:comidaFavorita:0");
    }
    public void setComidaFrango(){
        dsl.clickButtonId("elementosForm:comidaFavorita:1");
     }
    public void setComidaPizza(){
        dsl.clickButtonId("elementosForm:comidaFavorita:2");
     }
    public void setComidaVeg(){
        dsl.clickButtonId("elementosForm:comidaFavorita:3");
     } 
 
    public void setEscolaridade(String valor){
        dsl.comboSelect("elementosForm:escolaridade", valor);
    }
    public void setEsportes(String... valores){
       for (String valor : valores) 
        dsl.comboSelect("elementosForm:esportes", valor);
    }
    
    public void cadastrar (){
        dsl.clickButtonId("elementosForm:cadastrar");
    }
    public String obterResultado(){
        return dsl.getByText(By.xpath("//*[@id='resultado']/span"));
    }
    public String obterNomeCadastro(){
        return dsl.getByText(By.xpath("//*[@id='descNome']/span"));
    }
    public String obterSobrenomeCadastro(){
        return dsl.getByText(By.xpath("//*[@id='descSobrenome']/span"));
    }
    public String obterSexoCadastro(){
        return dsl.getByText(By.xpath("//*[@id='descSexo']/span"));
    }
    public String obterComidaCadastro(){
        return dsl.getByText(By.xpath("//*[@id='descComida']/span"));
    }
    public String obterEscolaridadeCadastro(){
        return dsl.getByText(By.xpath("//*[@id='descEscolaridade']/span"));
    }
    public String obterEsportesCadastro(){
        return dsl.getByText(By.xpath("//*[@id='descEsportes']/span"));
    }

}



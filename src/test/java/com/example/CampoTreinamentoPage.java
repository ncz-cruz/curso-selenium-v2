package com.example;

import org.openqa.selenium.WebDriver;
public class CampoTreinamentoPage {
  
    private final DSL dsl;

    public CampoTreinamentoPage(WebDriver driver){
        this.dsl = new DSL(driver);
    }
    
    public void setName(String nome){
        dsl.escreve("elementosForm:nome", nome);
    }
    public void setSurname(String nome){
        dsl.escreve("elementosForm:sobrenome", nome);
    }

    public void setSexoMasculino(){
        dsl.clickButton("elementosForm:sexo:0");
    }
    public void setSexoFeminino(){
        dsl.clickButton("elementosForm:sexo:1");
    }

    public void setComidaCarne(){
       dsl.clickButton("elementosForm:comidaFavorita:0");
    }
    public void setComidaFrango(){
        dsl.clickButton("elementosForm:comidaFavorita:1");
     }
    public void setComidaPizza(){
        dsl.clickButton("elementosForm:comidaFavorita:2");
     }
    public void setComidaVeg(){
        dsl.clickButton("elementosForm:comidaFavorita:3");
     }
 
    public void setEscolaridade(String valor){
     dsl.comboSelect("elementosForm:escolaridade", valor);
    }
    public void setEsportes(String... valores){
       for (String valor : valores) 
            dsl.comboSelect("elementosForm:esportes", valor);
    }
    
    public void cadastrar (){
    dsl.clickButton("elementosForm:cadastrar");
    }
    public String obterResultado(){
        return dsl.getText("resultado");
    }
    public String obterNomeCadastro(){
        return dsl.getText("descNome");
    }
    public String obterSobrenomeCadastro(){
        return dsl.getText("descSobrenome");
    }
    public String obterSexoCadastro(){
        return dsl.getText("descSexo");
    }
    public String obterComidaCadastro(){
        return dsl.getText("descComida");
    }
    public String obterEscolaridadeCadastro(){
        return dsl.getText("descEscolaridade");
    }
    public String obterEsportesCadastro(){
        return dsl.getText("descEsportes");
    }

}



package com.example.core;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.example.core.DriverFactory.getDriver;

    public class DSL {

        public void escrevePorId(String id_campo, String texto){
            getDriver().findElement(By.id(id_campo)).sendKeys(texto);
        }
        public void escrevePorTag(String tag, String texto){
            getDriver().findElement(By.tagName(tag)).sendKeys(texto);
        }
        public String getIdText(String id){
            return getDriver().findElement(By.id(id)).getText();
        }
        public String getByText(By by){
            return getDriver().findElement(by).getText();
        }
    
        public String getTagText(String tagName){
            return  getDriver().findElement(By.tagName(tagName)).getText();
        }

        @SuppressWarnings("deprecation") //para o getAtributte n encher o saco
        public String obterValorCampo(String id_campo){
        return getDriver().findElement(By.id(id_campo)).getAttribute("value");
        }

        
        public boolean isSelected(String id){
        return getDriver().findElement(By.id(id)).isSelected();
        }

        public void comboSelect(String id, String valor){
            WebElement element = getDriver().findElement(By.id(id));   
            Select combo = new Select(element);
            combo.selectByVisibleText(valor); 
        }

        public String comboValue(String id){
            WebElement element = getDriver().findElement(By.id(id));   
            Select combo = new Select(element);
            return combo.getFirstSelectedOption().getText();   
    }

        public void clickButtonId(String id){
            getDriver().findElement(By.id(id)).click();
        }
        public void tabelaClickButton(String id){
            getDriver().findElement(By.id(id)).click();
        }
        
        public void clickButtonBy(By by){
            getDriver().findElement(by).click();
        }
        public void clickLink(String id){
            getDriver().findElement(By.linkText(id)).click();
        }
    
/*****************Frames e Janelas**************/
        public void entrarFrame(String id){
            getDriver().switchTo().frame(id);
        }
        public void sairFrame(){
            getDriver().switchTo().defaultContent();
        }
        public void trocarJanela(String id){
            getDriver().switchTo().window(id);
        }

/*****************Alertas**************/
        public String alertaObterTextoEAceita(String nome ){
            Alert alert = getDriver().switchTo().alert();
            String alertText = alert.getText();
            Assert.assertEquals(nome, alertText);
            alert.accept(); 
            return alertText;
        }
        public void alertaObterTextoENega(String nome){
            Alert alert = getDriver().switchTo().alert();
            String alertText = alert.getText();
            Assert.assertEquals(nome, alertText);
            alert.dismiss();
            
        }
        public void alertaEscrever(String value ){
            Alert alert = getDriver().switchTo().alert();
            alert.sendKeys(value);
            alert.accept(); 
                }

/************* JS ***********************/
        public Object jsExecutar(String cmd, Object... param){
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            return js.executeScript(cmd, param);
        }

/******************* Tabela **************/
        public void tabelaClickButton(String colunaBusca, String valor, String colunaBotao, String idTabela){
            //procurar coluna do registro
            WebElement tabela = getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
            int idColuna = obterIndiceColuna(colunaBusca, tabela);
            
            //encontrar a linha do registro
            int idLinha = obterIndiceLinha(valor, tabela, idColuna);
            
            //procurar coluna do botao
            int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
            
            //clicar no botao da celula encontrada
            WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
            celula.findElement(By.xpath(".//input")).click();	
        }

        protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
            List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
            int idLinha = -1;
            for(int i = 0; i < linhas.size(); i++) {
                if(linhas.get(i).getText().equals(valor)) {
                    idLinha = i+1;
                    break;
                }
            }
            return idLinha;
        }

        protected int obterIndiceColuna(String coluna, WebElement tabela) {
            List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
            int idColuna = -1;
            for(int i = 0; i < colunas.size(); i++) {
                if(colunas.get(i).getText().equals(coluna)) {
                    idColuna = i+1;
                    break;
                }
            }
            return idColuna;
        }
}



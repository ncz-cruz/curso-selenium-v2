package com.example;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

    public class DSL {

        private final WebDriver driver;

        public DSL(WebDriver driver){
            this.driver = driver;
        }

        public void escrevePorId(String id_campo, String texto){
            driver.findElement(By.id(id_campo)).sendKeys(texto);
        }
        public void escrevePorTag(String tagName, String texto){
            driver.findElement(By.id(tagName)).sendKeys(texto);
        }
        public String getText(String id){
            return driver.findElement(By.id(id)).getText();
        }
    
        public String getTagText(String tagName){
            return  driver.findElement(By.tagName(tagName)).getText();
        }

        @SuppressWarnings("deprecation") //para o getAtributte n encher o saco
        public String obterValorCampo(String id_campo){
        return driver.findElement(By.id(id_campo)).getAttribute("value");
        }

        
        public boolean isSelected(String id){
        return driver.findElement(By.id(id)).isSelected();
        }

        public void comboSelect(String id, String valor){
            WebElement element = driver.findElement(By.id(id));   
            Select combo = new Select(element);
            combo.selectByVisibleText(valor); 
        }

        public String comboValue(String id){
            WebElement element = driver.findElement(By.id(id));   
            Select combo = new Select(element);
            return combo.getFirstSelectedOption().getText();   
    }

    public void clickButton(String id){
        driver.findElement(By.id(id)).click();
    }

    public void clickLink(String id){
        driver.findElement(By.linkText(id)).click();
    }
    

/*****************Frames e Janelas**************/
    public void entrarFrame(String id){
        driver.switchTo().frame(id);
    }
    public void sairFrame(){
        driver.switchTo().defaultContent();
    }
    public void trocarJanela(String id){
        driver.switchTo().window(id);
    }

/*****************Alertas**************/
    public String alertaObterTextoEAceita(String nome ){
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(nome, alertText);
        alert.accept(); 
        return alertText;
    }
    public void alertaObterTextoENega(String nome){
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(nome, alertText);
        alert.dismiss();
        
    }
    public void alertaEscrever(String value ){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(value);
        alert.accept(); 
            }

    /************* JS ***********************/
    public Object jsExecutar(String cmd, Object... param){
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        return js.executeScript(cmd, param);
    }



}

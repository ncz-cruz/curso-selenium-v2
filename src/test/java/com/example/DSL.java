package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

    public class DSL {

        private final WebDriver driver;

        public DSL(WebDriver driver){
            this.driver = driver;
        }

        public void escreve(String id_campo, String texto){
            driver.findElement(By.id(id_campo)).sendKeys(texto);
        }

        @SuppressWarnings("deprecation")
        public String obterValorCampo(String id_campo){
        return driver.findElement(By.id(id_campo)).getAttribute("value");
        }

        //deprecated
        public void  clickRadioOrBox(String id){
            driver.findElement(By.id(id)).click();   
        } //

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
    
    public String getText(String id){
        return driver.findElement(By.id(id)).getText();
    }

    public String getTagText(String tagName){
        return  driver.findElement(By.tagName(tagName)).getText();

    }
        
}


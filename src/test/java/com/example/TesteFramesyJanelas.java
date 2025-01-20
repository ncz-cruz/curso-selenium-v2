package com.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

 public class TesteFramesyJanelas {

    private WebDriver driver;

   @Before
   public void inicializa(){
       driver = new FirefoxDriver();
       driver.manage().window().setSize(new Dimension(800, 800));
       driver.get("file:///"+ System.getProperty("user.dir") + "/src/resources/componentes.html");     
   }
   @After
   public void finaliza(){
       driver.quit();
   }

    @Test
    public void frameInteraction(){
      driver.switchTo().frame("frame1");

       driver.findElement(By.id("frameButton")).click();
       Alert alert = driver.switchTo().alert();
       Assert.assertEquals("Frame OK!", alert.getText());
      alert.accept(); 
      
      driver.switchTo().defaultContent();
      driver.findElement(By.id("elementosForm:nome")).sendKeys("msg");
      driver.quit(); 

    }

    @Test
    public void windowInteraction(){
       driver.findElement(By.id("buttonPopUpEasy")).click();
       driver.switchTo().window("Popup");
      driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
      driver.close();
      driver.switchTo().window(""); //Não funcionou sem handle depois do close
      driver.findElement(By.tagName("textarea")).sendKeys("E agora?");

   }


   @Test
   public void windowHandleInteraction(){
     driver.findElement(By.id("buttonPopUpEasy")).click();
      System.out.println(driver.getWindowHandle());
      System.out.println(driver.getWindowHandles());
      driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
// 9791a3be-474f-4f9b-ab47-65ad74e09446
      driver.findElement(By.tagName("textArea")).sendKeys("Deu certo?");
      driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
      driver.findElement(By.tagName("textArea")).sendKeys("E agora?");


}
}

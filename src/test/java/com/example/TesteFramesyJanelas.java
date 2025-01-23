package com.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
 public class TesteFramesyJanelas {

    private WebDriver driver;
    private DSL dsl;

   @Before
   public void inicializa(){
       driver = new FirefoxDriver();
       driver.manage().window().setSize(new Dimension(800, 800));
       driver.get("file:///"+ System.getProperty("user.dir") + "/src/resources/componentes.html");     
       dsl = new DSL (driver);
   }
   @After
   public void finaliza(){
     // driver.quit();
   }

    @Test
    public void frameInteraction(){
      dsl.entrarFrame("frame1");
      dsl.clickButton("frameButton");
      dsl.alertaObterTextoEAceita("Frame OK!");
      dsl.sairFrame();
      dsl.escrevePorTag("elementosForm:nome", "msg");
    }

    @Test
    public void windowInteraction(){
      dsl.clickButton("buttonPopUpEasy");
      dsl.trocarJanela("Popup");
      dsl.escrevePorTag("textarea", "Deu certo?");
      driver.close();
      dsl.trocarJanela("");
     //Não funcionou sem handle depois do close, teria que utilizaar o JS
      driver.findElement(By.tagName("textarea")).sendKeys("E agora?");
   }

    @Test
    public void deveInteragirComFrameEscondida(){
      WebElement frame = driver.findElement(By.id("frame2"));
      dsl.jsExecutar("window.scrollBy(0, arguments[0])",frame.getLocation().y);
      dsl.entrarFrame("frame2");
      dsl.clickButton("frameButton");
      String msg = dsl.alertaObterTextoEAceita("Frame OK!");    
      Assert.assertEquals("Frame OK!", msg);


   }


   @Test
   public void windowHandleInteraction(){
    dsl.clickButton("buttonPopUpHard"); 
    System.out.println(driver.getWindowHandle());
    System.out.println(driver.getWindowHandles());
      driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
      dsl.escrevePorTag("textarea", "Deu certo?");
      driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
      dsl.escrevePorTag("textarea", "E agora?");
//Selenium da como Unable to find text area
    }
}

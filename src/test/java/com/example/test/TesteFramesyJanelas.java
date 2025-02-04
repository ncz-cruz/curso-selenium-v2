package com.example.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.core.DSL;
import com.example.core.DriverFactory;
import static com.example.core.DriverFactory.getDriver;

 public class TesteFramesyJanelas {

    private DSL dsl;

   @Before
   public void inicializa(){
       getDriver().get("file:///"+ System.getProperty("user.dir") + "/src/resources/componentes.html");     
       dsl = new DSL();
   }
   @After
   public void finaliza(){
     DriverFactory.killDriver();

   }
    @Test
    public void frameInteraction(){
      dsl.entrarFrame("frame1");
      dsl.clickButtonId("frameButton");
      dsl.alertaObterTextoEAceita("Frame OK!");
      dsl.sairFrame();
      dsl.escrevePorTag("elementosForm:nome", "msg");
    }
   @Test
    public void windowInteraction(){
      dsl.clickButtonId("buttonPopUpEasy");
      dsl.trocarJanela("Popup");
      dsl.escrevePorTag("textarea", "Deu certo?");
      dsl.trocarJanela("");
      getDriver().findElement(By.tagName("textarea")).sendKeys("E agora?");
   }
    @Test
    public void deveInteragirComFrameEscondida(){
      WebElement frame = getDriver().findElement(By.id("frame2"));
      dsl.jsExecutar("window.scrollBy(0, arguments[0])",frame.getLocation().y);
      dsl.entrarFrame("frame2");
      dsl.clickButtonId("frameButton");
      String msg = dsl.alertaObterTextoEAceita("Frame OK!");    
      Assert.assertEquals("Frame OK!", msg);
   }
   @Test
   public void windowHandleInteraction(){
    dsl.clickButtonId("buttonPopUpHard"); 
    System.out.println(getDriver().getWindowHandle());
    System.out.println(getDriver().getWindowHandles());
      getDriver().switchTo().window((String) getDriver().getWindowHandles().toArray()[1]);
      dsl.escrevePorTag("textarea", "Deu certo?");
      getDriver().switchTo().window((String)getDriver().getWindowHandles().toArray()[0]);
      dsl.escrevePorTag("textarea", "E agora?");
    }
}

package com.example.core;

import org.junit.After;

public class BaseTest {

    @After  
    public void finaliza(){
     DriverFactory.killDriver();
   }
 

}

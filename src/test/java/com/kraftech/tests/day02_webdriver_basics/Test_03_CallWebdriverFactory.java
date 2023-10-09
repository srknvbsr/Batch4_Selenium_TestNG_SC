package com.kraftech.tests.day02_webdriver_basics;

import com.kraftech.utlities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class Test_03_CallWebdriverFactory {
    public static void main(String[] args) {
        /**
         * set up a chrome driver with WebDriverFactory
         * navigate to https://tr-tr.facebook.com/
         * verify that the url is correct
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        
        driver.manage().window().maximize();
        driver.get("https://tr-tr.facebook.com/");
        String actuallyUrl = driver.getCurrentUrl();
        String expectedUrl= "https://tr-tr.facebook.com/";

        if(actuallyUrl.equals(expectedUrl)){
            System.out.println("Pass");
        }else{
            System.out.println("Failed");
        }

        driver.close();


    }


}


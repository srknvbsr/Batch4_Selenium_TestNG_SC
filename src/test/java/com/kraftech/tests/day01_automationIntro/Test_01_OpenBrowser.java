package com.kraftech.tests.day01_automationIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_01_OpenBrowser {

    public static void main(String[] args){


        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("http://www.google.com");
        driver.get("http://facebook.com");


        String actualTitle = driver.getTitle();
        String expectedTitle = driver.getTitle();



    }
}

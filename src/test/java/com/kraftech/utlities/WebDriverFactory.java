package com.kraftech.utlities;

import io.github.bonigarcia.wdm.WdmAgent;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static void main(String[] args) {
        getDriver("chrome");


    }

    public static WebDriver getDriver(String browserType){
        WebDriver driver = null;
        switch(browserType.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();

        }
        return driver;
    }

}

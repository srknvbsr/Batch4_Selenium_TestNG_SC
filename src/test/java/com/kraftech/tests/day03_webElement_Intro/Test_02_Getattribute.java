package com.kraftech.tests.day03_webElement_Intro;

import com.kraftech.utlities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_02_Getattribute {
    public static void main(String[] args) throws InterruptedException {
        /**
         * set up a chrome browser and navigate to https://www.krafttechexlab.com/login
         * send "Karalama" text to email box
         * get the written text by using getAttribute() method
         * get the id value by using getAttribute() method
         * verify both
         */


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        Thread.sleep(2000);


       WebElement webElementBox = driver.findElement(By.id("email"));
        webElementBox.sendKeys("Karalama");

        Thread.sleep(3000);

        String actualValue = webElementBox.getAttribute("value");
        System.out.println("actualValue = " + actualValue);
        String expectedValue = "Karalama";


        String actualId = webElementBox.getAttribute("id");
        System.out.println("actualId = " + actualId);
        String expectedId = "email";

        if (actualValue.equals(expectedValue) && actualId.equals(expectedId)) {
            System.out.println("pass");
        } else {
            System.out.println("failed");
        }

        driver.quit();



    }
}

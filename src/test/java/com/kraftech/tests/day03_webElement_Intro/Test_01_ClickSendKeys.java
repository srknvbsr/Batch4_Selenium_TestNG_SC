package com.kraftech.tests.day03_webElement_Intro;

import com.kraftech.utlities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test_01_ClickSendKeys {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Open chorme browser
         * navigate to https://www.amazon.com/
         * write "Java" to the search bar
         * click search button
         * verify that the text contains "Java"
         */


        WebDriver drive = WebDriverFactory.getDriver("chrome");

        drive.get("https://www.amazon.com/");
        Thread.sleep(2000);


        WebElement searchtBox = drive.findElement(By.id("twotabsearchtextbox"));
        searchtBox.sendKeys("Java");
        Thread.sleep(2000);


        WebElement searchBtn = drive.findElement(By.id("nav-search-submit-button"));
        searchBtn.click();
        Thread.sleep(2000);


        WebElement resultElement = drive.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));

        String actuallyText = resultElement.getText();
        String expectedText = "Java";
        Thread.sleep(2000);

        if (actuallyText.contains(expectedText)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }
        drive.quit();
    }
}


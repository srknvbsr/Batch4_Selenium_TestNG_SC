package com.kraftech.tests.tasks;

import com.kraftech.utlities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Task_1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test

    /**
     * https://demowebshop.tricentis.com/contactus
     */
    public void demoWebShop() throws InterruptedException {
        driver.get("https://demowebshop.tricentis.com/contactus");
        List<WebElement> inputaAndTExtareaElements = driver.findElements(By.xpath("//input | //textarea"));

        List<WebElement> addElements = new ArrayList<>();

        addElements.add(inputaAndTExtareaElements.get(4));
        addElements.add(inputaAndTExtareaElements.get(5));
        addElements.add(inputaAndTExtareaElements.get(6));
        addElements.add(inputaAndTExtareaElements.get(7));

        /*
        for (WebElement element : addElements) {
            String name = element.getAttribute("name");
            System.out.println("Element name: " + name);
        }

         */

        addElements.get(0).sendKeys("Serkan");
        Thread.sleep(2000);
        addElements.get(1).sendKeys("mike@hotmail.com");
        Thread.sleep(2000);
        addElements.get(2).sendKeys("you are a man");
        Thread.sleep(2000);
        addElements.get(3).click();

       /* inputaAndTExtareaElements.get(4).sendKeys("Serkan");
        Thread.sleep(2000);
        inputaAndTExtareaElements.get(5).sendKeys("mike@hotmail.com");
        Thread.sleep(2000);
        inputaAndTExtareaElements.get(6).sendKeys("you are a man");
        Thread.sleep(2000);
        inputaAndTExtareaElements.get(7).click();

        */

        Thread.sleep(3000);


    }
}

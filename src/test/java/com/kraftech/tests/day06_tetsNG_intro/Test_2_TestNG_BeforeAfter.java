package com.kraftech.tests.day06_tetsNG_intro;

import com.kraftech.utlities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Test_2_TestNG_BeforeAfter {
WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown(){

    }

    @Test
    public void getAttributeTest() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.krafttechexlab.com/login");
        Thread.sleep(2000);
        WebElement formElement = driver.findElement(By.xpath("//form"));
        System.out.println("formElement.getAttribute(\"class\") = " + formElement.getAttribute("class"));
        System.out.println("formElement.getAttribute(\"enctype\") = " + formElement.getAttribute("enctype"));
        System.out.println("formElement.getAttribute(\"method\") = " + formElement.getAttribute("method"));
        System.out.println("formElement.getAttribute(\"novalidate\") = " + formElement.getAttribute("novalidate"));

        System.out.println("formElement.getTagName() = " + formElement.getTagName());
        System.out.println("formElement.getLocation() = " + formElement.getLocation());
        System.out.println("formElement.getCssValue(\"font\") = " + formElement.getCssValue("font"));
        System.out.println("formElement.getCssValue(\"font-size\") = " + formElement.getCssValue("font-size"));
        System.out.println("----------------------------------------------------------");
        System.out.println("formElement.getAttribute(\"innerHTML\") = " + formElement.getAttribute("innerHTML"));
        System.out.println("----------------------------------------------------------");
        System.out.println("formElement.getAttribute(\"outerHTML\") = " + formElement.getAttribute("outerHTML"));


        driver.close();
    }

    @Test
    public void findElements() throws InterruptedException {
        /**
         * navigate to https://www.saucedemo.com/
         * locate following three elements with one locater : username box, password box and login button
         * send "standard_user" to username box
         * send "secret_sauce" to password box
         * click Login button
         * then take all product names to a web element list and print the text of elements
         */

        driver.navigate().to("https://www.saucedemo.com/");
        List<WebElement> elementList = driver.findElements(By.xpath("//form/..//input"));
        elementList.get(0).sendKeys("standard_user");
        Thread.sleep(2000);
        elementList.get(1).sendKeys("secret_sauce");
        Thread.sleep(2000);
        elementList.get(2).click();
        Thread.sleep(2000);

        List<WebElement> productElements = driver.findElements(By.cssSelector(".inventory_item_name"));

        for (WebElement product : productElements) {
            System.out.println("product.getText() = " + product.getText());
        }
        System.out.println("--------------------------------------------------------------");

        productElements.forEach(product->System.out.println(product.getText()));
        System.out.println("--------------------------------------------------------------");
        productElements.forEach(product->{
            System.out.println(product.getText());
        });
    }
}

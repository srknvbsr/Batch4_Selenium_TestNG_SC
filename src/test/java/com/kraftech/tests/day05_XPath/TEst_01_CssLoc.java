package com.kraftech.tests.day05_XPath;

import com.kraftech.utlities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.Key;

public class TEst_01_CssLoc {

    static WebDriver driver = WebDriverFactory.getDriver("chrome");

    public static void main(String[] args) throws InterruptedException {


   /*
        driver.get("http://www.krafttechexlab.com/login");

        driver.findElement(By.cssSelector("input#email")).sendKeys("maho@hotmail.com");
        WebElement password = driver.findElement(By.cssSelector("[type='password']"));
        Thread.sleep(2000);

        password.sendKeys("Maho123456789" + Keys.TAB+Keys.TAB+ Keys.ENTER);
        Thread.sleep(2000);
        //WebElement loginBtn = driver.findElement(By.cssSelector("button"));
        //loginBtn.click();

        //loginBtn.submit();//enter tuşuna basma işini görür.
        Thread.sleep(2000);

        driver.close();

         */
        /**
         * navigate to https://demowebshop.tricentis.com/desktops
         * click on Simple Computer Add to cart button by using item name in the locator
         * close driver
         */

        driver.get("https://demowebshop.tricentis.com/desktops");
        driver.manage().window().maximize();


        //navigateTabMenu("Jewelry");
        Thread.sleep(2000);

        //addTCart("Create Your Own Jewelry");
        Thread.sleep(2000);

        driver.close();
    }

    public static void addTCart(String str) throws InterruptedException {
        WebElement addToCartBtn = driver.findElement(By.xpath("//a[text()='" + str + "']/ancestor::div[@class='details']//input"));
        addToCartBtn.click();
        Thread.sleep(2000);

    }

    public static void navigateTabMenu(String tabName) {
        driver.findElement(By.partialLinkText(tabName)).click();

    }
    public static void navigateAndAdd(String tabName, String productName) throws InterruptedException {
        driver.findElement(By.partialLinkText(tabName)).click();
        Thread.sleep(2000);
        WebElement product = driver.findElement(By.xpath("//a[text()='" + productName + "']/ancestor::div[@*='details" +
                "']//input"));
        product.click();
    }


}

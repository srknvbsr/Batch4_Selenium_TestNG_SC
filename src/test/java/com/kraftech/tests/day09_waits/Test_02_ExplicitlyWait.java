package com.kraftech.tests.day09_waits;

import com.kraftech.utlities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test_02_ExplicitlyWait {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void explicitlyWait() {
        /**
         * navigate to https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html
         * click the Start button and wait until the One button will be activated
         * click the One button and wait until the Two button will be activated
         * click the Two button and wait until the Three button will be activated
         * verify that the "All Buttons Clicked" message is taken.
         */

        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
        WebDriverWait wait = new WebDriverWait(driver,10);

        WebElement startBtn = driver.findElement(By.id("button00"));
        wait.until(ExpectedConditions.elementToBeClickable(startBtn)).click();

        WebElement oneBtn = driver.findElement(By.id("button01"));
        wait.until(ExpectedConditions.elementToBeClickable(oneBtn)).click();
        WebElement twoBtn = driver.findElement(By.id("button02"));
        wait.until(ExpectedConditions.elementToBeClickable(twoBtn)).click();

        WebElement threeBtn = driver.findElement(By.id("button03"));
        wait.until(ExpectedConditions.elementToBeClickable(threeBtn)).click();

        WebElement message = driver.findElement(By.id("buttonmessage"));
        String actualMessage=message.getText();
        String expectedMessage ="All Buttons Clicked";

        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test
    public void explicitlyWait_2() {

        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
        List<WebElement> buttons = driver.findElements(By.xpath("//button"));
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//button"),4));


        wait.until(ExpectedConditions.elementToBeClickable(buttons.get(0)));
        wait.until(ExpectedConditions.elementToBeClickable(buttons.get(1)));
        wait.until(ExpectedConditions.elementToBeClickable(buttons.get(2)));
        wait.until(ExpectedConditions.elementToBeClickable(buttons.get(3)));

    }

    @Test
    public void testexplicitlyWait_3() {
        /**
         * eğer element henüz dom'da yoksa locate edemeyiz. hata alırız. bu durumlarda
         * wait metodlarına web element yerine By.locator göndermek çözüm olabilir.
         *
         *
         *
         * navigate to https://the-internet.herokuapp.com/dynamic_loading
         * click second link
         * click start button
         * use explicitly wait for the hello element and get the text (do not use any other wait)
         * verify that the element has the text of "Hello World!"
         */
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        WebDriverWait wait =new WebDriverWait(driver,10);

        driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();

    }





}

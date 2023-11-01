package com.kraftech.tests.day08_Alerts_MultipleWindows_İframe;

import com.kraftech.utlities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_01_Alerts {
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
    public void htmlPopUp() throws InterruptedException {
        /**
         * navigate to https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html
         * click show alert box
         * verify that ok button can be seen on the popup
         * then click ok at the popup
         * verify that ok button cannot be seen
         */


        driver.get("https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html");
        Thread.sleep(2000);

        WebElement showAlertBox = driver.findElement(By.cssSelector("#fakealert"));
        showAlertBox.click();
        Thread.sleep(2000);

        WebElement okBtn = driver.findElement(By.xpath("//button[text()='OK']"));

        Assert.assertTrue(okBtn.isDisplayed());
        okBtn.click();
        Thread.sleep(2000);

        Assert.assertFalse(okBtn.isDisplayed());


    }

    @Test
    public void jsAlerts() throws InterruptedException {
        /**
         * navigate to https://testpages.herokuapp.com/styled/alerts/alert-test.html
         * click alert box
         * then take message on the js popup and print it
         * accept alert
         *
         * click show confirm box
         * Then take message on the js popup and print it
         * dismiss alert
         *
         * click show prompt box
         * then take message on the js popup and print it
         * send Ahmet to the popup box
         * accept alert
         * verify that Ahmet is sent to the box.
         */

        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
        WebElement alertBox = driver.findElement(By.cssSelector("#alertexamples"));
        alertBox.click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);

        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.cssSelector("#confirmexample"));
        element.click();
        Thread.sleep(2000);
        System.out.println(alert.getText());
        alert.dismiss();

        WebElement thirdBtn = driver.findElement(By.cssSelector("#promptexample"));
        thirdBtn.click();
        Thread.sleep(2000);
        System.out.println(alert.getText());
        alert.sendKeys("Ahmet");
        alert.accept();
        Thread.sleep(2000);

        String actualText = driver.findElement(By.cssSelector("#promptreturn")).getText();
        String expected ="Ahmet";
        Thread.sleep(2000);

        Assert.assertEquals(actualText,expected);

    }


}

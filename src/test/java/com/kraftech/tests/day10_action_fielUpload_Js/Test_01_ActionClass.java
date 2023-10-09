package com.kraftech.tests.day10_action_fielUpload_Js;

import com.kraftech.utlities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.accessibility.AccessibleTable;
import java.util.concurrent.TimeUnit;

public class Test_01_ActionClass {
    WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void rightClickOpenNewWindow() {
        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");

    }

}

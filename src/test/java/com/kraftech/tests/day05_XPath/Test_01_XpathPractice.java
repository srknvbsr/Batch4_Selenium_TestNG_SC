package com.kraftech.tests.day05_XPath;

import com.github.javafaker.Faker;
import com.kraftech.utlities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.awt.*;
import java.util.List;

public class Test_01_XpathPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=WebDriverFactory.getDriver("chrome");

        driver.get("http://www.krafttechexlab.com/login");
        WebElement form = driver.findElement(By.xpath("//form[@class='row g-3 needs-validation']"));
        System.out.println("form.getText() = " + form.getText());

        List<WebElement> inputs = driver.findElements(By.xpath("//input"));
        inputs.get(0).sendKeys("Serkan");
        inputs.get(1).sendKeys("Çağlar");
        inputs.get(2).click();
        Thread.sleep(3000);

    }
}

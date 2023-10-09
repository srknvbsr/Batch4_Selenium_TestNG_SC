package com.kraftech.tests.day04_basic_locators;

import com.github.javafaker.Faker;
import com.kraftech.utlities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicLocatorPractice {
    public static void main(String[] args) throws InterruptedException {
        /**
         * task
         * open a chrome browser
         * navigate to https://www.krafttechexlab.com/login
         * locate email box with id and send a full name by using java faker to the box
         * locate email box with name and clear current name and send a new full name by using java faker to the box
         * locate login button with tag name and click the button
         * locate Remember me element with class name and get the text of element and print it
         * locate Create an account link with link text and click it
         * locate Log in link with partial link text with "Log" text and click it
         */

        Faker faker = new Faker();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.krafttechexlab.com/login");

        WebElement email = driver.findElement(By.id("email"));

        email.sendKeys(faker.name().fullName());
        Thread.sleep(2000);

        email.clear();
        Thread.sleep(2000);


        WebElement email1 = driver.findElement(By.name("email"));

        email1.sendKeys(faker.name().fullName());
        Thread.sleep(2000);

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        WebElement rememberMeELement = driver.findElement(By.className("form-check-label"));
        System.out.println("rememberMeELement.getText() = " + rememberMeELement.getText());

        WebElement anAccount = driver.findElement(By.partialLinkText("an account"));
        anAccount.click();
        Thread.sleep(2000);



        driver.close();

    }
}

package com.kraftech.tests.day03_webElement_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_03_GetAttirubute_Practice {
    public static void main(String[] args) {

        /**
         * set up a chrome driver and navigate to http://ourvirtualmarket.com/
         * then close pop up
         * click login link
         * send "fdsddss" to email box
         * then click login
         * then take the message that appears on email box and print the message
         * use lazy way with this task
         */
        WebDriverManager.chromedriver().setup();
        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("http://ourvirtualmarket.com/");

        // Close the pop-up
        //WebElement closedPopUp = driver.findElement(By.cssSelector("i[class='fa fa-angle-down shrink_icon']"));
        driver.getWindowHandles();
        String windowHandle="";
        WebDriver window = driver.switchTo().window(windowHandle);



        // Click the login link
        WebElement loginLink = driver.findElement(By.linkText("Login"));
        loginLink.click();

        // Enter the email address
        WebElement emailBox = driver.findElement(By.id("email"));
        emailBox.sendKeys("fdsddss");

        // Click the login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Get the message that appears on the email box
        WebElement messageElement = driver.findElement(By.id("message"));
        String message = messageElement.getText();

        // Print the message
        System.out.println("Message: " + message);

        // Close the browser
        driver.quit();











        /*
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://ourvirtualmarket.com/");

        WebElement closedPopUp = driver.findElement(By.cssSelector("i[class='fa fa-angle-down shrink_icon']"));
        System.out.println("closedPopUp.getAttribute() = " + closedPopUp.getAttribute("validationMessage"));


        WebElement loginLink = driver.findElement(By.cssSelector("a[class='link-lg']"));
        loginLink.click();


        WebElement emailBox=driver.findElement(By.xpath("//input[@id='email']"));
        System.out.println("emailBox.getText() = " + emailBox.getAttribute("value"));

        WebElement loginBox = driver.findElement(By.xpath("//span[text()='Login']"));
        loginBox.getAttribute("validationMessage");

        WebElement message = driver.findElement(By.id("message"));
        System.out.println("message.getAttribute(\"validationMessage\") = " + message.getAttribute("validationMessage"));

 */


    }
}

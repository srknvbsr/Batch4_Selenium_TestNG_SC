package com.kraftech.tests.day01_automationIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_02_WindowMethod {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.krafttechnologie.com/");
        driver.manage().window().maximize();


        //ekranın ölçüerini alma
        Dimension size = driver.manage().window().getSize();
        System.out.println(size);

        //drieverin pointını alma--->açılan driver pencerisinin sol üst noktasını verir.
        Point position = driver.manage().window().getPosition();
        System.out.println("position = " + position);

        driver.manage().window().setPosition(new Point(-2000, 0));
        driver.manage().window().maximize();
        //driverın boyutunu ayarlayalım
        driver.manage().window().setSize(new Dimension(800, 600));

        driver.close();

    }


}

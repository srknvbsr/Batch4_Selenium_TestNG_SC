package com.kraftech.tests.day10_action_fielUpload_Js;

import com.kraftech.utlities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Test_02_FileUpLoad {
    WebDriver driver;


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
    public void fileUpLoad(){
        driver.get("https://demoqa.com/upload-download");
        WebElement upLoadFile = driver.findElement(By.id("#uploadFile"));
        upLoadFile.sendKeys("C:\\Users\\serka\\OneDrive\\Masaüstü\\jjjj.txt");

        String fileName="jjjj.txt";

        String text = driver.findElement(By.cssSelector("#uploadedFilePath")).getText();
        WebElement loadedFile = driver.findElement(By.cssSelector("#uploadedFilePath"));

        Assert.assertTrue(loadedFile.getText().contains(fileName));

        Assert.assertEquals(text,fileName);
    }
    @Test
    public void systemProperties(){
        Properties properties = System.getProperties();
        //properties.list(System.out);

        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.dir"));
    }
    @Test
    public void fileUpLoad_2(){
        driver.get("https://demoqa.com/upload-download");

        WebElement upLoadFile = driver.findElement(By.id("#uploadFile"));

        String projectPath=System.getProperty("user.dir");
        String filePath ="src/test/resources/ggg.txt";
        String fullPath = projectPath+"/"+filePath;

        String fileName="ggg.txt";
        WebElement loadedFile = driver.findElement(By.cssSelector("#uploadedFilePath"));

        Assert.assertTrue(loadedFile.getText().contains(fileName));


    }



}

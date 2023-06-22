package com.kraftech.tests.day02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_02_GetMethod {
    public static void main(String[] args) {
        /**
         * set up a chrome driver
         * navigate to https://www.hepsiburada.com/
         * get title and get url
         * verify that title, url and Page source codes  contain "hepsiburada"
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.hepsiburada.com/");
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();
        String sourcePage = driver.getPageSource();

        if(title.toLowerCase().contains("hepsiburada")&&url.toLowerCase().contains("hepsiburada")&&sourcePage.toLowerCase()
                .contains("hepsiburada")){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }


        /*Benim yaptığım örnek sonucu:
        boolean titleKeyword = title.toLowerCase().contains("hepsiburada");
        boolean urlKeyword = url.toLowerCase().contains("hepsiburada");
        boolean pageSourceKeyword = sourcePage.toLowerCase().contains("hepsiburada");

        System.out.println("titleKeyword = " + titleKeyword);
        System.out.println("urlKeyword = " + urlKeyword);
        System.out.println("pageSourceKeyword = " + pageSourceKeyword);

         */
        driver.quit();


    }
}

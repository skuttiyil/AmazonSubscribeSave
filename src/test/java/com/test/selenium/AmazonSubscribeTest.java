package com.test.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.tracing.Span;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AmazonSubscribeTest {
    @Test
    public void amazontest() {
        System.setProperty("webdriver.chrome.driver", "C:\\sunitha\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.amazon.com/Subscribe-Save/b?ie=UTF8&node=5856181011");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("pet food");
            driver.findElement(By.id("nav-search-submit-button")).click();
            driver.findElement(By.linkText("Blue Buffalo Life Protection Formula Natural Adult Dry Dog Food")).click();
            Select quantity = new Select(driver.findElement(By.id("rcxsubsQuan")));
            quantity.selectByIndex(3);
            Select frequency = new Select(driver.findElement(By.id("rcxOrdFreqOnml")));
            frequency.selectByIndex(2);
            driver.findElement(By.id("rcx-subscribe-submit-button-announce")).click();
            wait(20000);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //Commented for demo reasons
            // driver.close();
        }
    }
}

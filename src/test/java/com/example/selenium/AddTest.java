package com.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddTest {

    @Test
    public void testAddition() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("file://" + System.getProperty("user.dir") + "/src/main/webapp/index.html");

        driver.findElement(By.id("num1")).sendKeys("10");
        driver.findElement(By.id("num2")).sendKeys("20");

        driver.findElement(By.tagName("button")).click();

        Thread.sleep(2000);

        String result = driver.findElement(By.id("result")).getAttribute("value");

        assertEquals("30", result);

        driver.quit();
    }
}
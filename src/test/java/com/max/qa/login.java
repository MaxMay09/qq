package com.max.qa;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.jws.WebMethod;
import java.util.concurrent.TimeUnit;

public class login {

    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.get("https://learn.allearsenglish.com/login/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }
    @Test
    public void loginTest() throws InterruptedException {
        //wd.findElement(By.xpath("//*[@id=\'user_login\']")).clear();
        //click(By.xpath("//*[@id=\'user_login\']"));
        //wd.findElement(By.xpath("//*[@id=\'user_login\']")).click();
        //wd.findElement(By.xpath("//*[@id=\'user_login\']")).sendKeys("maxmay0872@gmail.com");
        type(By.xpath("//*[@id=\'user_login\']"), "maxmay0872@gmail.com" );

        //wd.findElement(By.xpath("//*[@id=\'user_pass\']")).clear();
        //click(By.xpath("//*[@id=\'user_pass\']"));
        // wd.findElement(By.xpath("//*[@id=\'user_pass\']")).click();
        //wd.findElement(By.xpath("//*[@id=\'user_pass\']")).sendKeys("sENNrQYIFTTV");
        type(By.xpath("//*[@id=\'user_pass\']"), "sENNrQYIFTTV" );

        Thread.sleep(5000);
        click(By.xpath("/html/body/div[1]/section/div/div[1]/div/div[4]/div/div/div/form/div[4]/button"));
        Thread.sleep(5000);
        new WebDriverWait(wd, 80).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div[1]/section[2]/div[2]/div[1]/div/div/div/div/div/div[1]/img")));
        Thread.sleep(5000);
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }
    public void type(By locator, String text){
        wd.findElement(locator).clear();
        click(locator);
        wd.findElement(locator).sendKeys(text);


    }
    @AfterMethod
    public void tearDown(){
        wd.quit();

    }
}

package testCase;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ReadXLSdata;

public class LoginTest extends BaseTest {


    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "LoginTest")
    public static void LoginTest(String username, String password) throws InterruptedException {
        System.out.println("Vào rồi nhớ!!!!!!");

        driver.findElement(By.xpath(loc.getProperty("username"))).clear();
        driver.findElement(By.xpath(loc.getProperty("password"))).clear();

        if()

        driver.findElement(By.xpath(loc.getProperty("username"))).sendKeys(username);
        driver.findElement(By.xpath(loc.getProperty("password"))).sendKeys(password);
        Thread.sleep(4000);
        driver.findElement(By.xpath(loc.getProperty("login_button"))).click();
        Thread.sleep(8000);
    }
}

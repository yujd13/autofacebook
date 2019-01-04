package com.elecsoft.www;

import com.google.common.base.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.spec.ECParameterSpec;
import java.sql.Driver;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FaceBook {
    private WebDriver driver;


    public FaceBook(String browserType, String driverPath) {
        this.driver = Setup(browserType, driverPath, driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver Setup(String browserType, String driverPath, WebDriver driver) {
        System.setProperty(browserType, driverPath);
        switch (browserType) {
            case "webdriver.chrome.driver":
                driver = new ChromeDriver();
                break;
            case "webdriver.gecko.driver":
                driver = new FirefoxDriver();
                break;
            case "webdriver.edge.driver":
                driver = new EdgeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", driverPath);
                driver = new ChromeDriver();
                break;


        }
        return driver;


    }


    public boolean fillAccount(Object account) {
        List<String> ac = ((List) account);
        Iterator<String> stringIterator = ac.iterator();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[type=\"text\"]")).sendKeys(stringIterator.next());
        driver.findElement(By.xpath("//*[@name=\"lastname\"]")).sendKeys(stringIterator.next());
        String signUpEmail = stringIterator.next();
        driver.findElement(By.xpath("//*[@id=\"u_0_h\"]")).sendKeys(signUpEmail);

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@aria-label=\"Re-enter email\"]")))).sendKeys(signUpEmail);
        driver.findElement(By.cssSelector("input[data-type=\"password\"]")).sendKeys(stringIterator.next());

        WebElement month = driver.findElement(By.xpath("//*[@id=\"month\"]"));
        Select selectMonth = new Select(month);
        selectMonth.selectByVisibleText(stringIterator.next());


        new Select(driver.findElement(By.cssSelector("select[name=\"birthday_day\"]"))).selectByVisibleText(stringIterator.next());
        new Select(driver.findElement(By.xpath("//*[@id=\"year\"]"))).selectByVisibleText(stringIterator.next());

        driver.findElement(By.cssSelector("input[value=\"" + stringIterator.next() + "\"]")).click();
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();


        return true;
    }
}

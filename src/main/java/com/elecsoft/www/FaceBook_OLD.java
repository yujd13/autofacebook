package com.elecsoft.www;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceBook_OLD {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nkomal\\Documents\\lib\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        driver.findElement(By.id("email")).sendKeys("Email@email.com");
        int a = 10;
        int b = 15;
        System.out.printf("a = %d, b = %d", a,b);

        WebElement loginEmail = driver.findElement(By.id("email"));
        System.out.println("Get Text = " + loginEmail.getText());
        System.out.println("Location details = " + loginEmail.getLocation());
        System.out.println("get Attribute " + loginEmail.getAttribute("attribute"));
        System.out.println("get Css Value " + loginEmail.getCssValue("hello"));
        System.out.println("tag name = " + loginEmail.getTagName());

        driver.findElement(By.name("pass")).sendKeys("Password");
        driver.findElement(By.cssSelector("input[type=\"text\"]")).sendKeys("FirstName");
//        driver.findElement(By.className("inputtext _58mg _5dba _2ph-")).sendKeys("LastName");
        driver.findElement(By.xpath("//*[@name=\"lastname\"]")).sendKeys("LastName");
//        driver.findElement(By.partialLinkText("count?")).click();
        String signUpEmail= "Email@email.com";
        driver.findElement(By.xpath("//*[@id=\"u_0_h\"]")).sendKeys(signUpEmail);
        driver.findElement(By.xpath("//*[@aria-label=\"Re-enter email\"]")).sendKeys(signUpEmail);
        driver.findElement(By.cssSelector("input[data-type=\"password\"]")).sendKeys("Password");

        WebElement month = driver.findElement(By.xpath("//*[@id=\"month\"]"));
        Select selectMonth = new Select(month);
        selectMonth.selectByIndex(10);
        selectMonth.selectByVisibleText("Apr");


        new Select(driver.findElement(By.cssSelector("select[name=\"birthday_day\"]"))).selectByIndex(1);
        new Select(driver.findElement(By.xpath("//*[@id=\"year\"]"))).selectByValue("1995");

        driver.findElement(By.cssSelector("input[value=\"2\"]")).click();
//        driver.findElement(By.cssSelector("//html//body//div//div//div//form//table//tbody//tr//td//input")).sendKeys("hello");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();


    }
}

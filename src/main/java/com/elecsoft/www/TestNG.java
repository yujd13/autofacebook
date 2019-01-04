package com.elecsoft.www;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestNG {
   private FaceBook fb;
   @BeforeMethod
   public void beforeMethod() throws InterruptedException {
      fb = new FaceBook("webdriver.chrome.driver",  "C:\\Users\\nkomal\\Documents\\lib\\chromedriver.exe");
      fb.getDriver().get("https://www.facebook.com/");
   }

   @Test
   public void getOnWebSite(){
      fb.getDriver().get("https://www.seleniumhq.org/docs/03_webdriver.jsp#chromedriver");
      Assert.assertEquals(fb.getDriver().getCurrentUrl(), "https://www.seleniumhq.org/docs/03_webdriver.jsp#chromedriver");
   }

//   @Test
//   public void mathFunction(){
//      int expectedCondition = 5;
//      int actualCondition = 3+7;
//      Assert.assertEquals(actualCondition,expectedCondition, "Math doesn't add up");
//   }


//
//   @Test
//   public void testOne(){
//
//      System.out.println(testCase.toString());
//
//      fb.fillAccount(testCase);
//
//      fb.getDriver().findElement(By.name("firstname")).getAttribute("");
//
//      Assert.assertEquals(testCase.getFirstName(), "Jonathan", "name doesn't match up");
//
//
//   }

   @AfterMethod
   public void afterMethod(){
      fb.getDriver().close();
   }
}

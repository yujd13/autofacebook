package com.elecsoft.facebook;

import com.elecsoft.www.FaceBook;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class functionalTests {

    private FaceBook fb;
    private String baseUrl = "https://www.facebook.com/";


    @BeforeMethod
    public void setup(ITestContext name){
        fb = new FaceBook("webdriver.chrome.driver",  "C:\\Users\\nkomal\\Documents\\lib\\chromedriver.exe");
        fb.getDriver().get("https://testng.org/doc/index.html");
    }

    @Test(groups = {"functest", "checkintest"})
    public void fillTestAccount(){
        Assert.assertEquals(fb.getDriver().getCurrentUrl(), "https://testng.org/doc/index.html");
    }

    @AfterMethod
    public void afterMethod(){
        fb.getDriver().close();
    }
}

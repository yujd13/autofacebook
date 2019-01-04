package com.elecsoft.facebook;

import com.elecsoft.www.Account;
import com.elecsoft.www.Excel;
import com.elecsoft.www.FaceBook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.testng.AssertJUnit.assertEquals;

public class FaceBookSignUpTest {
    private FaceBook fb;
    private String baseUrl = "https://www.facebook.com/";
    @DataProvider(name = "create_account")
    public Object[] createAccount() {
        return new Object[]{new Account("John", "Doe", "john@email.com", "password", "Dec", "24", "1996", 2)
                , new Account("Jane", "Hu", "Jane@email.com", "password", "Jan", "13", "2000", 1)};
    }

    @DataProvider(name = "create_account_excel")
    public Object[] createAccountExcel(ITestContext context) throws IOException {
        System.out.println(context.getCurrentXmlTest().getParameter("filePath"));
        System.out.println(context.getCurrentXmlTest().getParameter("sheetName"));
        Object[] result = Excel.getExcelData(context.getCurrentXmlTest().getParameter("filePath"), context.getCurrentXmlTest().getParameter("sheetName"));
        return result;
    }

    @BeforeMethod
    public void setup(ITestContext context) {
        String browserType = context.getCurrentXmlTest().getParameter("browserType");
        String driverPath = context.getCurrentXmlTest().getParameter("driverPath");
        fb = new FaceBook(browserType, driverPath);
        fb.getDriver().get(baseUrl);
    }

    @Test(dataProvider = "create_account_excel")
    public void testFillAccounts(Object ac) {
        fb.fillAccount(ac);
        WebDriverWait wait = new WebDriverWait(fb.getDriver(), 20);

        String expectedCondition = baseUrl;

        By validText = By.id("reg_error_inner");
        wait.until(ExpectedConditions.visibilityOf(fb.getDriver().findElement(validText)));

        assertEquals(fb.getDriver().getCurrentUrl(),baseUrl);



//        Assert.assertEquals(fb.getDriver().findElement(validText).getText(), "There is an existing account associated with email@email.com");
    }

    @AfterMethod
    public void afterMethod() {
        fb.getDriver().close();
    }
}

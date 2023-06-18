package com.aoc.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aoc.base.TestBase;
import com.aoc.pages.LoginPage;
public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    public LoginPageTest() {
        super();
    }
    @BeforeMethod
    public void setUpLoginPage() {
        loginPage = new LoginPage();
    }
    //    @Test(priority = 1, description = "Validate Login Btn is enabled when user name and password are filled")
//    public void loginPageTitleTest() {
//        String title = loginPage.validateLoginPageTitle();
//        Assert.assertEquals(title, "");
//    }
//
//    @Test(priority = 2)
//    public void logoImageTest() {
//        boolean flag = loginPage.validateImage();
//        Assert.assertTrue(flag);
//    }
    @Test(priority = 1)
    public void loginTest() {
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
}
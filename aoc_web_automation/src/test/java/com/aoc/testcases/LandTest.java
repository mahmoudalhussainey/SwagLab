package com.aoc.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aoc.base.TestBase;
import com.aoc.pages.LoginPage;
import com.aoc.pages.LandPage;

import javax.xml.datatype.Duration;
import java.util.List;

public class LandTest extends TestBase {
    LoginPage loginPage;
    LandPage LandTest;
    public LandTest() {
        super();
    }
    @BeforeMethod
    public void setUpLoginPage() {
        loginPage = new LoginPage();
        LandTest=new LandPage();
    }
    @Test(priority = 1)
    public void HomePage_Test() {
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
  }
    @Test(priority = 2)
    public void Jordan() {
        LandTest.container();
    }
    @Test
    public void getTitleTest() {


        String actualTitle = LandPage.driver.getTitle();
        String expectedTitle = "Swag Labs";

       Assert.assertEquals(actualTitle,expectedTitle);
       System.out.println(actualTitle);
    }
    @Test(priority = 3)
    public void testCase() {

        int expectedItems = LandTest.getExpectedItems();
        LandTest.clickAllButtons();

        int actualItemsAdded = LandTest.getActualItemsAdded();
        Assert.assertEquals(expectedItems, actualItemsAdded);
        System.out.println(actualItemsAdded);

//        driver.quit();
         }
    @Test(priority = 4)
    public void sortItemsLowToHigh() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        LandTest.clickSortDropdown();
        LandTest.selectSortOptionLowToHigh();

        List<Double> editedPriceList = LandTest.getEditedPriceList();

        for (int i = 0; i < editedPriceList.size(); i++) {
            boolean checkProcess = editedPriceList.get(0) < editedPriceList.get(editedPriceList.size() - 1);
            Assert.assertEquals(checkProcess, true);
            System.out.println(checkProcess);
        }

}
}
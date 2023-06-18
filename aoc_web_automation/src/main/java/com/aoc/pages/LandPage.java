package com.aoc.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aoc.base.TestBase;

import java.util.ArrayList;
import java.util.List;

public class LandPage extends TestBase {
    //Page Factory :
    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select")
    WebElement container;
    private By sortDropdown = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");
    private By sortOptionLowToHigh = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]");
    private By itemPriceList = By.className("inventory_item_price");

//    @FindBy(xpath = "//*[@id=\"login-button\"]")
//    WebElement AddCart;
//
//    List<WebElement> myButtons = driver.findElements(By.className("btn"));


    public LandPage() {PageFactory.initElements(driver, this);
    }

    public void container () {
        container.click();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", loginBtn);
    }
    public String getTitle() {
        return driver.getTitle();
    }
    public int getExpectedItems() {
        return 6;
    }

    public void clickAllButtons() {
        List<WebElement> myButtons = driver.findElements(By.className("btn"));
        for (int i = 0; i < myButtons.size(); i++) {
            myButtons.get(i).click();
        }
    }

    public int getActualItemsAdded() {
        WebElement itemsAddedElement = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
        String actualItemsAdded = itemsAddedElement.getText();
        return Integer.parseInt(actualItemsAdded);
    }
    public void clickSortDropdown() {
        WebElement sortDropdownElement = driver.findElement(sortDropdown);
        sortDropdownElement.click();
    }

    public void selectSortOptionLowToHigh() {
        WebElement sortOptionElement = driver.findElement(sortOptionLowToHigh);
        sortOptionElement.click();
    }

    public List<Double> getEditedPriceList() {
        List<Double> editedPriceList = new ArrayList<>();
        List<WebElement> priceElements = driver.findElements(itemPriceList);

        for (int z = 0; z < priceElements.size(); z++ ) {
            String price = priceElements.get(z).getText();
            String editedPrice = price.replace("$", " ");
            double val = Double.parseDouble(editedPrice.trim());
            editedPriceList.add(val);
        }

        return editedPriceList;
    }

}
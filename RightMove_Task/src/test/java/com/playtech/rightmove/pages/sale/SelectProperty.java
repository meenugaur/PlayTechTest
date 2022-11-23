package com.playtech.rightmove.pages.sale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class SelectProperty {
    private WebDriver driver;
    private By sort_price = By.xpath("//select[@id='sortType']");
    private By select_house = By.xpath("//*[@id=\"property-129356462\"]/div/div/div[3]/div/a/div[1]");
    //private By select_house = By.xpath("//*[@id=\"property-85949898\"]/div/div/div[3]/div/a/div[1]");

    //Constructor to initialize with Webdriver
    public SelectProperty(WebDriver d) {
        this.driver = d;
    }

    //Property to set sorting based on price in the searched result
    public void setSort_price() {
        Select dropdown = new Select(driver.findElement(sort_price));
        List<WebElement> option = dropdown.getOptions();
        for (WebElement element : option) {
            if (element.getText().contains("Newest Listed")) {
                element.click();
                break;
            }
        }
       // Assert.assertEquals("Lowest Price", dropdown.getFirstSelectedOption().getText().trim());
    }

    //Method to return 1st featured property
    public boolean setSelect_house() {
        return driver.findElement(select_house).isDisplayed();

    }
}
package com.playtech.rightmove.pages.rent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectRentProperty {
    private WebDriver driver;
    private By sort_price = By.id("sortType");
    private By select_house = By.tagName("img");

    public SelectRentProperty(WebDriver d) {
        this.driver = d;
    }

    public void setSort_price() {
        Select dropdown = new Select(driver.findElement(sort_price));
        List<WebElement> option = dropdown.getOptions();
        for (WebElement element : option) {
            if (element.getText().contains("Lowest Price")) {
                element.click();
                break;
            }
        }
    }

    public boolean setSelect_house() {
        return driver.findElement(select_house).isDisplayed();
    }
}
package com.playtech.rightmove.pages.sale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class SearchParameters {
    private WebDriver driver;
    private By search_radius = By.id("radius");
    private By price_min = By.xpath("//select[@id='minPrice']");
    private By price_max = By.xpath("//select[@id='maxPrice']");
    private By bedroom_rangeMin = By.xpath("//select[@id='minBedrooms']");
    private By bedroom_rangeMax = By.xpath("//select[@id='maxBedrooms']");
    private By property_type = By.xpath("//select[@id='displayPropertyType']");
    private By find_Btn = By.xpath("//button[@id='submit']");

    //Constructor to initialize with web-driver
    public SearchParameters(WebDriver d) {
        this.driver = d;
    }

    //Property to set radius selection for the search
    public void getRadius_Value() {
        Select dropdown = new Select(driver.findElement(search_radius));
        List<WebElement> option = dropdown.getOptions();
        for (WebElement element : option) {
            if (element.getText().contains("5")) {
                element.click();
                break;
            }
        }
    }

    //Property to set min price selection for the search
    public void setPrice_min() {
        WebElement webElement = driver.findElement(price_min);
        Select dropdown1 = new Select(webElement);
        dropdown1.selectByValue("200000");
    }

    //Property to set max price selection for the search
    public void setPrice_max() {
        WebElement webElement = driver.findElement(price_max);
        Select dropdown1 = new Select(webElement);
        dropdown1.selectByValue("250000");
    }

    //Property to set min bedroom selection for the search
    public void setBedroom_rangeMin() {
        WebElement webElement = driver.findElement(bedroom_rangeMin);
        Select dropdown = new Select(webElement);
        dropdown.selectByValue("3");
    }

    //Property to set max bedroom selection for the search
    public void setBedroom_rangeMax() {
        WebElement webElement = driver.findElement(bedroom_rangeMax);
        Select dropdown1 = new Select(webElement);
        dropdown1.selectByValue("4");
    }

    //Property to set property type for the search like house/flat etc
    public void setProperty_type() {
        WebElement webElement = driver.findElement(property_type);
        Select dropdown1 = new Select(webElement);
        dropdown1.selectByVisibleText("Houses");
    }

    //Method to simulate button click for the search
    public void clickThe_FindButton() {
        driver.findElement(find_Btn).click();
    }

    //Method to verify the text from searched result
    public void verifyText() {
        String ActualText = driver.findElement(By.xpath("//*[@id=\"headerTitle\"]")).getText();
        String ExpectedText = "property for sale in CV3";
        Assert.assertEquals(ActualText,ExpectedText);
    }
}
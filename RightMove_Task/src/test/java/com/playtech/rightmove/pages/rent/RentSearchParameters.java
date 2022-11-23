package com.playtech.rightmove.pages.rent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class RentSearchParameters {
    private WebDriver driver;
    private By search_radius = By.id("radius");
    private By price_min = By.xpath("//select[@id='minPrice']");
    private By price_max = By.xpath("//select[@id='maxPrice']");
    private By bedroom_rangeMin = By.xpath("//select[@id='minBedrooms']");
    private By bedroom_rangeMax = By.xpath("//select[@id='maxBedrooms']");
    private By property_type = By.xpath("//select[@id='displayPropertyType']");
    private By find_Btn = By.xpath("//button[@id='submit']");

    //Constructor to pass webdriver to initiate
    public RentSearchParameters(WebDriver d) {
        this.driver = d;
    }

    //Property to search properties based on the radius to entered postcode
    public void getRadius_Value() {
        Select dropdown = new Select(driver.findElement(search_radius));
        List<WebElement> option = dropdown.getOptions();
        for (WebElement element : option) {
            //Selecting radius as within 1 mile
            if (element.getText().contains("1")) {
                element.click();
                break;
            }
        }
        //Assert based on match for within 1 mile
        Assert.assertEquals("Within 1 mile",dropdown.getFirstSelectedOption().getText().trim());
    }

    //Property to set min price for the search
    public void setPrice_min() {
        WebElement webElement = driver.findElement(price_min);
        Select dropdown1 = new Select(webElement);
        dropdown1.selectByValue("1000");
    }

    //Property to set max price for the search
    public void setPrice_max() {
        WebElement webElement = driver.findElement(price_max);
        Select dropdown1 = new Select(webElement);
        dropdown1.selectByValue("1200");
    }

    //Property to set min bedroom selection for the search
    public void setBedroom_rangeMin() {
        WebElement webElement = driver.findElement(bedroom_rangeMin);
        Select dropdown = new Select(webElement);
        dropdown.selectByValue("2");
    }

    //Property to set max bedroom selection for the search
    public void setBedroom_rangeMax() {
        WebElement webElement = driver.findElement(bedroom_rangeMax);
        Select dropdown1 = new Select(webElement);
        dropdown1.selectByValue("3");
    }

    //Property to set property type like house/flat etc
    public void setProperty_type() {
        WebElement webElement = driver.findElement(property_type);
        Select dropdown1 = new Select(webElement);
        dropdown1.selectByVisibleText("Houses");
        Assert.assertEquals("Houses",dropdown1.getFirstSelectedOption().getText().trim());
    }

    //Method to simulate button click for property search
    public void clickThe_FindButton() {
        driver.findElement(find_Btn).click();
    }
}
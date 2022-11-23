package com.playtech.rightmove.pages.sale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Home {
    private WebDriver driver;
    private By search = By.cssSelector("input[placeholder=\"e.g. 'York', 'NW3', 'NW3 5TY' or 'Waterloo Station'\"]");
    private By sale_btn = By.xpath("//button[normalize-space()='For Sale']");

    public Home(WebDriver d) {
        this.driver = d;
    }

    public void enterPostcode(String uname) {
        driver.findElement(search).sendKeys(uname);
    }

    public void searchProperty_ForSale() {
        driver.findElement(sale_btn).click();
    }

    public void verifyTittle() {
        String ActualTitle = driver.getTitle();
        String ExpectedTittle = "Find property for sale in CV3";
        Assert.assertEquals(ActualTitle, ExpectedTittle);
    }
}

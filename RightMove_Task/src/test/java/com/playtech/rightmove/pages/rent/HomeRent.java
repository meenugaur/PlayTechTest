package com.playtech.rightmove.pages.rent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomeRent {
    private WebDriver driver;
    private By search = By.cssSelector("input[placeholder=\"e.g. 'York', 'NW3', 'NW3 5TY' or 'Waterloo Station'\"]");
    private By rent_btn = By.xpath("//*[@id=\"_3OuiRnbltQyS534SB4ivLV\"]/div/div/div/button[2]");

    public HomeRent(WebDriver d) {
        this.driver = d;
    }

    //method to feed post code
    public void enterPostcode(String uname) {
        driver.findElement(search).sendKeys(uname);
    }

    //method to search properties based on the postcode entered
    public void searchProperty_ForRent() {
        driver.findElement(rent_btn).click();
    }

    //Assert test success by matching the expected title to currently rendered title
    public void verifyTittle() {
        String ActualTitle = driver.getTitle();
        String ExpectedTittle = "Find property to rent in CV3";
        Assert.assertEquals(ActualTitle, ExpectedTittle);
    }
}

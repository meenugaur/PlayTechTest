package com.playtech.rightmove.runners;

import com.playtech.rightmove.pages.rent.HomeRent;
import com.playtech.rightmove.pages.rent.RentSearchParameters;
import com.playtech.rightmove.pages.rent.SelectRentProperty;
import com.playtech.rightmove.utilities.Base;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class TestRentRunner extends Base {
    WebDriver driver = null;
    HomeRent home;
    RentSearchParameters searchParameters;
    SelectRentProperty selectRentProperty;

    @Before
    public void setUp() {
        super.setUp();
        driver = getDriver();
    }

    @Test
    public void user_enter_postcode_forRent() {
        home = new HomeRent(driver);
        driver.get("https://www.rightmove.co.uk/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        home.enterPostcode("CV3");
        home.searchProperty_ForRent();
        home.verifyTittle();
    }

    @Test
    public void user_enter_parametersForHouse() {
        user_enter_postcode_forRent();
        searchParameters = new RentSearchParameters(driver);
        //driver.get("https://www.rightmove.co.uk/property-to-rent/search.html?searchLocation=CV3&useLocationIdentifier=false&locationIdentifier=&rent=To+rent");
        searchParameters.getRadius_Value();
        searchParameters.setPrice_min();
        searchParameters.setPrice_max();
        searchParameters.setBedroom_rangeMin();
        searchParameters.setBedroom_rangeMax();
        searchParameters.setProperty_type();
        searchParameters.clickThe_FindButton();
    }

    @Test
    public void user_Select_House_ForRent() {
        user_enter_parametersForHouse();
        //driver.navigate().to("https://www.rightmove.co.uk/property-to-rent/find.html?locationIdentifier=OUTCODE%5E562&maxBedrooms=3&minBedrooms=2&maxPrice=1200&minPrice=1000&radius=1.0&sortType=1&propertyTypes=detached%2Csemi-detached%2Cterraced&includeLetAgreed=false&mustHave=&dontShow=&furnishTypes=&keywords=");
        driver.getCurrentUrl();
        selectRentProperty = new SelectRentProperty(driver);
        selectRentProperty.setSort_price();
        selectRentProperty.setSelect_house();
    }
}
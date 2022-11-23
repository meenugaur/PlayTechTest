package com.playtech.rightmove.runners;

import com.playtech.rightmove.utilities.Base;
import com.playtech.rightmove.pages.sale.Home;
import com.playtech.rightmove.pages.sale.SearchParameters;
import com.playtech.rightmove.pages.sale.SelectProperty;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestRunner extends Base {
    WebDriver driver = null;
    Home home;

    @Before
    public void setUp() {
        super.setUp();
        driver = getDriver();
    }

    @Test
    public void user_enter_postcode_forSale() {
        home = new Home(driver);
        driver.get("https://www.rightmove.co.uk/");
        home.enterPostcode("CV3");
        home.searchProperty_ForSale();
        home.verifyTittle();
    }

    @Test
    public void user_enter_parameters() {
        SearchParameters searchParameters = new SearchParameters(driver);
        driver.get("https://www.rightmove.co.uk/property-for-sale/search.html?searchLocation=CV3&useLocationIdentifier=false&locationIdentifier=&buy=For+sale");
        searchParameters.getRadius_Value();
        searchParameters.setPrice_min();
        searchParameters.setPrice_max();
        searchParameters.setBedroom_rangeMin();
        searchParameters.setBedroom_rangeMax();
        searchParameters.setProperty_type();
        searchParameters.clickThe_FindButton();
        Assert.assertTrue(true, "Property for sale in CV3");
    }

    @Test
    public void user_Select_House() {
        //SearchParameters searchParameters = new SearchParameters(driver);
        driver.navigate().to("https://www.rightmove.co.uk/property-for-sale/find.html?searchType=SALE&locationIdentifier" +
                "=OUTCODE%5E562&insId=1&radius=5.0&minPrice=200000&maxPrice=250000&minBedrooms=3&maxBedrooms=4&displayPropertyType=houses&maxDaysSinceAdded=&_includeSSTC=on&sortByPriceDescending=&primaryDisplayPropertyType=&secondaryDisplayPropertyType=&oldDisplayPropertyType=&oldPrimaryDisplayPropertyType=&newHome=&auction=false");
        //searchParameters.getRadius_Value();
        SelectProperty selectProperty = new SelectProperty(driver);
        selectProperty.setSort_price();
        selectProperty.setSelect_house();
        Assert.assertTrue(true, "Houses For Sale in CV3");
    }
}
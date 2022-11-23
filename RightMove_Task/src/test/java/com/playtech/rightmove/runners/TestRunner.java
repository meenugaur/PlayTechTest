package com.playtech.rightmove.runners;

import com.playtech.rightmove.utilities.Base;
import com.playtech.rightmove.pages.sale.Home;
import com.playtech.rightmove.pages.sale.SearchParameters;
import com.playtech.rightmove.pages.sale.SelectProperty;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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
    public void user_enter_postcode_forHouseSale() {
        home = new Home(driver);
        driver.get("https://www.rightmove.co.uk/");
        home.enterPostcode("CV3");
        home.searchProperty_ForSale();
        home.verifyTittle();
    }

    @Test
    public void user_enter_parameters_To_SelectTheProperty() {
        user_enter_postcode_forHouseSale();
        SearchParameters searchParameters = new SearchParameters(driver);
        searchParameters.getRadius_Value();
        searchParameters.setPrice_min();
        searchParameters.setPrice_max();
        searchParameters.setBedroom_rangeMin();
        searchParameters.setBedroom_rangeMax();
        searchParameters.setProperty_type();
        searchParameters.verifyText();
        searchParameters.clickThe_FindButton();


    }

    @Test
    public void user_Select_House_ForSale() {
        user_enter_parameters_To_SelectTheProperty();
        SelectProperty selectProperty = new SelectProperty(driver);
        selectProperty.setSort_price();
        selectProperty.setSelect_house();
    }
}
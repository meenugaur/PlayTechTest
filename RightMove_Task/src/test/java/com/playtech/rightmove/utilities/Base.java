package com.playtech.rightmove.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Properties;

public class Base {
    private WebDriver driver = null;
    private static Logger log = Logger.getLogger(Base.class);

    public WebDriver getDriver() {
        return driver;
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeClass
    public static void setUPForAllTest() {
        PropertyConfigurator.configure("log4j.properties");
        log.info("Before class");
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
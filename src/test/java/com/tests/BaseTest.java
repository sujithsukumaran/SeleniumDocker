package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUpDriver() throws MalformedURLException {

        String host = "localhost";
        DesiredCapabilities dc = new DesiredCapabilities();

        if(System.getProperty("BROWSER")!=null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            dc.setBrowserName("firefox");
            FirefoxOptions options = new FirefoxOptions();
            options.merge(dc);
        }
        else {
            dc.setBrowserName("chrome");
            ChromeOptions options = new ChromeOptions();
            options.merge(dc);
        }

        if(System.getProperty("HUB_HOST")!=null)
          host = System.getProperty("HUB_HOST");

        String completeURL="http://"+host+":4444/wd/hub";
        System.out.println(completeURL);
        this.driver=new RemoteWebDriver(new URL(completeURL),dc);
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }
}

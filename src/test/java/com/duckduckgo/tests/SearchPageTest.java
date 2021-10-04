package com.duckduckgo.tests;

import com.duckduckgo.pages.SearchPage;
import com.tests.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchPageTest extends BaseTest {

    @Test
    @Parameters("searchWord")
    public void searchTest(String searchWord){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goToURL();
        searchPage.searchOp(searchWord);

    }


}

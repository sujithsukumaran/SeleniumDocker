package com.duckduckgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.stream.Stream;

public class SearchPage {

    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(id = "search_form_input_homepage")
    private WebElement searchBox;

    @FindBy(id = "search_button_homepage")
    private WebElement searchBtn;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goToURL() {
        this.driver.get("https://duckduckgo.com");
    }

    public void searchOp(String searchWord) {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchBox));
        this.searchBox.sendKeys(searchWord);
        this.searchBtn.click();
    }

}

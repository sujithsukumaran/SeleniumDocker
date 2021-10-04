package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookFlightsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="reserveFlights")
    private WebElement reserveFlightsBtn;

    @FindBy(name="buyFlights")
    private WebElement buyFlightsBtn;

    public BookFlightsPage(WebDriver driver) {
        this.driver=driver;
        this.wait= new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }

    public void clickReserveFlightsBtn(){
        this.reserveFlightsBtn.click();
    }

    public void clickBuyFlightsBtn(){
        this.buyFlightsBtn.click();
    }


}

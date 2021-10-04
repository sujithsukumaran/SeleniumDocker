package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath="//font[contains(text(), 'Flight Itinerary Page')]")
    private WebElement flightsItinTxt;

    @FindBy(xpath="//font[contains(text(), 'USD')]")
    private List<WebElement> prices;

    @FindBy(linkText="SIGN-OFF")
    private WebElement signOffLink;

    public FlightConfirmationPage(WebDriver driver) {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

     public String getFlightsPrice() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightsItinTxt));
         System.out.println(this.flightsItinTxt.getText());
         String totalPrice = this.prices.get(1).getText();
         this.signOffLink.click();
         return totalPrice;
     }

}

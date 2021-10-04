package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="firstName")
        private WebElement firstNameTxt;

    @FindBy(name="lastName")
    private WebElement lastNameTxt;

    @FindBy(name="email")
    private WebElement userNameTxt;

    @FindBy(name="password")
    private WebElement passwordTxt;

    @FindBy(name="confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name="register")
    private WebElement submitBtn;


    public RegistrationPage(WebDriver driver) {
        this.driver=driver;
        this.wait=new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }

    public void loadWebPage(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        this.wait.until(ExpectedConditions.visibilityOf(firstNameTxt));
    }

    public void enterUserDetails(String firstName, String lastName){
        this.firstNameTxt.sendKeys(firstName);
        this.lastNameTxt.sendKeys(lastName);
    }

    public void enterUserCred(String userName, String password, String confirmPassword){
        this.userNameTxt.sendKeys(userName);
        this.passwordTxt.sendKeys(password);
        this.confirmPasswordTxt.sendKeys(confirmPassword);
    }

    public void clickSubmit(){
        this.submitBtn.click();
    }
}

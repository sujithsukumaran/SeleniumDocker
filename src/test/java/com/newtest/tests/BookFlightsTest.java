package com.newtest.tests;

import com.newtours.pages.*;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightsTest extends BaseTest {


    @Test
    @Parameters({"userName", "password"})
    public void registrationPageTest(String userName, String password) {
        RegistrationPage regPage = new RegistrationPage(driver);
        regPage.loadWebPage();
        regPage.enterUserDetails("Sujith", "Sukumaran");
        regPage.enterUserCred(userName, password, password);
        regPage.clickSubmit();
    }

    @Test(dependsOnMethods = "registrationPageTest")
    public void registrationConfirmPageTest() {
        RegistrationConfirmationPage regConfPage = new RegistrationConfirmationPage(driver);
        regConfPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmPageTest")
    @Parameters("passengers")
    public void findFlightsPageTest(String passengerCount) {
        FindFlightsPage findFlightsPage = new FindFlightsPage(driver);
        findFlightsPage.setPassengerCount(passengerCount);
        findFlightsPage.findFlights();
    }

    @Test(dependsOnMethods = "findFlightsPageTest")
    public void bookFlightsPageTest() {
        BookFlightsPage bookFlightsPage = new BookFlightsPage(driver);
        bookFlightsPage.clickReserveFlightsBtn();
        bookFlightsPage.clickBuyFlightsBtn();
    }

    @Test(dependsOnMethods = "bookFlightsPageTest")
    @Parameters("expectedPrice")
    public void flightConfirmationPageTest(String expectedPrice) {
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String actualPrice = flightConfirmationPage.getFlightsPrice();
        System.out.println(actualPrice);
        Assert.assertEquals(actualPrice, expectedPrice);
    }



}

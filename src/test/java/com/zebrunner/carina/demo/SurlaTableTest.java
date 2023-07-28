package com.zebrunner.carina.demo;


import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.surlatable.HomePage;
import com.zebrunner.carina.demo.surlatable.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SurlaTableTest extends AbstractTest {

    @Test
    public void testUserLogin() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        // Click on the login link to navigate to the login page
        homePage.clickLoginLink();

        LoginPage loginPage = new LoginPage(getDriver());

        // Login with valid credentials
        loginPage.login("your_username", "your_password");

        // Verify that the user is logged in successfully
        Assert.assertFalse(loginPage.isErrorMessageDisplayed(), "Error message displayed. Login failed.");
    }

    // Add more test methods for other scenarios as needed...
}
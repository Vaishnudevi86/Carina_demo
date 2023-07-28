package com.zebrunner.carina.demo;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.sauceDemo.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoTest extends AbstractTest {
    @Test
    public void testValidLoginAndLogout() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        // Login with valid credentials
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        // Verify that the home page is opened after successful login
        Assert.assertTrue(homePage.isPageOpened(), "Home page not opened after login.");

        // Logout
        homePage.logout();

        // Verify that the login page is displayed after logout
        Assert.assertTrue(loginPage.isPageOpened(), "Login page not displayed after logout.");
    }

    @Test
    public void testInvalidLoginLockedOutUser() {
        LoginPage loginPage = new LoginPage(getDriver());

        // Login with invalid credentials
        loginPage.open();
        loginPage.login("locked_out_user", "invalid_password");

        // Verify that error message is displayed for locked-out user
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for locked-out user.");
    }

    @Test
    public void testCartValidation() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(getDriver());
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(getDriver());
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(getDriver());

        // Login with valid credentials
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        // Add products to the cart
        homePage.open();
        homePage.addToCart("Sauce Labs Backpack");
        homePage.addToCart("Sauce Labs Bike Light");
        homePage.addToCart("Sauce Labs Bolt T-Shirt");

        // Go to the cart
        cartPage.open();

        // Verify items in the cart
        Assert.assertTrue(cartPage.isItemInCart("Sauce Labs Backpack"), "Sauce Labs Backpack not found in the cart.");
        Assert.assertTrue(cartPage.isItemInCart("Sauce Labs Bike Light"), "Sauce Labs Bike Light not found in the cart.");
        Assert.assertTrue(cartPage.isItemInCart("Sauce Labs Bolt T-Shirt"), "Sauce Labs Bolt T-Shirt not found in the cart.");

        // Verify the total price
        double expectedTotalPrice = 29.99 + 9.99 + 15.99; // Add the prices of other products
        double actualTotalPrice = cartPage.getTotalPrice();
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice, "Total price mismatch in the cart.");

        // Proceed to checkout
        cartPage.clickCheckout();

        // Enter checkout details (Step One)
        checkoutStepOnePage.enterCheckoutDetails("John","doe","30080");
        checkoutStepOnePage.clickContinue();

        // Verify the items and total price on the Checkout: Step Two page
        Assert.assertTrue(checkoutStepTwoPage.isItemInCheckout("Sauce Labs Backpack"), "Sauce Labs Backpack not found on Checkout: Step Two page.");
        Assert.assertTrue(checkoutStepTwoPage.isItemInCheckout("Sauce Labs Bike Light"), "Sauce Labs Bike Light not found on Checkout: Step Two page.");
        Assert.assertTrue(checkoutStepTwoPage.isItemInCheckout("Sauce Labs Bolt T-Shirt"), "Sauce Labs Bolt T-Shirt not found on Checkout: Step Two page.");

        double expectedCheckoutTotal = expectedTotalPrice + 3.99; // Adding the shipping cost
        double actualCheckoutTotal = checkoutStepTwoPage.getCheckoutTotal();
        Assert.assertEquals(actualCheckoutTotal, expectedCheckoutTotal, "Total price mismatch on Checkout: Step Two page.");

        // Finish the checkout process
        checkoutStepTwoPage.clickFinish();

        // Verify the order completion on the Checkout: Complete page
        Assert.assertTrue(checkoutCompletePage.isOrderComplete(), "Order not completed successfully.");
    }

    @Test
    public void testProductCard() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        ProductPage productPage = new ProductPage(getDriver());

        // Login with valid credentials
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        // Navigate to the product page
        homePage.open();
        homePage.clickProduct("Sauce Labs Backpack");

        // Verify product details on the product page
        Assert.assertTrue(productPage.isProductDisplayed("Sauce Labs Backpack"), "Product details not displayed correctly.");
        // Add more verifications for other product details as needed
    }

    @Test
    public void testSearchValidation() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SearchPage searchPage = new SearchPage(getDriver());

        // Login with valid credentials
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        // Perform a search for a product
        homePage.open();
        homePage.searchProduct("Bolt T-Shirt");

        // Verify search results
        Assert.assertTrue(searchPage.isProductInSearchResults("Sauce Labs Bolt T-Shirt"), "Product not found in search results.");
        // Add more verifications for other search scenarios as needed
    }

    @Test
    public void testOpeningAllAvailablePages() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        CartPage cartPage = new CartPage(getDriver());
        ProductPage productPage = new ProductPage(getDriver());
        SearchPage searchPage = new SearchPage(getDriver());

        // Login with valid credentials
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        // Open all available pages
        homePage.open();
        cartPage.open();
        productPage.open();
        searchPage.open();

        // Verify that all pages are opened correctly
        AllPages allPages = new AllPages(getDriver());
        allPages.openAllPages();

        // Verify that all pages are opened correctly
        Assert.assertTrue(allPages.isPageOpened(), "All pages not opened correctly.");
        Assert.assertTrue(homePage.isPageOpened(), "Home page not opened.");
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page not opened.");
        Assert.assertTrue(productPage.isPageOpened(), "Product page not opened.");
        Assert.assertTrue(searchPage.isPageOpened(), "Search page not opened.");
    }
 }
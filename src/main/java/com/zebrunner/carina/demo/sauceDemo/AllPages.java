package com.zebrunner.carina.demo.sauceDemo;


import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class AllPages extends AbstractPage {
    // Define locators for elements on all available pages

    // Common Header Elements
    private ExtendedWebElement homeLink; // Example: //a[@class='home-link']
    private ExtendedWebElement cartLink; // Example: //a[@class='cart-link']
    private ExtendedWebElement productLink; // Example: //a[@class='product-link']
    private ExtendedWebElement searchLink; // Example: //a[@class='search-link']

    // Common Footer Elements
    private ExtendedWebElement aboutUsLink; // Example: //a[@class='about-us-link']
    private ExtendedWebElement contactUsLink; // Example: //a[@class='contact-us-link']
    private ExtendedWebElement termsOfServiceLink; // Example: //a[@class='terms-of-service-link']
    private ExtendedWebElement privacyPolicyLink; // Example: //a[@class='privacy-policy-link']

    public AllPages(WebDriver driver) {
        super(driver);
    }

    public void openAllPages() {
        // Implementation to navigate to all available pages

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();

        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        CartPage cartPage = new CartPage(getDriver());
        cartPage.open();

        ProductPage productPage = new ProductPage(getDriver());
        productPage.open();

        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.open();
    }

    // Add methods to interact with the common elements present on all pages

    public void clickHomeLink() {
        homeLink.click();
    }

    public void clickCartLink() {
        cartLink.click();
    }

    public void clickProductLink() {
        productLink.click();
    }

    public void clickSearchLink() {
        searchLink.click();
    }

    public void clickAboutUsLink() {
        aboutUsLink.click();
    }

    public void clickContactUsLink() {
        contactUsLink.click();
    }

    public void clickTermsOfServiceLink() {
        termsOfServiceLink.click();
    }

    public void clickPrivacyPolicyLink() {
        privacyPolicyLink.click();
    }
}
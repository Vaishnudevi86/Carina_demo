package com.zebrunner.carina.demo.sauceDemo;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage {
    // Define locators for elements on the search page
    @FindBy(xpath = "//div[contains(@class, 'inventory_item_name')]")
    private ExtendedWebElement searchResultsLabel;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductInSearchResults(String productName) {
        // Implementation to verify if the given product is present in the search results
        return searchResultsLabel.isPresent() && searchResultsLabel.getText().contains(productName);
    }

    public boolean isPageOpened() {
        // Implementation to verify if the search page is opened
        return searchResultsLabel.isPresent();
    }
}
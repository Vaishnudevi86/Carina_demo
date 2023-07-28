package com.zebrunner.carina.demo.sauceDemo;


import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {
    // Define locators for elements on the product page
    @FindBy(id = "product-title")
    private ExtendedWebElement productTitleLabel;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductDisplayed(String productName) {
        // Implementation to verify if the product details are displayed correctly on the product page
        return productTitleLabel.isPresent() && productTitleLabel.getText().equals(productName);
    }

    public boolean isPageOpened() {
        // Implementation to verify if the product page is opened
        return productTitleLabel.isPresent();
    }

}
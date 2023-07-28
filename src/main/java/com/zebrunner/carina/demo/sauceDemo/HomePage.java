package com.zebrunner.carina.demo.sauceDemo;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sql.rowset.spi.SyncFactoryException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static javax.sql.rowset.spi.SyncFactory.getLogger;

public class HomePage extends AbstractPage {
    // Define locators for elements on the home page
    // Use @FindBy with XPath to locate the product labels
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> productLabels;

    @FindBy(css = ".shopping_cart_link")
    private WebElement shoppingCartLink;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    @FindBy(className = "inventory_search_container")
    private WebElement searchBox;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void open() {
        // Implementation to navigate to the home page
        getDriver().get("https://www.saucedemo.com/inventory.html");
        try {
            Thread.sleep(1000); // Add a 1-second delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchBox));
    }

    public void addToCart(String productName) {
        // Implementation to add a product to the cart
        // Find the product by name in the productLabels list and click it
        if (productLabels != null) {
            for (WebElement productLabel : productLabels) {
                if (productLabel.getText().equals(productName)) {
                    productLabel.click();
                    break;
                }
            }
        } else {
            throw new NoSuchElementException("Product labels list is null or empty.");
        }

        // Wait for the "Add to Cart" button to be clickable and click it
        waitUntilElementClickable(searchButton).click();
    }

    public void openCart() {
        // Implementation to navigate to the cart page
        shoppingCartLink.click();
    }
    public boolean isPageOpened() {
        // Implementation to verify if the home page is opened
        return isElementPresent(searchBox) && isElementPresent(searchButton);
    }
    public void logout() {
        // Implementation to perform logout
        menuButton.click();
        logoutLink.click();
    }

    public void clickProduct(String productName) {
        // Implementation to click on a product based on its name
        for (WebElement productLabel : productLabels) {
            if (productLabel.getText().equals(productName)) {
                productLabel.click();
                break;
            }
        }
    }
    public boolean isElementPresent(WebElement element) {
        try {
            return element != null && element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }

    public void searchProduct(String productToSearch) {
        // Implementation to search for a product
        searchBox.sendKeys(productToSearch);
        searchButton.click();
    }
    // Wait for the element to be clickable and return it
    public WebElement waitUntilElementClickable(WebElement element) {
        Duration timeoutDuration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(getDriver(), timeoutDuration);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
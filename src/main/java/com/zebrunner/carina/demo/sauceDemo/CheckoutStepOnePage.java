package com.zebrunner.carina.demo.sauceDemo;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepOnePage extends AbstractPage {

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(css = ".cart_checkout_link")
    private WebElement continueButton;

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public void enterCheckoutDetails(String firstName, String lastName, String postalCode) {
        // Implementation to enter checkout details
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);
    }

    public void clickContinue() {
        // Implementation to click the Continue button
        continueButton.click();
    }

 }
package com.zebrunner.carina.demo.surlatable;


import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='username']")
    private ExtendedWebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//div[@class='error-msg']")
    private ExtendedWebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        usernameField.type(username);
        passwordField.type(password);
        loginButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isElementPresent();
    }
}
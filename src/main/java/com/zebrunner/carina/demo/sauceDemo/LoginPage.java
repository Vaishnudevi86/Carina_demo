package com.zebrunner.carina.demo.sauceDemo;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "user-name")
    private ExtendedWebElement usernameField;

    @FindBy(id = "password")
    private ExtendedWebElement passwordField;

    @FindBy(id = "login-button")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private ExtendedWebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        getDriver().get("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {
        usernameField.type(username);
        passwordField.type(password);
        loginButton.click();
    }

    public boolean isPageOpened() {
        return loginButton.isPresent();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isElementPresent();
    }
}
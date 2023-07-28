package com.zebrunner.carina.demo.herokuapp;


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

    @FindBy(xpath = "//div[@class='flash success']")
    private ExtendedWebElement successMessage;

    @FindBy(xpath = "//a[@class='button secondary radius']")
    private ExtendedWebElement logoutButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        getDriver().get("https://the-internet.herokuapp.com/login");
    }

    public void login(String username, String password) {
        usernameField.type(username);
        passwordField.type(password);
        loginButton.click();
    }

    public boolean isSuccessfulLogin() {
        return successMessage.isElementPresent();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public boolean isLogoutButtonDisplayed() {
        return logoutButton.isElementPresent();
    }
}
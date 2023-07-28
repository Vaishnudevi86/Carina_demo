package com.zebrunner.carina.demo.herokuapp;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormAuthenticationPage extends AbstractPage {
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("#login > button");

    public FormAuthenticationPage(WebDriver driver, WebDriver driver1) {
        super(driver);
        this.driver = driver1;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void login(String username, String password) {
        WebElement usernameInput = driver.findElement(usernameField);
        WebElement passwordInput = driver.findElement(passwordField);
        WebElement loginBtn = driver.findElement(loginButton);

        // Input username and password
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        // Click Login button
        loginBtn.click();
    }

    public boolean isLoginSuccess() {
        By successMessage = By.cssSelector("#flash");
        return driver.findElement(successMessage).getText().contains("You logged into a secure area");
    }
}
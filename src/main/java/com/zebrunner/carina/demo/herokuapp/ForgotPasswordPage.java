package com.zebrunner.carina.demo.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {
    private WebDriver driver;
    private By emailInput = By.id("email");
    private By retrievePasswordButton = By.id("form_submit");
    private By resetConfirmationMessage = By.id("content");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/forgot_password");
    }

    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(emailInput);
        emailField.sendKeys(email);
    }

    public void clickRetrievePasswordButton() {
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(retrievePasswordButton));
        button.click();
    }

    public String getResetConfirmationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(resetConfirmationMessage));
        return messageElement.getText();
    }
}
package com.zebrunner.carina.demo.herokuapp;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends AbstractPage {

    @FindBy(xpath = "//h1[text()='Welcome to the-internet']")
    private ExtendedWebElement welcomeMessage;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        getDriver().get("https://the-internet.herokuapp.com/");
    }

    public boolean isWelcomeMessageDisplayed() {
        return welcomeMessage.isElementPresent();
    }

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }
}
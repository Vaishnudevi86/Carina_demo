package com.zebrunner.carina.demo.surlatable;


import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//a[@class='login-link']")
    private ExtendedWebElement loginLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginLink() {
        loginLink.click();
    }
}
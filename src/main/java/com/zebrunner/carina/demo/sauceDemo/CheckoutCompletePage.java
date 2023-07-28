package com.zebrunner.carina.demo.sauceDemo;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends AbstractPage {

    @FindBy(xpath = "//h2[text()='THANK YOU FOR YOUR ORDER']")
    private ExtendedWebElement orderCompleteLabel;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOrderComplete() {
        return orderCompleteLabel.isPresent();
    }
}
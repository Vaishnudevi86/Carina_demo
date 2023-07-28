package com.zebrunner.carina.demo.herokuapp;


import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EntryAdPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='modal']")
    private ExtendedWebElement entryAd;

    @FindBy(xpath = "//p[@class='modal-footer']/a")
    private ExtendedWebElement closeButton;

    public EntryAdPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        getDriver().get("https://the-internet.herokuapp.com/entry_ad");
    }

    public void closeEntryAd() {
        closeButton.click();
    }

    public boolean isEntryAdClosed() {
        return !entryAd.isElementPresent();
    }
}
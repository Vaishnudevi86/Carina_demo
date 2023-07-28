package com.zebrunner.carina.demo.sauceDemo;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutStepTwoPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='inventory_item_name' and text()='%s']")
    private ExtendedWebElement productLabel;

    @FindBy(xpath = "//a[text()='FINISH']")
    private ExtendedWebElement finishButton;

    @FindBy(css = ".inventory_item_label")
    private ExtendedWebElement checkoutItem;

    @FindBy(xpath = "//div[@class='summary_total_label']")
    private ExtendedWebElement checkoutTotal;

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public boolean isItemInCheckout(String productName) {
        return productLabel.format(productName).isPresent();
    }

    public double getCheckoutTotal() {
        Duration timeoutDuration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(getDriver(), timeoutDuration);
        WebElement totalElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(checkoutTotal.getNameWithLocator())));
        String totalText = totalElement.getText().replace("Item total: $", "");
        return Double.parseDouble(totalText);
    }

    public void clickFinish() {
        finishButton.click();
    }
}
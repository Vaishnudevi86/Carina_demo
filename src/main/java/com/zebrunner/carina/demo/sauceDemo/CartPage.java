package com.zebrunner.carina.demo.sauceDemo;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    @FindBy(className = "cart_item_label")
    private ExtendedWebElement cartItemLabel;

    @FindBy(className = "cart_total_label")
    private ExtendedWebElement cartTotalLabel;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        // Implementation to navigate to the cart page
        getDriver().get("https://www.saucedemo.com/cart.html");
    }

    public boolean isItemInCart(String productName) {
        // Implementation to verify if the given product is present in the cart
        return findExtendedWebElement(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']")).isPresent();
    }

    public double getTotalPrice() {
        // Implementation to get the total price of the items in the cart
        String totalPriceText = cartTotalLabel.getText().replace("$", "");
        return Double.parseDouble(totalPriceText);
    }

    public boolean isPageOpened() {
        // Implementation to verify if the cart page is opened
        return cartItemLabel.isPresent() && cartTotalLabel.isPresent();
    }

    public void removeItem(String productName) {
        // Implementation to remove the specified product from the cart
        WebElement removeButton = (WebElement) findExtendedWebElement(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']/ancestor::div[@class='cart_item']//button[text()='REMOVE']"));
        removeButton.click();
    }

    public void clickCheckout() {
        // Implementation to navigate to the checkout page
        ExtendedWebElement checkoutButton = findExtendedWebElement(By.className("checkout_button"));
        checkoutButton.click();
    }
}
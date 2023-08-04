package com.zebrunner.carina.demo.gui.pages.android;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculatorPage extends AbstractPage {

    private By btn_1Locator = By.id("btn_1");
    private By btn_2Locator = By.id("btn_2");
    // Add other calculator buttons as needed
    private By resultFieldLocator = By.id("result_field");
    private By btn_operatorLocator = By.id("btn_operator");
    private By btn_equalsLocator = By.id("btn_equals");
    private By btn_scientificLocator = By.id("btn_scientific");
    private By btn_memory_addLocator = By.id("btn_memory_add");
    private By btn_clearLocator = By.id("btn_clear");
    private By btn_recallLocator = By.id("btn_recall");

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public String calculate(String expression) {
        String[] parts = expression.split(" ");
        String operand1 = parts[0];
        String operator = parts[1];
        String operand2 = parts[2];

        // Type the operands and operator into the calculator
        clickElement(btn_1Locator);
        driver.findElement(resultFieldLocator).sendKeys(operand1);
        clickElement(btn_2Locator);
        driver.findElement(resultFieldLocator).sendKeys(operand2);
        clickElement(btn_operatorLocator);
        driver.findElement(resultFieldLocator).sendKeys(operator);

        // Calculate the result
        clickElement(btn_equalsLocator);

        // Get the result from the result field
        return driver.findElement(resultFieldLocator).getText();
    }

    public void switchToScientificMode() {
        // Switch to scientific calculator mode if available
        clickElement(btn_scientificLocator);
    }

    public void storeInMemory() {
        // Store the current result in memory
        clickElement(btn_memory_addLocator);
    }

    public void clearCalculation() {
        // Clear the current calculation
        clickElement(btn_clearLocator);
    }

    public String recallMemory() {
        // Recall the stored value from memory
        clickElement(btn_recallLocator);
        return driver.findElement(resultFieldLocator).getText();
    }

    private void clickElement(By locator) {
        driver.findElement(locator).click();
    }
}
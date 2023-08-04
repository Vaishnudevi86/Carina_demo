package com.zebrunner.carina.demo;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.gui.pages.android.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AndroidCalculatorTest extends AbstractTest {
    
    @Test
    public void testBasicCalculatorOperations() {
        CalculatorPage calculatorPage = initPage(getDriver(), CalculatorPage.class);

        String additionResult = calculatorPage.calculate("5 + 7");
        Assert.assertEquals(additionResult, "12", "Incorrect addition result!");

        String subtractionResult = calculatorPage.calculate("10 - 3");
        Assert.assertEquals(subtractionResult, "7", "Incorrect subtraction result!");
    }

    @Test
    public void testScientificCalculatorFunctions() {
        CalculatorPage calculatorPage = initPage(getDriver(), CalculatorPage.class);

        calculatorPage.switchToScientificMode();

        String squareRootResult = calculatorPage.calculate("√25");
        Assert.assertEquals(squareRootResult, "5", "Incorrect square root result!");

        String sinResult = calculatorPage.calculate("sin(30)");
        Assert.assertEquals(sinResult, "0.5", "Incorrect sin result!");
    }

    @Test
    public void testMemoryFunctionality() {
        CalculatorPage calculatorPage = initPage(getDriver(), CalculatorPage.class);

        String additionResult = calculatorPage.calculate("10 + 5");
        calculatorPage.storeInMemory();

        calculatorPage.clearCalculation();
        String memoryRecallResult = calculatorPage.recallMemory();
        Assert.assertEquals(memoryRecallResult, "15", "Incorrect memory recall result!");
    }
}

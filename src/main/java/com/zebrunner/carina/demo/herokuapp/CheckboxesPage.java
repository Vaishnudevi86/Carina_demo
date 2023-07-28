package com.zebrunner.carina.demo.herokuapp;


import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckboxesPage extends AbstractPage {

    @FindBy(xpath = "//input[@type='checkbox']")
    private ExtendedWebElement checkboxes;

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        getDriver().get("https://the-internet.herokuapp.com/checkboxes");
    }

    public boolean isCheckboxSelected(int index) {
        return checkboxes.getElement().isSelected();
    }

    public void selectCheckbox(int index) {
        checkboxes.getElement().click();
    }

    public void unselectCheckbox(int index) {
        checkboxes.getElement().click();
    }
}
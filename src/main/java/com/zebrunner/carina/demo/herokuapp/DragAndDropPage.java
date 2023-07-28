package com.zebrunner.carina.demo.herokuapp;


import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends AbstractPage {

    @FindBy(id = "column-a")
    private ExtendedWebElement boxA;

    @FindBy(id = "column-b")
    private ExtendedWebElement boxB;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        getDriver().get("https://the-internet.herokuapp.com/drag_and_drop");
    }

    public String getBoxPosition(String boxName) {
        if (boxName.equalsIgnoreCase("A")) {
            return boxA.getAttribute("class");
        } else if (boxName.equalsIgnoreCase("B")) {
            return boxB.getAttribute("class");
        } else {
            throw new IllegalArgumentException("Invalid box name provided!");
        }
    }

    public void dragAndDropBox(String sourceBox, String targetBox) {
        Actions actions = new Actions(getDriver());
        if (sourceBox.equalsIgnoreCase("A") && targetBox.equalsIgnoreCase("B")) {
            actions.dragAndDrop(boxA.getElement(), boxB.getElement()).build().perform();
        } else if (sourceBox.equalsIgnoreCase("B") && targetBox.equalsIgnoreCase("A")) {
            actions.dragAndDrop(boxB.getElement(), boxA.getElement()).build().perform();
        } else {
            throw new IllegalArgumentException("Invalid source and target box combination provided!");
        }
    }
}
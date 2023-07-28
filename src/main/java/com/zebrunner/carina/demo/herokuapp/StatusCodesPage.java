package com.zebrunner.carina.demo.herokuapp;

import com.github.dockerjava.api.model.Link;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class StatusCodesPage extends AbstractPage {

    // Define the status code links
    private static final String STATUS_CODE_LINK_XPATH = "//div[@class='example']//a[contains(@href, 'status_codes/%d')]";
    private static final int STATUS_CODE_OK = 200;
    private static final int STATUS_CODE_MOVED_PERMANENTLY = 301;
    private static final int STATUS_CODE_NOT_FOUND = 404;
    private static final int STATUS_CODE_INTERNAL_SERVER_ERROR = 500;

    public StatusCodesPage(WebDriver driver) {
        super(driver);
    }

    // Click on a status code link based on the provided status code value
    private void clickStatusCodeLink(int statusCode) {
        String linkXpath = String.format(STATUS_CODE_LINK_XPATH, statusCode);
        WebElement statusCodeLink = driver.findElement(By.xpath(linkXpath));
        statusCodeLink.click();
    }

    // Get the displayed status code
    public String getDisplayedStatusCode() {
        WebElement statusCodeElement = getStatusElement();
        return statusCodeElement.getText();
    }

    private WebElement getStatusElement() {
        return getDriver().findElement(By.cssSelector("div.example p"));
    }
    // Test methods for different status codes

    public void verifyOkStatus() {
        clickStatusCodeLink(STATUS_CODE_OK);
        Assert.assertEquals(getDisplayedStatusCode(), "200", "Invalid status code displayed.");
    }

    public void verifyMovedPermanentlyStatus() {
        clickStatusCodeLink(STATUS_CODE_MOVED_PERMANENTLY);
        Assert.assertEquals(getDisplayedStatusCode(), "301");
    }

    public void verifyNotFoundStatus() {
        clickStatusCodeLink(STATUS_CODE_NOT_FOUND);
        Assert.assertEquals(getDisplayedStatusCode(), "404");
    }

    public void verifyInternalServerErrorStatus() {
        clickStatusCodeLink(STATUS_CODE_INTERNAL_SERVER_ERROR);
        Assert.assertEquals(getDisplayedStatusCode(), "500");
    }
}
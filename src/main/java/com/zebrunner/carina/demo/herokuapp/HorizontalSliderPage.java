package com.zebrunner.carina.demo.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By sliderInput = By.tagName("input");
    private By sliderValue = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
    }

    public void setSliderValue(double value) {
        WebElement slider = driver.findElement(sliderInput);
        slider.sendKeys(String.valueOf(value));
    }

    public double getSliderValue() {
        String value = driver.findElement(sliderValue).getText();
        return Double.parseDouble(value);
    }
}
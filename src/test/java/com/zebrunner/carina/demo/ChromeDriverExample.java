package com.zebrunner.carina.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverExample {
    public static void main(String[] args) {
        // Specify the path to the ChromeDriver executable
        // Replace "C:/path/to/chromedriver.exe" with the actual path on your machine
        System.setProperty("webdriver.chrome.driver", "C:/Users/deviv/Selenium/chromedriver.exe");

        // Create an instance of ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Now you can use the 'driver' instance to perform various actions on the Chrome browser
        // For example:
        driver.get("https://www.saucedemo.com/"); // Open a URL in Chrome
        System.out.println(driver.getTitle()); // Get the page title
        //driver.quit(); // Close the Chrome browser and end the session
    }
}
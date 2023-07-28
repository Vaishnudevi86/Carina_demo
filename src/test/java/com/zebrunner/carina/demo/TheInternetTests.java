package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.demo.herokuapp.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TheInternetTests extends AbstractTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();

        loginPage.login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(loginPage.isSuccessfulLogin(), "Login was not successful.");
        Assert.assertTrue(loginPage.getSuccessMessage().contains("You logged into a secure area."),
                "Invalid success message displayed.");
        Assert.assertTrue(loginPage.isLogoutButtonDisplayed(), "Logout button not displayed after login.");
    }

    @Test
    public void testCheckboxSelection() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(getDriver());
        checkboxesPage.open();

        // Check if all checkboxes are initially unchecked
        Assert.assertFalse(checkboxesPage.isCheckboxSelected(1), "Checkbox 1 is selected initially.");
        Assert.assertFalse(checkboxesPage.isCheckboxSelected(2), "Checkbox 2 is selected initially.");

        // Check the first checkbox and verify it is selected
        checkboxesPage.selectCheckbox(1);
        Assert.assertTrue(checkboxesPage.isCheckboxSelected(1), "Checkbox 1 is not selected after checking.");

        // Uncheck the second checkbox and verify it is deselected
        checkboxesPage.unselectCheckbox(2);
        Assert.assertFalse(checkboxesPage.isCheckboxSelected(2), "Checkbox 2 is not deselected after unchecking.");
    }

    @Test
    public void testDragAndDrop() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(getDriver());
        dragAndDropPage.open();

        // Get the initial position of boxes A and B
        String initialPositionA = dragAndDropPage.getBoxPosition("A");
        String initialPositionB = dragAndDropPage.getBoxPosition("B");

        // Drag box A and drop it onto box B
        dragAndDropPage.dragAndDropBox("A", "B");

        // Get the new position of boxes A and B
        String newPositionA = dragAndDropPage.getBoxPosition("A");
        String newPositionB = dragAndDropPage.getBoxPosition("B");

        // Verify that the positions of boxes A and B are swapped after drag and drop
        Assert.assertEquals(newPositionA, initialPositionB, "Box A is not dragged onto Box B.");
        Assert.assertEquals(newPositionB, initialPositionA, "Box B is not dragged onto Box A.");
    }

    @Test
    public void testEntryAd() {
        EntryAdPage entryAdPage = new EntryAdPage(getDriver());
        entryAdPage.open();

        // Close the entry ad
        entryAdPage.closeEntryAd();

        // Verify that the entry ad is closed and not displayed anymore
        Assert.assertTrue(entryAdPage.isEntryAdClosed(), "Entry ad is still displayed after closing.");
    }

    @Test
    public void testWelcomeMessage() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        welcomePage.open();

        // Verify that the welcome message is displayed
        Assert.assertTrue(welcomePage.isWelcomeMessageDisplayed(), "Welcome message is not displayed.");
        Assert.assertTrue(welcomePage.getWelcomeMessage().contains("Welcome to the-internet"),
                "Invalid welcome message displayed.");
    }
    @Test
    public void testOkStatus() {
        StatusCodesPage statusCodesPage = new StatusCodesPage(getDriver());
        statusCodesPage.open();
        statusCodesPage.verifyOkStatus();
    }

    @Test
    public void testMovedPermanentlyStatus() {
        StatusCodesPage statusCodesPage = new StatusCodesPage(getDriver());
        statusCodesPage.open();
        statusCodesPage.verifyMovedPermanentlyStatus();
    }

    @Test
    public void testNotFoundStatus() {
        StatusCodesPage statusCodesPage = new StatusCodesPage(getDriver());
        statusCodesPage.open();
        statusCodesPage.verifyNotFoundStatus();
    }

    @Test
    public void testInternalServerErrorStatus() {
        StatusCodesPage statusCodesPage = new StatusCodesPage(getDriver());
        statusCodesPage.open();
        statusCodesPage.verifyInternalServerErrorStatus();
    }
    @Test
    public void testHorizontalSlider() {
        HorizontalSliderPage horizontalSliderPage = new HorizontalSliderPage(getDriver());
        horizontalSliderPage.open();

        // Set the slider value to 0
        double targetValue = 0.0;
        horizontalSliderPage.setSliderValue(targetValue);

        // Verify if the slider value is set to 0
        double actualValue = horizontalSliderPage.getSliderValue();
        Assert.assertEquals(actualValue, targetValue, "Slider value is not set correctly.");
    }

        @Test
        public void testPasswordReset() {
            ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());
            forgotPasswordPage.open();

            // Enter the email address for password reset
            String email = "vaishnu2086@gmail.com"; // Replace with the valid email address
            forgotPasswordPage.enterEmail(email);
            forgotPasswordPage.clickRetrievePasswordButton();

            // Verify the reset confirmation message
            String expectedMessage = "Your e-mail's been sent!"; // Update this with the expected confirmation message
            String actualMessage = forgotPasswordPage.getResetConfirmationMessage();
            Assert.assertEquals(actualMessage, expectedMessage, "Password reset confirmation message is incorrect.");
        }
    }



package com.ranty.automation.pages;

import com.ranty.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Feature: New customer registration
 *
 * Scenarios:
 * - TC-Register-01: Successful registration
 * - TC-Register-02: Required fields missing
 * - TC-Register-03: Invalid email validation
 * - ...
 */
public class RegisterPage extends BasePage {

    // Main form elements
    private final By registerLink        = By.className("ico-register");
    private final By registerButton      = By.id("register-button");
    private final By successMessage      = By.className("result");

    // Form fields
    private final By maleGender          = By.id("gender-male");
    private final By femaleGender        = By.id("gender-female");
    private final By firstNameField      = By.id("FirstName");
    private final By lastNameField       = By.id("LastName");
    private final By emailField          = By.id("Email");
    private final By passwordField       = By.id("Password");
    private final By confirmPasswordField= By.id("ConfirmPassword");

    // Error messages
    private final By firstNameError      = By.id("FirstName-error");
    private final By lastNameError       = By.id("LastName-error");
    private final By emailError          = By.id("Email-error");
    private final By passwordError       = By.id("Password-error");
    private final By confirmPasswordError= By.id("ConfirmPassword-error");

    public enum Gender {
        MALE,
        FEMALE
    }

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // Navigation
    public void goToRegisterPage() {
        click(registerLink);
    }

    // Input actions
    public void selectGender(Gender gender) {
        switch (gender) {
            case MALE:
                click(maleGender);
                break;
            case FEMALE:
                click(femaleGender);
                break;
        }
    }

    public void enterFirstName(String firstName) {
        type(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        type(lastNameField, lastName);
    }

    public void enterEmail(String email) {
        type(emailField, email);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void confirmPassword(String password) {
        type(confirmPasswordField, password);
    }

    public void submitForm() {
        click(registerButton);
    }

    // Combined flow
    public void completeRegistrationForm(String firstName, String lastName, String email, String password, Gender gender) {
        selectGender(gender);
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPassword(password);
        confirmPassword(password);
    }

    // Success validation
    public boolean isSuccessMessageVisible() {
        return isDisplayed(successMessage);
    }

    // Error validations
    public boolean isFirstNameErrorVisible() {
        return isDisplayed(firstNameError);
    }

    public boolean isLastNameErrorVisible() {
        return isDisplayed(lastNameError);
    }

    public boolean isEmailErrorVisible() {
        return isDisplayed(emailError);
    }

    public boolean isPasswordErrorVisible() {
        return isDisplayed(passwordError);
    }

    public boolean isConfirmPasswordErrorVisible() {
        return isDisplayed(confirmPasswordError);
    }

    // Additional error validations (TC-Register-04, 05, 06)
    private final By weakPasswordError = By.xpath("//span[contains(text(), 'must have at least')]");
    private final By passwordMismatchError = By.xpath("//span[contains(text(), 'The password and confirmation password do not match.')]");
    private final By duplicateEmailError = By.xpath("//li[contains(text(), 'The specified email already exists')]");

    public boolean isWeakPasswordErrorVisible() {
        return isDisplayed(weakPasswordError);
    }

    public boolean isPasswordMismatchErrorVisible() {
        return isDisplayed(passwordMismatchError);
    }

    public boolean isDuplicateEmailErrorVisible() {
        return isDisplayed(duplicateEmailError);
    }
    public String getSuccessMessage() {
        return getText(successMessage);
    }
}
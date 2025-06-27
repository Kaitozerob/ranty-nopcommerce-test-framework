package com.ranty.automation.pages;

import com.ranty.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Feature: Registro de nuevos clientes
 *
 * Scenario: TC-Register-01 - Registro exitoso
 *   Given el usuario navega a la página de registro
 *   When completa el formulario con datos válidos
 *   And envía el formulario
 *   Then se muestra un mensaje de registro exitoso
 */

public class RegisterPage extends BasePage {

    // Enlace Registro
    private final By registerLink = By.className("ico-register");

    // Género masculino
    private final By genderMale = By.id("gender-male");

    // Nombre
    private final By firstName = By.id("FirstName");

    // Apellido
    private final By lastName = By.id("LastName");

    // Correo
    private final By email = By.id("Email");

    // Contraseña
    private final By password = By.id("Password");

    // Confirmar contraseña
    private final By confirmPassword = By.id("ConfirmPassword");

    // Botón Registrar
    private final By registerButton = By.id("register-button");

    // Mensaje de éxito
    private final By successMessage = By.className("result");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // Navega al formulario de registro
    public void goToRegisterPage() {
        click(registerLink);
    }

    // Llena el formulario con datos válidos
    public void fillRegistrationForm(String fName, String lName, String mail, String pass) {
        click(genderMale);
        type(firstName, fName);
        type(lastName, lName);
        type(email, mail);
        type(password, pass);
        type(confirmPassword, pass);
    }

    // Envía el formulario
    public void submitForm() {
        click(registerButton);
    }

    // Verifica si se muestra mensaje de éxito
    public boolean isSuccessMessageVisible() {
        return isDisplayed(successMessage);
    }
}
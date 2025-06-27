package com.ranty.automation.tests;

import com.ranty.automation.base.BaseTest;
import com.ranty.automation.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Test: TC-Register-01 - Registro exitoso
 *
 * Given el usuario navega al formulario de registro
 * When completa el formulario con datos válidos
 * And envía el formulario
 * Then se muestra un mensaje de registro exitoso
 */

public class RegisterTests extends BaseTest {

    @Test(groups = {"Functional"})
    public void testRegistroExitoso() {
        RegisterPage registerPage = new RegisterPage(driver);

        // Given: Navega a la página de registro
        registerPage.goToRegisterPage();

        // When: Llena el formulario con datos válidos
        String randomEmail = "user" + UUID.randomUUID() + "@mail.com";
        registerPage.fillRegistrationForm("Juan", "Tester", randomEmail, "Password123!");

        // And: Envía el formulario
        registerPage.submitForm();

        // Then: Verifica mensaje de éxito
        Assert.assertTrue(registerPage.isSuccessMessageVisible(), "El mensaje de éxito no se mostró.");
    }
}
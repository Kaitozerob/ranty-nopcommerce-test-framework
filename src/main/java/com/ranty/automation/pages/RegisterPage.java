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

    // Elementos del formulario de registro
    private final By linkRegistro        = By.className("ico-register");
    private final By generoMasculino     = By.id("gender-male");
    private final By campoNombre         = By.id("FirstName");
    private final By campoApellido       = By.id("LastName");
    private final By campoCorreo         = By.id("Email");
    private final By campoPassword       = By.id("Password");
    private final By campoConfirmarPass  = By.id("ConfirmPassword");
    private final By botonRegistrar      = By.id("register-button");
    private final By mensajeExito        = By.className("result");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // Paso: Navegar al formulario de registro
    public void irAPaginaDeRegistro() {
        click(linkRegistro);
    }

    // Paso: Llenar formulario con datos válidos
    public void completarFormulario(String nombre, String apellido, String correo, String password) {
        click(generoMasculino);
        type(campoNombre, nombre);
        type(campoApellido, apellido);
        type(campoCorreo, correo);
        type(campoPassword, password);
        type(campoConfirmarPass, password);
    }

    // Paso: Enviar formulario
    public void enviarFormulario() {
        click(botonRegistrar);
    }

    // Validación: Verifica si aparece el mensaje de registro exitoso
    public boolean seMuestraMensajeDeExito() {
        return isDisplayed(mensajeExito);
    }
}
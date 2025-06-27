import com.ranty.automation.base.BaseTest;
import com.ranty.automation.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Test: TC-Register-01 - Registro exitoso
 *
 * Given el usuario navega a la página de registro
 * When completa el formulario con datos válidos
 * And envía el formulario
 * Then se muestra un mensaje de registro exitoso
 */
public class RegisterTests extends BaseTest {

    @Test(groups = {"Functional"})
    public void testRegistroExitoso() {
        RegisterPage registerPage = new RegisterPage(driver);

        // Given: Navega a la página de registro
        registerPage.irAPaginaDeRegistro();

        // When: Llena el formulario con datos válidos
        String correoUnico = "usuario" + UUID.randomUUID() + "@mail.com";
        registerPage.completarFormulario("Juan", "Tester", correoUnico, "Password123!");

        // And: Envía el formulario
        registerPage.enviarFormulario();

        // Then: Verifica mensaje de éxito
        Assert.assertTrue(registerPage.seMuestraMensajeDeExito(), "El mensaje de éxito no se mostró.");
    }
}
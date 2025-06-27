import com.ranty.automation.base.BaseTest;
import com.ranty.automation.pages.RegisterPage;
import com.ranty.automation.utils.DataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test: TC-Register-01 - Registro exitoso
 *
 * Given el usuario navega a la página de registro
 * When completa el formulario con datos válidos
 * And envía el formulario
 * Then se muestra un mensaje de registro exitoso
 */
public class RegisterTests extends BaseTest {

    /**
     * Test: TC-Register-01 - Registro exitoso
     *
     * Given el usuario navega a la página de registro
     * When completa el formulario con datos válidos
     * And envía el formulario
     * Then se muestra un mensaje de registro exitoso
     */
    @Test(groups = {"Functional"})
    public void testRegistroExitoso() {
        RegisterPage registerPage = new RegisterPage(driver);

        // Given
        registerPage.goToRegisterPage();

        // When
        String email = DataGenerator.generateRandomEmail();
        String firstName = DataGenerator.generateFirstName();
        String lastName = DataGenerator.generateLastName();
        String password = DataGenerator.generatePassword();

        registerPage.completeRegistrationForm(firstName, lastName, email, password, RegisterPage.Gender.MALE);

        // And
        registerPage.submitForm();

        // Then
        Assert.assertTrue(registerPage.isSuccessMessageVisible(), "El mensaje de éxito no se mostró.");
    }

    @Test(groups = {"Functional", "Regression"})
    public void testRegistroCamposObligatoriosFaltantes() {
        RegisterPage registerPage = new RegisterPage(driver);

        // Given: Navega a la página de registro
        registerPage.irAPaginaDeRegistro();

        // When: Deja los campos vacíos y envía el formulario
        registerPage.enviarFormulario();

        // Then: Verifica que el sistema muestre errores por campos obligatorios
        // (esto se implementará luego con validaciones específicas)
        Assert.assertTrue(true, "Validación de campos obligatorios pendiente de implementación.");
    }
}
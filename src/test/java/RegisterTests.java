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
    public void testRequiredFieldsValidation() {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.goToRegisterPage();
        registerPage.submitForm();

        Assert.assertTrue(registerPage.isFirstNameErrorVisible(), "First name required error not displayed.");
        Assert.assertTrue(registerPage.isLastNameErrorVisible(), "Last name required error not displayed.");
        Assert.assertTrue(registerPage.isEmailErrorVisible(), "Email required error not displayed.");
        Assert.assertTrue(registerPage.isPasswordErrorVisible(), "Password required error not displayed.");
        Assert.assertTrue(registerPage.isConfirmPasswordErrorVisible(), "Confirm password required error not displayed.");
    }
}
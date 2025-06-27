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

    /**
     * Test: TC-Register-03 - Correo inválido
     *
     * Given el usuario navega a la página de registro
     * When completa el formulario con un correo inválido
     * And envía el formulario
     * Then se muestra un mensaje indicando que el correo no es válido
     */
    @Test(groups = {"Regression"})
    public void testInvalidEmailValidation() {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.goToRegisterPage();

        String email = "correo-invalido";
        String firstName = DataGenerator.generateFirstName();
        String lastName = DataGenerator.generateLastName();
        String password = DataGenerator.generatePassword();

        registerPage.completeRegistrationForm(firstName, lastName, email, password, RegisterPage.Gender.MALE);
        registerPage.submitForm();

        Assert.assertTrue(registerPage.isEmailErrorVisible(), "El mensaje de error por correo inválido no se mostró.");
    }

    /**
     * Test: TC-Register-04 - Contraseña débil
     *
     * Given el usuario navega a la página de registro
     * When completa el formulario con una contraseña débil
     * And envía el formulario
     * Then se muestra un mensaje indicando que la contraseña no es segura
     */
    @Test(groups = {"Regression"})
    public void testWeakPasswordValidation() {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.goToRegisterPage();

        String email = DataGenerator.generateRandomEmail();
        String firstName = DataGenerator.generateFirstName();
        String lastName = DataGenerator.generateLastName();
        String weakPassword = "123";

        registerPage.completeRegistrationForm(firstName, lastName, email, weakPassword, RegisterPage.Gender.MALE);
        registerPage.submitForm();

        Assert.assertTrue(registerPage.isWeakPasswordErrorVisible(), "El mensaje de error por contraseña débil no se mostró.");
    }

    /**
     * Test: TC-Register-05 - Confirmación de contraseña no coincide
     *
     * Given el usuario navega a la página de registro
     * When completa el formulario con contraseñas distintas
     * And envía el formulario
     * Then se muestra un mensaje indicando que las contraseñas no coinciden
     */
    @Test(groups = {"Regression"})
    public void testPasswordConfirmationMismatch() {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.goToRegisterPage();

        String email = DataGenerator.generateRandomEmail();
        String firstName = DataGenerator.generateFirstName();
        String lastName = DataGenerator.generateLastName();

        registerPage.selectGender(RegisterPage.Gender.MALE);
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterEmail(email);
        registerPage.enterPassword("Password123!");
        registerPage.confirmPassword("Password321!");

        registerPage.submitForm();

        Assert.assertTrue(registerPage.isPasswordMismatchErrorVisible(), "El mensaje de error por contraseñas no coincidentes no se mostró.");
    }
    /**
     * Test: TC-Register-06 - Correo ya registrado
     *
     * Given el usuario navega a la página de registro
     * When completa el formulario con un correo ya registrado
     * And envía el formulario
     * Then se muestra un mensaje indicando que el correo ya existe
     */
    @Test(groups = {"Regression"})
    public void testDuplicateEmailValidation() {
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.goToRegisterPage();

        // Usa un correo que ya haya sido registrado previamente
        String duplicateEmail = "user_existing@mail.com";
        String firstName = DataGenerator.generateFirstName();
        String lastName = DataGenerator.generateLastName();
        String password = DataGenerator.generatePassword();

        registerPage.completeRegistrationForm(firstName, lastName, duplicateEmail, password, RegisterPage.Gender.MALE);
        registerPage.submitForm();

        Assert.assertTrue(registerPage.isDuplicateEmailErrorVisible(), "El mensaje de error por correo duplicado no se mostró.");
    }
}
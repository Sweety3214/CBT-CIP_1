
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BrowserTest {

    @Test(priority = 1)
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);

        // Interact with the login page
        loginPage.enterEmail("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
        System.out.println( "1 The Email and PW entered successfully");
        // Validate successful login by checking for the presence of a specific element or URL
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains("/web/index.php/dashboard/index"));


        // Validate the URL after login
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login was not successful or redirected to the wrong page.");

        System.out.println("1. Login page displayed successfully with valid Email and PW");
    }

    @Test(priority = 3)
    public void testEmptyEmailOrMobileFields() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin();
        Thread.sleep(2000);

        System.out.println("2.Test done successfully - Empty Space in username");
        WebElement errorBox = loginPage.getErrorMessage();
        WebElement errorBox1 = loginPage.getErrorMessage1();
        Assert.assertNotNull(errorBox, "Error message box is not found.");
        Assert.assertTrue(errorBox.isDisplayed(), "Error message box is not displayed.");

        String actualMessage = errorBox.getText();
        String actualMessage1 = errorBox1.getText();
        String expectedMessage = "Required";
        String expectedMessage1 = "Required";

        Assert.assertEquals(actualMessage, expectedMessage, "Error message text does not match.");
        System.out.println("2. The test was done successfullyfor empty space in user name");
    }

    @Test(priority = 2)
    public void testInvalidLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        // Enter the username and click login
        loginPage.enterEmail("invalidUser@example.com");
        Thread.sleep(2000);
        loginPage.clickLogin();
        Thread.sleep(2000);

        System.out.println("3.The test was done successfully for wrong UN");

        // Capture the error message
        WebElement errorBox = loginPage.getErrorMessage1();
        String actualErrorMessage = errorBox.getText();
        String expectedErrorMessage = "Required";

        // Assert that the actual error message matches the expected one
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message text does not match.");
        System.out.println("3.The error message was for invalid login is displayed successfully");
    }




    @Test
    public void testMailResetFlow() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.passwordreset();
        System.out.println("4.Forgot mail Test done successfully");

        // Validate that the password reset page is loaded
        Assert.assertTrue(driver.getCurrentUrl().contains("https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode"),
                "Password reset page was founded.");
        System.out.println("4.The password set page was displayed successfully");
    }
}


















































































































































































































































































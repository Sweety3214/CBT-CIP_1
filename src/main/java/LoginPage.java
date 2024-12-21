import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    // Locators using XPath

   // private By login =By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input");
    private By emailField = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input");
    private By passwordField = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input");
    private By loginButton = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
    private By errorMessage = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span");
    private By errorMessage1= By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span");
    private By passwordResetButton = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterEmail(String username) {
        driver.findElement(emailField).sendKeys(username);
    }


    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void passwordreset() {
        driver.findElement(passwordResetButton).click();
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    public WebElement getErrorMessage() {
        return driver.findElement(errorMessage);
    }
    public WebElement getErrorMessage1() {
        return driver.findElement(errorMessage1);
    }
}

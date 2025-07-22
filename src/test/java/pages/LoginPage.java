package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton   = By.cssSelector("button[type='submit']");
    private By flashMessage  = By.id("flash");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page actions
    public void enterUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getFlashMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(flashMessage));
        return driver.findElement(flashMessage).getText().trim();
    }

    // Navigate to page
    public void goToLoginPage() {
        driver.get("https://the-internet.herokuapp.com/login");
    }
}

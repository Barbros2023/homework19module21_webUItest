package stepdefs;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.*;

public class LoginSteps {

    private static WebDriver driver;
    private LoginPage loginPage;
    private String flashMessage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
        flashMessage = loginPage.getFlashMessage();
    }

    @Then("I should see a success message containing {string}")
    public void i_should_see_success_message(String expected) {
        assertTrue("Expected success message not found",
                flashMessage.contains(expected));
        driver.quit();
    }

    @Then("I should see an error message containing {string}")
    public void i_should_see_error_message(String expected) {
        assertTrue("Expected error message not found",
                flashMessage.contains(expected));
        driver.quit();
    }
}

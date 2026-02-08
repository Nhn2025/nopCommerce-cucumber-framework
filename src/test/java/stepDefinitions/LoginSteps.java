package stepDefinitions;

import commons.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;
import commons.PageGenerator;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    public LoginSteps() {
        driver = DriverFactory.getDriver();
        loginPage = PageGenerator.getLoginPage(driver);
        dashboardPage = PageGenerator.getDashboardPage(driver);
    }

    @Given("User open login page")
    public void openLoginPage() {
        loginPage.clickHeaderLogin();
    }

    @When("User login with {string} and {string}")
    public void userLogin(String email, String pass){
        loginPage.login(email, pass);
    }

    @Then("User can navigate to Dashboard page")
    public void verifyLogin(){
        assertTrue(dashboardPage.verifyNavigateToDashboard());
    }
}
package stepDefinitions;

import commons.*;
import commons.models.User;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private User user;

    @Given("User open login page")
    public void openLoginPage() {

        WebDriver driver = DriverManager.getDriver();

        loginPage = PageGenerator.getLoginPage(driver);
        dashboardPage = PageGenerator.getDashboardPage(driver);

        loginPage.openBaseUrl();
        loginPage.clickHeaderLogin();
    }

    @When("User login {string} and {string} as {string}")
    public void userLogin(String emailId, String passId, String validUser) {
        user = TestDataReader.getUser(validUser);
        loginPage.login(emailId, user.email, passId, user.password);
    }

    @Then("User can navigate to Dashboard page")
    public void verifyLogin(){
        assertTrue(dashboardPage.verifyNavigateToDashboard());
    }

}

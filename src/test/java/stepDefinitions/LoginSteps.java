package stepDefinitions;

import commons.GlobalConstants;
import io.cucumber.java.en.*;
import pages.DashboardPage;
import pages.LoginPage;
import commons.PageGenerator;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    LoginPage loginPage = PageGenerator.getLoginPage(Hooks.driver);
    DashboardPage dashboardPage = PageGenerator.getDashboardPage(Hooks.driver);

    @Given("User open login page")
    public void openLoginPage(){
        loginPage.openPageUrl(GlobalConstants.DEV_URL);
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

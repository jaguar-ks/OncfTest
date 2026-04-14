package oncf.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import oncf.pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage;

    @Given("the user is on the home page")
    public void setLoginPage() {
        loginPage = new LoginPage();
    }
    
    @And("the user closed the cookies baner")
    public void closeCookiePopUp() {
        loginPage.closeCookiesBaner();
    }

    @Given("the user click on the user login icon")
    public void clickOnUserLoginIcon() {
        loginPage.openLoginPannel();
    }

    @When("the user enters the email: {string} and password: {string}")
    public void entreUserCredentials(String email, String password) {
        loginPage.insertCredentials(email, password);
    }
    
    @And("the user click the login button")
    public void submitCredentials() {
        loginPage.clickLoginButton();
    }

    @Then("the user must see a popup displaying the message: {string}")
    public void checkMessage(String expectedMessage) {
        assertTrue(
            loginPage.checkAlertMessage(
                expectedMessage
            ),
            "TEST FAILD: the expected message:[" + expectedMessage + "] did not appear"
        );
    }
}

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

    @Given("the user click on the user login icon")
    public void clickOnUserLoginIcon() {
        loginPage.openLoginPannel();
    }

    @When("the user enters the email {email}")
    @And("the user enters the password {password}")
    @And("the user click the login button")
    public void entreUserCredentials(String email, String password) {
        loginPage.insertCredentials(email, password);
        loginPage.clickLoginButton();
    }

    @Then("the user must see the following results: {result}")
    public void checkMessage(String expectedMessage) {
        assertTrue(
            loginPage.checkAlertMessage(
                expectedMessage
            ),
            "TEST FAILD: the expected message:[" + expectedMessage + "] did not appear"
        );
    }
}

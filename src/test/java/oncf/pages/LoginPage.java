package oncf.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import oncf.utils.DriverFactory;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.oncf-voyages.ma/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="[class$='user_login_icon']>a[class$='user']")
    WebElement userLoginIcon;

    @FindBy(id="SignInFormUsername")
    WebElement emailInputField;

    @FindBy(id="passwordInput")
    WebElement passwordInputField;

    @FindBy(css="[class*='SignInForm_ctaSignIn']")
    WebElement loginButton;

    @FindBy(css="#succes , #failure")
    WebElement alertMessage;

    public void openLoginPannel() {
        wait.until(
            ExpectedConditions.elementToBeClickable(
                userLoginIcon
            )
        );
        userLoginIcon.click();
    }

    public void insertCredentials(String email, String password) {
        wait.until(
            ExpectedConditions.visibilityOfAllElements(
                List.of(
                    emailInputField,
                    passwordInputField
                )
            )
        );
        emailInputField.sendKeys(email);
        passwordInputField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean checkAlertMessage(String expectedMessage) {
        wait.until(
            ExpectedConditions.visibilityOf(
                alertMessage
            )
        );
        return alertMessage.
                getText().
                equals(expectedMessage);
    }
}

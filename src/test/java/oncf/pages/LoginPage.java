package oncf.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import oncf.utils.DriverFactory;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    DriverFactory factory;
    
    public LoginPage() {
        factory = DriverFactory.getInstance();
        driver = factory.getDriver();
        driver.get("https://www.oncf-voyages.ma/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    @FindBy(id="close-cookies")
    WebElement closeCookies;

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

    public void closeCookiesBaner() {
        Wait<WebDriver> cookieBaner = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .ignoring(NoSuchElementException.class)
            .withMessage("Timeout: Element not found");
        try {
            WebElement closeCookieButton = cookieBaner.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.id("close-cookies")
                )
            );
            if (closeCookieButton != null)
                closeCookieButton.click();
        } catch (TimeoutException e) {}
    }

    public boolean checkAlertMessage(String expectedMessage) {
        wait.until(
            ExpectedConditions.visibilityOf(
                alertMessage
            )
        );
        System.err.println("=========[Alert:essage]===========");
        System.err.println(alertMessage.getText());
        System.err.println("==================================");
        return alertMessage.
                getText().
                equals(expectedMessage);
    }
}

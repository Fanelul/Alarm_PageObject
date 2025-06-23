package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By cookiesPopupAcceptButton = By.name("ctl00$cookieBanner$acceptCookies");
    private By usernameField = By.name("ctl00$ContentPlaceHolder1$loginform$txtUserName");
    private By passwordField = By.name("txtPassword");
    private By loginButton = By.id("signInButton");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public void acceptCookies() {
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(cookiesPopupAcceptButton));
        acceptButton.click();
    }

    public void enterUsername(String username) {
        WebElement usernameInput = wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
    }
}
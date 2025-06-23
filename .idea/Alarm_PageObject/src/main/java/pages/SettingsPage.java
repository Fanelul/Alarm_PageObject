package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By menuButton = By.id("btn-menu");
    private By settingsButton = By.cssSelector("#app-nav > div > nav > ul > li:nth-child(9) > a > svg");
    private By placesButton = By.cssSelector("#app-content > div.page-view > div > div > ul > li:nth-child(4) > a");
    private By closeIssuesButton = By.cssSelector("#ember20");

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public void openMenu() {
        WebElement menuBtn = wait.until(ExpectedConditions.elementToBeClickable(menuButton));
        menuBtn.click();
    }

    public void goToSettings() {
        WebElement settingsBtn = wait.until(ExpectedConditions.elementToBeClickable(settingsButton));
        settingsBtn.click();
    }

    public void goToPlaces() {
        WebElement placesBtn = wait.until(ExpectedConditions.elementToBeClickable(placesButton));
        placesBtn.click();
    }

    public void closeIssues() {
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(closeIssuesButton));
        closeBtn.click();
    }
}
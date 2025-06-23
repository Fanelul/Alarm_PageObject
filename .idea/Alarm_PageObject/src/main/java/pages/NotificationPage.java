package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By menuButton = By.id("btn-menu");
    private By notificationButton = By.cssSelector("#app-nav > div > nav > ul > li:nth-child(4)");
    private By pushDevicesButton = By.cssSelector("#app-header-sub > ul > li:nth-child(2) > a");
    private By firstDevice = By.cssSelector("#app-content > div.page-view > div > div > section:nth-child(2) > button:nth-child(2) > div > div");
    private By deleteButton = By.cssSelector("#app-content > div.page-view > div > div > section:nth-child(2) > button");
    private By confirmDeleteButton = By.cssSelector("body > div.modal-host > div.modal-top > div > div > div > div > div.ui-modal-footer > button.simple-btn.is-async.btn-color-danger > span.btn-contents");

    public NotificationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public void openMenu() {
        WebElement menuBtn = wait.until(ExpectedConditions.elementToBeClickable(menuButton));
        menuBtn.click();
    }

    public void goToNotifications() {
        WebElement notificationBtn = wait.until(ExpectedConditions.elementToBeClickable(notificationButton));
        notificationBtn.click();
    }

    public void goToPushDevices() {
        WebElement pushDevicesBtn = wait.until(ExpectedConditions.elementToBeClickable(pushDevicesButton));
        pushDevicesBtn.click();
    }

    public void deleteFirstDevice() {
        WebElement device = wait.until(ExpectedConditions.elementToBeClickable(firstDevice));
        device.click();

        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteBtn.click();

        WebElement confirmDeleteBtn = wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteButton));
        confirmDeleteBtn.click();
    }
}
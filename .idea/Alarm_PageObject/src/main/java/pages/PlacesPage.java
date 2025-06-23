package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

public class PlacesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By firstDevice = By.id("ctl00_phBody_rptDevices_ctl00_lblDevice");
    private By deleteButton = By.cssSelector("#ctl00_phBody_lbRemoveDevice");


    public PlacesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public void switchToIframe(String iframeId) {
        driver.switchTo().frame(iframeId);
    }

    public void deleteDevice() {
        WebElement device = wait.until(ExpectedConditions.elementToBeClickable(firstDevice));
        device.click();

        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteBtn.click();

        driver.switchTo().alert().accept();
    }




    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
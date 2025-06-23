package tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.SettingsPage;
import pages.PlacesPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeletePlaceDeviceTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources2/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.alarm.com/login.aspx");
    }

    @Test
    public void testDeletePlaceDevice() {
        // Login Page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.acceptCookies();
        loginPage.enterUsername("simontest");
        loginPage.enterPassword("QEmobile12!");
        loginPage.clickLogin();

        // Settings Page
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.goToSettings();
        settingsPage.goToPlaces();
        settingsPage.closeIssues();

        // Devices Page
        PlacesPage devicesPage = new PlacesPage(driver);
        devicesPage.switchToIframe("ember20");

        for (int i = 0; i < 2; i++) {
            devicesPage.deleteDevice();
        }

        devicesPage.switchToDefaultContent();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Assert that the page URL is correct
        String currentUrl = driver.getCurrentUrl();
        assertEquals("The page URL is not as expected.", "https://www.alarm.com/web/LBS/GeoFences.aspx", currentUrl);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


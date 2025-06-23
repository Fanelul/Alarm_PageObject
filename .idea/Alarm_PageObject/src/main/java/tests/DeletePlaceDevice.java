package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SettingsPage;
import pages.PlacesPage;

public class DeletePlaceDevice {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "resources2/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.alarm.com/login.aspx");

        // Login Page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.acceptCookies();
        loginPage.enterUsername("simontest");
        loginPage.enterPassword("QEmobile12!");
        loginPage.clickLogin();

        // Settings Page
        SettingsPage settingsPage = new SettingsPage(driver);
        //settingsPage.openMenu();
        settingsPage.goToSettings();
        settingsPage.goToPlaces();
        settingsPage.closeIssues();

        // Devices Page
        PlacesPage devicesPage = new PlacesPage(driver);
        devicesPage.switchToIframe("ember20");

        for (int i = 0; i < 5; i++) {
            devicesPage.deleteDevice();
        }

        devicesPage.switchToDefaultContent();

        driver.quit();
    }
}
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.NotificationPage;

public class DeleteNotificationDevicesScript {

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

        // Notification Page
        NotificationPage notificationPage = new NotificationPage(driver);
        //notificationPage.openMenu();
        notificationPage.goToNotifications();
        notificationPage.goToPushDevices();

        for (int i = 0; i < 3; i++) {
            notificationPage.deleteFirstDevice();
        }

        driver.quit();
    }
}
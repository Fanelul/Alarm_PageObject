package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.NotificationPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeleteNotificationsDevicesTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources2/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.alarm.com/login.aspx");
    }

    @Test
    public void testDeleteNotificationDevices() {
        // Login Page
        LoginPage loginPage = new LoginPage(driver);
        loginPage.acceptCookies();
        loginPage.enterUsername("simontest");
        loginPage.enterPassword("QEmobile12!");
        loginPage.clickLogin();

        // Notification Page
        NotificationPage notificationPage = new NotificationPage(driver);
        notificationPage.goToNotifications();
        notificationPage.goToPushDevices();

        for (int i = 0; i < 3; i++) {
            notificationPage.deleteFirstDevice();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Add an assertion to verify the expected outcome
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.equals("https://www.alarm.com/web/system/notifications/manage-devices"),
                "The URL is not as expected. Current URL: " + currentUrl);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


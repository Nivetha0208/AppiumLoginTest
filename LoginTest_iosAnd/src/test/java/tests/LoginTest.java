package tests;

import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilis.DriverSetup;

import java.net.MalformedURLException;

public class LoginTest {

    private AppiumDriver driverIOS;
    private AppiumDriver driverAndroid;
    private LoginPage loginPageIOS;
    private LoginPage loginPageAndroid;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        driverIOS = DriverSetup.getDriver("iOS");
        driverAndroid = DriverSetup.getDriver("Android");
        loginPageIOS = new LoginPage(driverIOS);
        loginPageAndroid = new LoginPage(driverAndroid);
    }

    @Test
    public void testValidLoginIOS() {
        loginPageIOS.load();
        Assert.assertTrue(loginPageIOS.isLoaded(), "Login page did not load correctly");
        loginPageIOS.login("tester1@simplestream.com", "TestLogin");
        Assert.assertTrue(loginPageIOS.isLoggedIn(), "User did not log in successfully");
    }

    @Test
    public void testInvalidLoginIOS() {
        loginPageIOS.load();
        Assert.assertTrue(loginPageIOS.isLoaded(), "Login page did not load correctly");
        loginPageIOS.login("invalid_user@simplestream.com", "InvalidPassword");
        Assert.assertTrue(loginPageIOS.getErrorMessage().toLowerCase().contains("error"), "Error message not displayed for invalid login");
    }

    @Test
    public void testValidLoginAndroid() {
        loginPageAndroid.load();
        Assert.assertTrue(loginPageAndroid.isLoaded(), "Login page did not load correctly");
        loginPageAndroid.login("tester1@simplestream.com", "TestLogin");
        Assert.assertTrue(loginPageAndroid.isLoggedIn(), "User did not log in successfully");
    }

    @Test
    public void testInvalidLoginAndroid() {
        loginPageAndroid.load();
        Assert.assertTrue(loginPageAndroid.isLoaded(), "Login page did not load correctly");
        loginPageAndroid.login("invalid_user@simplestream.com", "InvalidPassword");
        Assert.assertTrue(loginPageAndroid.getErrorMessage().toLowerCase().contains("error"), "Error message not displayed for invalid login");
    }

    @AfterClass
    public void tearDown() {
        if (driverIOS != null) {
            driverIOS.quit();
        }
        if (driverAndroid != null) {
            driverAndroid.quit();
        }
    }
}

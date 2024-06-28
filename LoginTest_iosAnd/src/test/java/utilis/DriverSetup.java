package utilis;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {

	public static AppiumDriver getDriver(String platform) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        AppiumDriver driver;

        if (platform.equalsIgnoreCase("iOS")) {
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("deviceName", "iPhone 12");
            capabilities.setCapability("platformVersion", "15.0");
            capabilities.setCapability("browserName", "Safari");
            capabilities.setCapability("automationName", "XCUITest");
            driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        } else if (platform.equalsIgnoreCase("Android")) {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Pixel");
            capabilities.setCapability("platformVersion", "9.0");
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("automationName", "UiAutomator2");
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        } else {
            throw new IllegalArgumentException("Unsupported platform: " + platform);
        }

        return driver;
    }
}


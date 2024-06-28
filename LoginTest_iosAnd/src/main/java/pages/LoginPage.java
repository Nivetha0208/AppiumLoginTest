package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private AppiumDriver driver;
    private String url = "https://www.wwgoa.com/login";
    private WebDriverWait wait;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void load() {
        driver.get(url);
    }

    public boolean isLoaded() {
        try {
            return driver.findElement(MobileBy.id("username")) != null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void login(String username, String password) {
        WebElement usernameField = driver.findElement(MobileBy.id("tester1@simplestream.com a"));
        WebElement passwordField = driver.findElement(MobileBy.id("TestLogin"));
        WebElement loginButton = driver.findElement(MobileBy.xpath("//form[@class='pt-5 login has-text-left']//input[@value='Sign in']"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMessage() {
        try {
            WebElement errorElement = driver.findElement(MobileBy.xpath("//li[contains(text(),'Unknown email address. Check again or try your use')]"));
            return errorElement.getText();
        } catch (NoSuchElementException e) {
        	return "Error message not found";
        }
    }

    public boolean isLoggedIn() {
        try {
            // Replace "home-identifier" with the actual ID or other locator for an element on the homepage
            WebElement homeElement = driver.findElement(MobileBy.xpath("//div[@id='slick-slide00']//div[@class='container is-fluid is-full-height is-flex is-flex-direction-column is-justify-content-center is-align-items-center']"));
            return homeElement != null && homeElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    }
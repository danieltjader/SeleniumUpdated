package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GoogleSearchApp
{
    private final int IMPLICITLY_WAIT_30S = 30;
    private final int IMPLICITLY_WAIT_45S = 45;

    private WebDriver driver;
    private EventFiringWebDriver eventDriver;
    private EventListener listener;
    private WebDriverWait wait;

    public GoogleSearchApp(String geckoDriverPath) {
        System.setProperty("webdriver.gecko.driver", geckoDriverPath);
        driver = new FirefoxDriver();
        eventDriver = new EventFiringWebDriver(driver);
        listener = new EventListener();
        wait = new WebDriverWait(eventDriver, 5);

        eventDriver.register(listener);
        eventDriver.manage().deleteAllCookies();
        eventDriver.manage().window().maximize();
        eventDriver.manage().timeouts().pageLoadTimeout(IMPLICITLY_WAIT_45S , TimeUnit.SECONDS);
        //eventDriver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_30S, TimeUnit.SECONDS);
    }

    public WebDriver getDriver() {
        return eventDriver;
    }

    public String goToWebsite(String URL) {
        eventDriver.get(URL);
        return eventDriver.getTitle();
    }

    public void acceptCookies(String acceptCookiesID) throws NoSuchElementException{
        wait.until(ExpectedConditions.elementToBeClickable(By.id(acceptCookiesID)));
        eventDriver.findElement(By.id(acceptCookiesID)).click();
    }

    public void searchString(String searchPhrase, String searchbarName) throws NoSuchElementException {
        wait.until(ExpectedConditions.elementToBeClickable(By.name(searchbarName)));
        eventDriver.findElement(By.name(searchbarName)).sendKeys(searchPhrase);
    }

    public String pressSearch(String buttonName) throws NoSuchElementException {
        wait.until(ExpectedConditions.elementToBeClickable(By.name(buttonName)));
        eventDriver.findElement(By.name(buttonName)).click();
        return eventDriver.getTitle();
    }

    public void closeWindow() {
        eventDriver.quit();
    }
}


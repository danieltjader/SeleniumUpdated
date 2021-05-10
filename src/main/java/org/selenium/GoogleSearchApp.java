package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class GoogleSearchApp
{
    private WebDriver driver;
    private EventFiringWebDriver eventDriver;
    private EventListener listener;;

    public GoogleSearchApp(String chromeDriverPath) {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        eventDriver = new EventFiringWebDriver(driver);
        EventListener listener = new EventListener();
        eventDriver.register(listener);
        eventDriver.manage().deleteAllCookies();
        eventDriver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return eventDriver;
    }

    public String goToWebsite(String URL) {
        eventDriver.get(URL);
        return eventDriver.getTitle();
    }

    public void acceptCookies(String acceptCookiesID) throws NoSuchElementException{
        eventDriver.findElement(By.id(acceptCookiesID)).click();
    }

    public void searchString(String searchPhrase, String searchbarName) throws NoSuchElementException {
        eventDriver.findElement(By.name(searchbarName)).sendKeys(searchPhrase);
    }

    public String pressSearch(String buttonName) throws NoSuchElementException {
        eventDriver.findElement(By.name(buttonName)).click();
        return eventDriver.getTitle();
    }

    public void closeWindow() {
        eventDriver.quit();
    }
}


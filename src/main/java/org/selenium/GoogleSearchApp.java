package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchApp
{
    private WebDriver driver;

    public GoogleSearchApp(String chromeDriverPath) {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    public String goToWebsite(String URL) {
        driver.get(URL);
        return driver.getTitle();
    }

    public void acceptCookies(String acceptCookiesID) throws NoSuchElementException{
        driver.findElement(By.id(acceptCookiesID)).click();
    }

    public String searchString(String searchPhrase, String searchbarName) throws NoSuchElementException {
        driver.findElement(By.name(searchbarName)).sendKeys(searchPhrase);
        return driver.getTitle();
    }

    public void pressSearch(String buttonName) throws NoSuchElementException {
        driver.findElement(By.name(buttonName)).click();
    }
}

package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ActiTimeApp {

    private WebDriver driver;
    private EventListener listener;
    private EventFiringWebDriver eventDriver;

    public ActiTimeApp(String chromeDriverPath) {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        eventDriver = new EventFiringWebDriver(driver);
        EventListener listener = new EventListener();
        eventDriver.register(listener);
        eventDriver.manage().deleteAllCookies();
        eventDriver.manage().window().maximize();
    }

    public String goToWebsite(String URL) {
        eventDriver.get(URL);
        return eventDriver.getTitle();
    }

    public String clickTryButton(String btnText){
        eventDriver.findElement(By.linkText(btnText)).click();
        return eventDriver.getTitle();
    }

    public void addFirstName(String firstname) throws NoSuchElementException {
        eventDriver.findElement(By.cssSelector("#first-name")).sendKeys(firstname);
    }

    public void addLastName(String lastname) throws NoSuchElementException {
        eventDriver.findElement(By.cssSelector("#last-name")).sendKeys(lastname);
    }

    public void addEmail(String emailAddress) throws NoSuchElementException {
        eventDriver.findElement(By.cssSelector("#email")).sendKeys(emailAddress);
    }

    public void addCompany(String companyName) throws NoSuchElementException {
        eventDriver.findElement(By.cssSelector("#company")).sendKeys(companyName);
    }

    public void closeWindow() {
        eventDriver.quit();
    }
}

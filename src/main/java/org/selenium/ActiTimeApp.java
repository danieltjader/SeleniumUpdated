package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class ActiTimeApp {

    private final int IMPLICITLY_WAIT_30S = 30;
    private final int IMPLICITLY_WAIT_45S = 45;

    private WebDriver driver;
    private EventListener listener;
    private EventFiringWebDriver eventDriver;
    private Actions builder;
    private WebElement firstnameWE;
    private WebElement lastnameWE;
    private WebElement emailWE;
    private WebElement companyWE;

    public ActiTimeApp(String chromeDriverPath) {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        eventDriver = new EventFiringWebDriver(driver);
        EventListener listener = new EventListener();
        eventDriver.register(listener);
        eventDriver.manage().deleteAllCookies();
        eventDriver.manage().window().maximize();
        eventDriver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_30S, TimeUnit.SECONDS);
        eventDriver.manage().timeouts().pageLoadTimeout(IMPLICITLY_WAIT_45S , TimeUnit.SECONDS);
    }

    public void initializeBuilder(){
        builder = new Actions(eventDriver);
    }

    public void createFillActions() {
        firstnameWE = eventDriver.findElement(By.cssSelector("#first-name"));
        lastnameWE = eventDriver.findElement(By.cssSelector("#last-name"));
        emailWE = eventDriver.findElement(By.cssSelector("#email"));
        companyWE = eventDriver.findElement(By.cssSelector("#company"));

        builder.moveToElement(firstnameWE).build().perform();
        builder.moveToElement(lastnameWE).build().perform();
        builder.moveToElement(emailWE).build().perform();
        builder.moveToElement(companyWE).build().perform();
    }

    public void performFillActions(String firstname, String lastname, String email, String companyname){
        Action seriesOfActions;
            seriesOfActions = builder
                .sendKeys(firstnameWE, firstname)
                .sendKeys(lastnameWE, lastname)
                .sendKeys(emailWE, email)
                .sendKeys(companyWE, companyname)
                .build();
            seriesOfActions.perform();
    }

    public WebDriver getDriver() {
        return eventDriver;
    }

    public String goToWebsite(String URL) {
        eventDriver.get(URL);
        return eventDriver.getTitle();
    }

    public String clickTryButton(String btnText){
        eventDriver.findElement(By.linkText(btnText)).click();
        return eventDriver.getTitle();
    }

    public void closeWindow() {
        eventDriver.quit();
    }
}

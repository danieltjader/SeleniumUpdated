package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class AdlibrisApp {

    private final int IMPLICITLY_WAIT_30S = 30;
    private final int IMPLICITLY_WAIT_45S = 45;

    private WebDriver driver;
    private EventFiringWebDriver eventDriver;
    private EventListener listener;

    public AdlibrisApp(String chromeDriverPath) {
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

    public WebDriver getDriver() {
        return eventDriver;
    }

    public String goToWebsite(String URL) {
        eventDriver.get(URL);
        return eventDriver.getTitle();
    }

    public void searchString(String searchPhrase){
        eventDriver.findElement(By.id("q")).sendKeys(searchPhrase + Keys.ENTER);
    }

    public void addToCart(String title){
        eventDriver.findElement(By.xpath("//a[@title='" + title + "']")).click();
    }

    public void openCart(String partialClassname){
        eventDriver.findElement(By.xpath("//button[contains(@class,'" + partialClassname + "')]")).click();
    }

    public void checkOut(String buttonText){
        eventDriver.findElement(By.linkText(buttonText)).click();
    }

    public void closeWindow(){
        eventDriver.quit();
    }


}

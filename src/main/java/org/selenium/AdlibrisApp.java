package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AdlibrisApp {

    private final int IMPLICITLY_WAIT_30S = 30;
    private final int IMPLICITLY_WAIT_45S = 45;

    private WebDriver driver;
    private EventFiringWebDriver eventDriver;
    private EventListener listener;
    private WebDriverWait wait;

    public AdlibrisApp(String geckoDriverPath) {
        System.setProperty("webdriver.gecko.driver", geckoDriverPath);
        driver = new FirefoxDriver();
        eventDriver = new EventFiringWebDriver(driver);
        EventListener listener = new EventListener();
        eventDriver.register(listener);
        eventDriver.manage().deleteAllCookies();
        eventDriver.manage().window().maximize();
        wait = new WebDriverWait(eventDriver, 5);
        //eventDriver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_30S, TimeUnit.SECONDS);
        //eventDriver.manage().timeouts().pageLoadTimeout(IMPLICITLY_WAIT_45S , TimeUnit.SECONDS);
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
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//a[@title='" + title + "']"))));
        eventDriver.findElement(By.xpath("//a[@title='" + title + "']")).click();
    }

    public void openCart(String partialClassname){
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//button[contains(@class,'" + partialClassname + "')]"))));
        eventDriver.findElement(By.xpath("//button[contains(@class,'" + partialClassname + "')]")).click();
    }

    public void checkOut(String buttonText){
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(buttonText)));
        eventDriver.findElement(By.linkText(buttonText)).click();
    }

    public void closeWindow(){
        eventDriver.quit();
    }


}

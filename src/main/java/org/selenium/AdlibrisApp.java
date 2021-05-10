package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdlibrisApp {

    private WebDriver driver;

    public AdlibrisApp(String chromeDriverPath) {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String goToWebsite(String URL) {
        driver.get(URL);
        return driver.getTitle();
    }

    public void searchString(String searchPhrase){
        driver.findElement(By.id("q")).sendKeys(searchPhrase + Keys.ENTER);
    }

    public void addToCart(String title){
        driver.findElement(By.xpath("//a[@title='" + title + "']")).click();
    }

    public void openCart(String partialClassname){
        driver.findElement(By.xpath("//button[contains(@class,'" + partialClassname + "')]")).click();
    }

    public void checkOut(String buttonText){
        driver.findElement(By.linkText(buttonText)).click();

    }

    public void closeWindow(){
        driver.quit();
    }


}

package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActiTimeApp {

    private WebDriver driver;

    public ActiTimeApp(String chromeDriverPath) {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    public String goToWebsite(String URL) {
        driver.get(URL);
        return driver.getTitle();
    }

    public String clickTryButton(String btnText){
        driver.findElement(By.linkText(btnText)).click();
        return driver.getTitle();
    }

    public void addFirstName(String firstname) throws NoSuchElementException {
        driver.findElement(By.cssSelector("#first-name")).sendKeys(firstname);
    }

    public void addLastName(String lastname) throws NoSuchElementException {
        driver.findElement(By.cssSelector("#last-name")).sendKeys(lastname);
    }

    public void addEmail(String emailAddress) throws NoSuchElementException {
        driver.findElement(By.cssSelector("#email")).sendKeys(emailAddress);
    }

    public void addCompany(String companyName) throws NoSuchElementException {
        driver.findElement(By.cssSelector("#company")).sendKeys(companyName);
    }


}

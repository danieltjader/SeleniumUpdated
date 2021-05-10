package org.selenium;

import java.util.concurrent.TimeUnit;

public class MainClass {

    private final static int IMPLICIT_WAIT_10S = 10;
    private final static int WAIT_TIME_3S = 3000;

    public static void main( String[] args ) throws InterruptedException {

        runGoogleApp();
        runActiTimeApp();
        runAdlibrisApp();
    }

    private static void runAdlibrisApp() throws InterruptedException {
        AdlibrisApp adlibrisApp = new AdlibrisApp("./src/drivers/chromedriver.exe");
        adlibrisApp.getDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_10S, TimeUnit.SECONDS);

        adlibrisApp.goToWebsite("https://Adlibris.Com/se/");
        adlibrisApp.searchString("praktisk mjukvarutestning");
        adlibrisApp.addToCart("Köp häftad");
        adlibrisApp.openCart("--cart");
        adlibrisApp.checkOut("Till kassan");

        Thread.sleep(WAIT_TIME_3S);
        adlibrisApp.closeWindow();

    }

    public static void runGoogleApp() throws InterruptedException {
        GoogleSearchApp googleApp = new GoogleSearchApp("./src/drivers/chromedriver.exe");
        googleApp.getDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_10S, TimeUnit.SECONDS);

        googleApp.goToWebsite("https:/google.se");
        googleApp.acceptCookies("zV9nZe");
        googleApp.searchString("Software Testing", "q");
        googleApp.pressSearch("btnK");

        Thread.sleep(WAIT_TIME_3S);
        googleApp.closeWindow();
    }

    public static void runActiTimeApp() throws InterruptedException {
        ActiTimeApp actitimeApp = new ActiTimeApp("./src/drivers/chromedriver.exe");
        actitimeApp.getDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_10S, TimeUnit.SECONDS);

        actitimeApp.goToWebsite("https://www.actitime.com/");
        actitimeApp.clickTryButton("Try Free");
        actitimeApp.addFirstName("Winston");
        actitimeApp.addLastName("Churchill");
        actitimeApp.addEmail("winston@churchill.com");
        actitimeApp.addCompany("Ikea");

        Thread.sleep(WAIT_TIME_3S);
        actitimeApp.closeWindow();
    }
}

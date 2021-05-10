package org.selenium;

import java.util.concurrent.TimeUnit;

public class MainClass {

    private final static int IMPLICIT_WAIT_10S = 10;

    public static void main( String[] args ) throws InterruptedException {

        //runGoogleApp();
        runActiTimeApp();
        //runAdlibrisApp();
    }

    private static void runAdlibrisApp() throws InterruptedException {
        AdlibrisApp adlibrisApp = new AdlibrisApp("./src/drivers/chromedriver.exe");
        adlibrisApp.getDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_10S, TimeUnit.SECONDS);

        adlibrisApp.goToWebsite("https://Adlibris.Com/se/");
        adlibrisApp.searchString("praktisk mjukvarutestning");
        adlibrisApp.addToCart("Köp häftad");
        adlibrisApp.openCart("--cart");
        adlibrisApp.checkOut("Till kassan");

        Thread.sleep(3000);
        adlibrisApp.closeWindow();

    }

    public static void runGoogleApp() throws InterruptedException {
        GoogleSearchApp googleApp = new GoogleSearchApp("./src/drivers/chromedriver.exe");
        googleApp.getDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_10S, TimeUnit.SECONDS);

        googleApp.goToWebsite("https:/google.se");
        googleApp.acceptCookies("zV9nZe");
        googleApp.searchString("Software Testing", "q");
        googleApp.pressSearch("btnK");

        Thread.sleep(3000);
        googleApp.closeWindow();
    }

    public static void runActiTimeApp() throws InterruptedException {
        ActiTimeApp actitimeApp = new ActiTimeApp("./src/drivers/chromedriver.exe");
        actitimeApp.getDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAIT_10S, TimeUnit.SECONDS);
        actitimeApp.initializeBuilder();
        actitimeApp.goToWebsite("https://www.actitime.com/");
        actitimeApp.clickTryButton("Try Free");
        actitimeApp.createFillActions();
        actitimeApp.performFillActions("Winston", "Churchill", "winston@churchill.com", "ikea");
        Thread.sleep(3000);
        actitimeApp.closeWindow();
    }
}

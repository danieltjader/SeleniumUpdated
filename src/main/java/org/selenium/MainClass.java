package org.selenium;

public class MainClass {

    private final static int WAIT_TIME_6S = 6000;

    public static void main( String[] args ) throws InterruptedException {

        runGoogleApp();
        //runActiTimeApp();
        //runAdlibrisApp();
    }

    private static void runAdlibrisApp() throws InterruptedException {
        AdlibrisApp adlibrisApp = new AdlibrisApp("./src/drivers/geckodriver.exe");

        adlibrisApp.goToWebsite("https://Adlibris.Com/se/");
        adlibrisApp.searchString("praktisk mjukvarutestning");
        adlibrisApp.addToCart("Köp häftad");
        adlibrisApp.openCart("--cart");
        adlibrisApp.checkOut("Till kassan");

        Thread.sleep(WAIT_TIME_6S);
        adlibrisApp.closeWindow();

    }

    public static void runGoogleApp() throws InterruptedException {
        GoogleSearchApp googleApp = new GoogleSearchApp("./src/drivers/geckodriver.exe");

        googleApp.goToWebsite("https:/google.se");
        googleApp.acceptCookies("L2AGLb");
        googleApp.searchString("Software Testing", "q");
        googleApp.pressSearch("btnK");

        Thread.sleep(WAIT_TIME_6S);
        googleApp.closeWindow();
    }

    public static void runActiTimeApp() throws InterruptedException {
        ActiTimeApp actitimeApp = new ActiTimeApp("./src/drivers/geckodriver.exe");

        actitimeApp.initializeBuilder();
        actitimeApp.goToWebsite("https://www.actitime.com/");
        actitimeApp.clickTryButton("Try Free");
        actitimeApp.createFillActions();
        actitimeApp.performFillActions("Winston", "Churchill", "winston@churchill.com", "ikea");

        Thread.sleep(WAIT_TIME_6S);
        actitimeApp.closeWindow();
    }
}

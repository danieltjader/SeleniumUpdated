package org.selenium;

public class MainClass {

    private final static int SLEEP_TIME = 500;

    public static void main( String[] args ) throws InterruptedException {

        runGoogleApp();
        // runActiTimeApp();   currently not working
        runAdlibrisApp();
    }

    private static void runAdlibrisApp() throws InterruptedException {
        AdlibrisApp adlibrisApp = new AdlibrisApp("./src/drivers/chromedriver.exe");
        adlibrisApp.goToWebsite("https://Adlibris.Com/se/");
        Thread.sleep(SLEEP_TIME);
        adlibrisApp.searchString("praktisk mjukvarutestning");
        Thread.sleep(SLEEP_TIME);
        adlibrisApp.addToCart("Köp häftad");
        Thread.sleep(SLEEP_TIME);
        adlibrisApp.openCart("--cart");
        Thread.sleep(SLEEP_TIME);
        adlibrisApp.checkOut("Till kassan");
        Thread.sleep(5000);
        adlibrisApp.closeWindow();

    }

    public static void runGoogleApp() throws InterruptedException {
        GoogleSearchApp googleApp = new GoogleSearchApp("./src/drivers/chromedriver.exe");
        googleApp.goToWebsite("https:/google.se");
        Thread.sleep(SLEEP_TIME);
        googleApp.acceptCookies("zV9nZe");
        googleApp.searchString("Software Testing", "q");
        Thread.sleep(SLEEP_TIME);
        googleApp.pressSearch("btnK");
        Thread.sleep(5000);
        googleApp.closeWindow();
    }

    public static void runActiTimeApp() throws InterruptedException {
        ActiTimeApp actitimeApp = new ActiTimeApp("./src/drivers/chromedriver.exe");
        actitimeApp.goToWebsite("https://www.actitime.com/");
        Thread.sleep(SLEEP_TIME);
        actitimeApp.clickTryButton("Try Free");
        Thread.sleep(SLEEP_TIME);
        actitimeApp.addFirstName("Winston");
        actitimeApp.addLastName("Churchill");
        actitimeApp.addEmail("winston@churchill.com");
        actitimeApp.addCompany("Ikea");
        Thread.sleep(5000);
        actitimeApp.closeWindow();
    }
}

package org.selenium;

public class MainClass {

    public static void main( String[] args ) throws InterruptedException {
        runActiTimeApp();
    }

    public static void runGoogleApp() throws InterruptedException {
        GoogleSearchApp googleApp = new GoogleSearchApp("./src/drivers/chromedriver.exe");
        googleApp.goToWebsite("https:/google.se");
        Thread.sleep(1000);
        googleApp.acceptCookies("zV9nZe");
        googleApp.searchString("Software Testing", "q");
        Thread.sleep(1000);
        googleApp.pressSearch("btnK");
        googleApp.closeWindow();
    }

    public static void runActiTimeApp() throws InterruptedException {
        ActiTimeApp actitimeApp = new ActiTimeApp("./src/drivers/chromedriver.exe");
        actitimeApp.goToWebsite("https://www.actitime.com/");
        Thread.sleep(1000);
        actitimeApp.clickTryButton("Try Free");
        Thread.sleep(1000);
        actitimeApp.addFirstName("Winston");
        actitimeApp.addLastName("Churchill");
        actitimeApp.addEmail("winston@churchill.com");
        actitimeApp.addCompany("Ikea");
        Thread.sleep(2000);
        actitimeApp.closeWindow();
    }
}

package org.selenium;

public class MainClass {

    public static void main( String[] args ) throws InterruptedException {
        runGoogleApp();
        Thread.sleep(1000);
        runActiTimeApp();
    }

    public static void runGoogleApp() throws InterruptedException {
        GoogleSearchApp googleApp = new GoogleSearchApp("./src/drivers/chromedriver.exe");
        googleApp.goToWebsite("https:/google.se");
        Thread.sleep(2000);
        googleApp.acceptCookies("zV9nZe");
        googleApp.searchString("Software Testing", "q");
        Thread.sleep(2000);
        googleApp.pressSearch("btnK");
        googleApp.closeWindow();
    }

    public static void runActiTimeApp() throws InterruptedException {
        ActiTimeApp actitimeApp = new ActiTimeApp("./src/drivers/chromedriver.exe");
        actitimeApp.goToWebsite("https://www.actitime.com/");
        Thread.sleep(2000);
        actitimeApp.clickTryButton("Try Free");
        Thread.sleep(2000);
        actitimeApp.addFirstName("Todd");
        actitimeApp.addLastName("Booth");
        actitimeApp.addEmail("toddy@ltu.king.se");
        actitimeApp.addCompany("LTU");
        Thread.sleep(2000);
        actitimeApp.closeWindow();
    }
}

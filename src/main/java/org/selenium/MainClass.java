package org.selenium;

public class MainClass {

    public static void main( String[] args ) throws InterruptedException {

        GoogleSearchApp app = new GoogleSearchApp("./src/drivers/chromedriver.exe");
        app.goToWebsite("https:/google.se");
        Thread.sleep(2000);

        app.acceptCookies("zV9nZe");
        app.searchString("Software Testing", "q");

        Thread.sleep(2000);
        app.pressSearch("btnK");
    }
}

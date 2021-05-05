package org.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class GoogleSearchAppTest {

    public static GoogleSearchApp app;
    private static final int WAITING_TIME = 200;

    @BeforeEach
    public void setUp() {
        String chromeDriverPath = "./src/drivers/chromedriver.exe";
        app = new GoogleSearchApp(chromeDriverPath);
    }

    @AfterEach
    public void tearDown() {
        app.closeWindow();
    }

    @Test
    public void isURL_Correct_True() throws InterruptedException {
        String expected = "Google";
        String correctGoogleURL = "https:/google.se";

        String result = app.goToWebsite(correctGoogleURL);
        Thread.sleep(WAITING_TIME);

        assertEquals(expected, result);
    }

    @Test
    public void isSearchPhrase_Correct_True() throws InterruptedException {
        String expected = "Software Testing - Sök på Google";
        String correctGoogleURL = "https:/google.se";
        String correctCookieID = "zV9nZe";
        String correctSearchbarName = "q";
        String correctSearchButtonName = "btnK";

        app.goToWebsite(correctGoogleURL);
        Thread.sleep(WAITING_TIME);
        app.acceptCookies(correctCookieID);
        Thread.sleep(WAITING_TIME);
        app.searchString("Software Testing", correctSearchbarName);
        Thread.sleep(WAITING_TIME);
        String result = app.pressSearch(correctSearchButtonName);
        Thread.sleep(WAITING_TIME);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void isCookiesElement_NotFound_ThrowNoSuchElementException() throws InterruptedException {
        String googleURL = "https:/google.se";
        app.goToWebsite(googleURL);
        Thread.sleep(WAITING_TIME);

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            app.acceptCookies("fakeID");
        });
    }

    @Test
    public void isSearchbarElement_NotFound_ThrowNoSuchElementException() throws InterruptedException {

        String fakeSearchbarName = "fakeName";
        String correctCookieID = "zV9nZe";
        String correctGoogleURL = "https:/google.se";
        String correctSearchPhrase = "Software Testing";

        app.goToWebsite(correctGoogleURL);
        Thread.sleep(WAITING_TIME);
        app.acceptCookies(correctCookieID);
        Thread.sleep(WAITING_TIME);

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            app.searchString(correctSearchPhrase, fakeSearchbarName);
        });
    }

    @Test
    public void isSearchButtonElement_NotFound_ThrowNoSuchElementException() throws InterruptedException {

        String correctSearchBarName = "q";
        String correctCookieID = "zV9nZe";
        String correctGoogleURL = "https:/google.se";
        String correctSearchPhrase = "Not Software Testing";
        String fakeSearchButtonName = "fakeName";

        app.goToWebsite(correctGoogleURL);
        Thread.sleep(WAITING_TIME);
        app.acceptCookies(correctCookieID);
        Thread.sleep(WAITING_TIME);
        app.searchString(correctSearchPhrase, correctSearchBarName);
        Thread.sleep(WAITING_TIME);

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            app.pressSearch(fakeSearchButtonName);
        });
    }
}

package org.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class GoogleSearchAppTest {

    public static GoogleSearchApp app;
    private static final int IMPLICIT_WAITING_TIME_10S = 10;

    @BeforeEach
    public void setUp() {
        String chromeDriverPath = "./src/drivers/chromedriver.exe";
        app = new GoogleSearchApp(chromeDriverPath);
        app.getDriver().manage().timeouts().implicitlyWait(IMPLICIT_WAITING_TIME_10S, TimeUnit.SECONDS);
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
        app.acceptCookies(correctCookieID);
        app.searchString("Software Testing", correctSearchbarName);
        String result = app.pressSearch(correctSearchButtonName);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void isCookiesElement_NotFound_ThrowNoSuchElementException() throws InterruptedException {
        String googleURL = "https:/google.se";
        app.goToWebsite(googleURL);

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
        app.acceptCookies(correctCookieID);

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
        app.acceptCookies(correctCookieID);
        app.searchString(correctSearchPhrase, correctSearchBarName);

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            app.pressSearch(fakeSearchButtonName);
        });
    }
}

package org.selenium;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GoogleSearchAppTest
{
    public static GoogleSearchApp app;

    @BeforeAll
    public static void createApp(){
        String chromeDriverPath = "./src/drivers/chromedriver.exe";
        app = new GoogleSearchApp(chromeDriverPath);
    }

    @Test
    public void isURL_Correct_True() {
        String expected = "Google";
        String googleURL = "https:/google.se";
        String result = app.goToWebsite(googleURL);

        assertEquals(expected, result);
    }

}

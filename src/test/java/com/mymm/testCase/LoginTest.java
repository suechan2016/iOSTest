package com.mymm.testCase;


import com.mymm.AppiumSetup;
import org.junit.Test;

public class LoginTest extends AppiumSetup {

    @Test
    public void login() throws Exception {
        tuturialScreen.click_skip();
        splashScreen.login("suemobile1", "Bart");
        landingScreen.assert_current_page();
    }


}

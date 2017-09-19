package com.mymm.screen;


import com.mymm.MMsolo;
import io.appium.java_client.ios.IOSElement;
import org.junit.Assert;
import org.openqa.selenium.By;

public class SplashScreen {

    private MMsolo<IOSElement> solo;
    private By loginBtn = By.id("登录");
    private By signUpBtn = By.id("新用户注册");
    private By userNameTf = By.name("LoginMM-UITB_CA_ACCOUNT");
    private By passwordTf = By.id("LoginMM-UITB_CA_PASSWORD");
    private By confirmLoginBtn = By.id("LoginMM-UIBT_LOGIN");
    private By allowBtn = By.name("Allow");


    public SplashScreen(MMsolo<IOSElement> solo) {
        this.solo = solo;
    }

    public void login(String userName, String password) {
        solo.findElement(loginBtn).click();
        solo.acceptPrompt();
        solo.findElement(userNameTf).sendKeys(userName);
        solo.findElement(passwordTf).sendKeys(password);
        solo.findElement(confirmLoginBtn).click();

    }

    public void assert_current_screen() {
        Assert.assertTrue("It is not in landing screen", solo.findElement(loginBtn).isDisplayed());
    }

    public void acceptPrompt() {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 10000) {
            try {
                solo.click(allowBtn);
            } catch (Exception e) {

            }
        }

    }
}

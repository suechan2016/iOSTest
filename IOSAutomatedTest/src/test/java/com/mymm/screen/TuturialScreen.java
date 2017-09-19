package com.mymm.screen;


import com.mymm.MMsolo;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;

public class TuturialScreen {

    private MMsolo<IOSElement> solo;
    private final By skipBtn = By.name("skip button");

    public TuturialScreen(MMsolo<IOSElement> solo) {
        this.solo = solo;
    }

    public void click_skip() {
        solo.findElement(skipBtn).click();
    }


}

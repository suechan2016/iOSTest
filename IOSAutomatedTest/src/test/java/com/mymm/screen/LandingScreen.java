package com.mymm.screen;


import com.mymm.MMsolo;
import io.appium.java_client.ios.IOSElement;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LandingScreen {

    private MMsolo<IOSElement> solo;
    private By myProfileBtn = By.name("TabBar_Item_Profile");
    private By chatPageBtn = By.name("TabBar_Item_Chat");
    private By homePageBtn = By.name("TabBar_Item_Homepage");
    private By discoveryPageBtn = By.name("TabBar_Item_Browse");

    public LandingScreen(MMsolo<IOSElement> solo) {
        this.solo = solo;
    }

    public void assert_current_page() {
        solo.acceptPrompt();
        Assert.assertTrue("It is not in landing screen", solo.findElement(myProfileBtn).isDisplayed());
    }


}

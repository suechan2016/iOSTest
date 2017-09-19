package com.mymm;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.mymm.screen.LandingScreen;
import com.mymm.screen.SplashScreen;
import com.mymm.screen.TuturialScreen;


public class AppiumSetup {

    private WebDriver driver;
    protected MMsolo<IOSElement> solo;
    protected TuturialScreen tuturialScreen;
    protected SplashScreen splashScreen;
    protected LandingScreen landingScreen;
    AppiumDriverLocalService appium = AppiumDriverLocalService.buildDefaultService();

    @Before
    public void setUp() throws Exception {
        String fileName = System.getProperty("fileName");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        appium.start();

        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 6s");
        capabilities.setCapability("platformVersion", "10.2");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("app", fileName);

        driver = new IOSDriver<>(AppiumDriverLocalService.buildDefaultService().getUrl(), capabilities);

        solo = new MMsolo<IOSElement>(appium.getUrl(), capabilities);

        tuturialScreen = new TuturialScreen(solo);
        splashScreen = new SplashScreen(solo);
        landingScreen = new LandingScreen(solo);


    }
}

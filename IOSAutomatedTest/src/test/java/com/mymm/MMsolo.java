package com.mymm;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AppiumCommandExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;

import java.net.URL;

public class MMsolo<T> extends IOSDriver<WebElement> {
    int default_timeout = 5000;

    public MMsolo(URL remoteAddress, Capabilities capabilities) {
        super(remoteAddress, capabilities);
    }

    public WebElement findElement(By by, int timeout) {
        long start = System.currentTimeMillis();
        do {
            try {
                return findElement(by);
            } catch (Exception e) {
                // do nothing
            }
        } while (System.currentTimeMillis() - start < timeout);

        throw new RuntimeException(String.format("elements \"%s\" not found after %d ms", by.toString(), timeout));
    }

    public void click(By by) {
        this.findElement(by, default_timeout).click();
    }

    public void acceptPrompt() {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < default_timeout) {
            try {
                findElement(By.name("Allow")).click();
            } catch (Exception e) {

            }
        }

    }


}

package org.sri.app.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sridhar.easwaran on 12/29/2016.
 */
public class AppiumManager {

    private AndroidDriver driver;

    @BeforeSuite
    public AppiumDriver getDriver() throws MalformedURLException {

        DesiredCapabilities androidWebCaps = new DesiredCapabilities();
        androidWebCaps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");

        androidWebCaps.setCapability(MobileCapabilityType.UDID, "ZY2225CDCR");
        androidWebCaps.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), androidWebCaps);
        System.out.println("i am here");
        return driver;

    }


}

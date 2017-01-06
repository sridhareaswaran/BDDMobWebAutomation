package org.sri.app.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sri.app.os.MobileDevice;
import org.sri.app.utils.configReader;

import static org.sri.app.utils.configReader.*;
import static org.sri.app.utils.logManager.log;

import java.net.MalformedURLException;
import java.net.URL;

import org.sri.app.os.MobilePlatform;

/**
 * Created by sridhar.easwaran on 1/5/2017.
 */
public class AppiumDriverFactory {
    private static AppiumDriver driver;

    private synchronized DesiredCapabilities androidNativeCaps(MobileDevice device) {
        log.info("Generating desired capabilities for android native application.");

        String version = device.getVersion();
        String udid = device.getUdid();
        String name = device.getName();

        DesiredCapabilities androidNativeCaps = new DesiredCapabilities();
        androidNativeCaps.setCapability(MobileCapabilityType.DEVICE_NAME, name);
        androidNativeCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);

        String APP_ACTIVITY = android_data.get("APP_ACTIVITY");
        String APP_PACKAGE = android_data.get("APP_PACKAGE");
        String ANDROID_APP_PATH = android_data.get("ANDROID_APP_PATH");

        if (!APP_ACTIVITY.isEmpty())
            androidNativeCaps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);

        if (!APP_PACKAGE.isEmpty())
            androidNativeCaps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE);

        if (!ANDROID_APP_PATH.isEmpty())
            androidNativeCaps.setCapability(MobileCapabilityType.APP, ANDROID_APP_PATH);

        androidNativeCaps.setCapability(MobileCapabilityType.UDID, udid);

        log.info("[Desired Capabilities] =>" +
                "DEVICE_NAME : " + name +
                "PLATFORM_VERSION : " + version +
                "APP_ACTIVITY : " + android_data.get("APP_ACTIVITY") +
                "APP_PACKAGE : " + android_data.get("APP_PACKAGE") +
                "APP : " + android_data.get("ANDROID_APP_PATH") +
                "UDID : " + udid);

        return androidNativeCaps;
    }

    private synchronized DesiredCapabilities androidWebCaps(MobileDevice device) {
        String version = device.getVersion();
        String udid = device.getUdid();
        String name = device.getName();

        log.debug("Creating desired capabilities for " + name + " android web.");

        DesiredCapabilities androidWebCaps = new DesiredCapabilities();
        androidWebCaps.setCapability(MobileCapabilityType.DEVICE_NAME, name);
        androidWebCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);

        String BROWSER = android_data.get("BROWSER_NAME");

        if (BROWSER.isEmpty())
            BROWSER = "Browser";

        androidWebCaps.setCapability(MobileCapabilityType.BROWSER_NAME, BROWSER);

        androidWebCaps.setCapability(MobileCapabilityType.UDID, udid);
        androidWebCaps.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);

        log.info("[Desired Capabilities] =>" +
                "DEVICE_NAME : " + name +
                "PLATFORM_VERSION : " + version +
                "BROWSER : " + BROWSER +
                "UDID : " + udid);

        return androidWebCaps;
    }

    private synchronized DesiredCapabilities iOSWebCaps(MobileDevice device) {
        log.debug("Generating desired capabilities for iOS native application.");


        String version = device.getVersion();
        String udid = device.getUdid();
        String name = device.getName();

        DesiredCapabilities iOSCapabilities = new DesiredCapabilities();
        iOSCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
        iOSCapabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);

        String BROWSER = iOS_data.get("BROWSER_NAME");

        if (BROWSER.isEmpty())
            BROWSER = "safari";

        iOSCapabilities.setCapability(IOSMobileCapabilityType.BROWSER_NAME, BROWSER);

        if (udid.toCharArray().length == 40)
            iOSCapabilities.setCapability(MobileCapabilityType.UDID, udid);

        iOSCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, name);

        log.info("[Desired Capabilities] =>" +
                " DEVICE_NAME : " + name +
                " DEVICE_UDID : " + udid +
                " PLATFORM_VERSION : " + version +
                " BROWSER : " + BROWSER +
                " DEVICE_NAME : " + name);

        return iOSCapabilities;
    }


    private synchronized DesiredCapabilities iOSNativeCaps(MobileDevice device) {
        log.debug("Generating desired capabilities for iOS native application.");

        String version = device.getVersion();
        String udid = device.getUdid();
        String name = device.getName();
        String IOS_APP_PATH = iOS_data.get("IOS_APP_PATH");
        String BUNDLE_ID = iOS_data.get("BUNDLE_ID");

        DesiredCapabilities iOSCapabilities = new DesiredCapabilities();
        iOSCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
        iOSCapabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);

        if (IOS_APP_PATH.isEmpty())
            iOSCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, BUNDLE_ID);
        else
            iOSCapabilities.setCapability(MobileCapabilityType.APP, IOS_APP_PATH);

        if (udid.toCharArray().length == 40)
            iOSCapabilities.setCapability(MobileCapabilityType.UDID, udid);

        iOSCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, name);

        log.info("[Desired Capabilities] =>" +
                " DEVICE_NAME : " + name +
                " DEVICE_UDID : " + udid +
                " PLATFORM_VERSION : " + version +
                " APP : " + IOS_APP_PATH +
                " DEVICE_NAME : " + name +
                " BUNDLE ID : " + BUNDLE_ID);

        return iOSCapabilities;
    }

    public AppiumDriver createDriver(URL host, MobileDevice device, MobilePlatform mobilePlatform) throws MalformedURLException {

        switch (mobilePlatform) {

            case Web_Android:
                driver = new AndroidDriver(host, androidWebCaps(device));
                break;

            case Web_iOS:
                driver = new IOSDriver(host, iOSWebCaps(device));
                break;

            case iOS:
                System.out.println(host);
                driver = new IOSDriver(host, iOSNativeCaps(device));
                break;

            case Android:
                driver = new AndroidDriver(host, androidNativeCaps(device));
                break;

        }

        return driver;
    }
}

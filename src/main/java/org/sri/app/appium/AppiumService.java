package org.sri.app.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.ServerSocket;
import java.net.URL;

import static org.sri.app.utils.logManager.*;

/**
 * Created by sridhar.easwaran on 1/5/2017.
 */
public class AppiumService {

    public static AppiumDriverLocalService service;
    public static AppiumServiceBuilder builder;
    public static AndroidDriver driver;

    public static void start() throws Exception {

        service = getAppiumServiceBasedOnSystemOS();

        DesiredCapabilities androidWebCaps = new DesiredCapabilities();
        androidWebCaps.setCapability(MobileCapabilityType.DEVICE_NAME, "sri");
        androidWebCaps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");

        androidWebCaps.setCapability(MobileCapabilityType.UDID, "ZY2225CDCR");
        androidWebCaps.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
        service.start();
        driver = new AndroidDriver(service.getUrl(), androidWebCaps);
        System.out.println("i am here out");
    }


    public static void stop() {
        if (service.isRunning())
            service.stop();
    }

    public static String getOS() {
        String OS = System.getProperty("os.name").toLowerCase();
        log.debug("OS name : " + OS);
        return OS;
    }

    public static int getOpenPort() throws Exception {
        ServerSocket s = new ServerSocket(0);
        s.setReuseAddress(true);
        int openPort = s.getLocalPort();
        s.close();

        log.debug("passing open port: " + openPort);
        return openPort;

    }

    public static AppiumDriverLocalService getAppiumServiceBasedOnSystemOS() throws Exception {

        AppiumDriverLocalService temp;
        if (getOS().contains("window")) {
            builder = new AppiumServiceBuilder()
                    //.withAppiumJS(new File(configReader.baseConfig_data.get("Appium_JS_Path")));
                    .usingPort(getOpenPort())
                    .withLogFile(new File("target/appiumbuilder.log"));
            temp = builder.build();
            log.debug("Appium Builder constructed for windows");
            return temp;


        } else if (getOS().contains("mac")) {
            log.debug("Appium Builder constructed for MAC");

        } else {
        }
        return null;
    }

    public URL getHost() {
        return service.getUrl();
    }
}

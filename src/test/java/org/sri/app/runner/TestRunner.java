package org.sri.app.runner;

import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.magentys.donut.gherkin.Generator;
import io.magentys.donut.gherkin.model.ReportConsole;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sridhar.easwaran on 12/28/2016.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        //dryRun = true,
        glue = "org.sri.app.stepdef",
        tags = {},
        format = {
                    "html:target/cucumber-html-report",
                    "json:target/cucumber-json-report.json"
                 },
        plugin = {
                "pretty",
                "com.cucumber.listener.ExtentCucumberFormatter"
                 }
)
public class TestRunner extends AbstractTestNGCucumberTests{

    private AndroidDriver driver;

    @BeforeClass
    public AppiumDriver getDriver() throws MalformedURLException {

        // Initiates the extent report and generates the output in the output/Run_<unique timestamp>/report.html file by default.
        ExtentCucumberFormatter.initiateExtentCucumberFormatter();

        // Loads the extent config xml to customize on the report.
        ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));

        // User can add the system information as follows
        ExtentCucumberFormatter.addSystemInfo("Browser Name", "Firefox");
        ExtentCucumberFormatter.addSystemInfo("Browser version", "v31.0");
        ExtentCucumberFormatter.addSystemInfo("Selenium version", "v2.53.0");

        // Also you can add system information using a hash map
        Map systemInfo = new HashMap();
        systemInfo.put("Cucumber version", "v1.2.3");
        systemInfo.put("Extent Cucumber Reporter version", "v1.1.1");
        ExtentCucumberFormatter.addSystemInfo(systemInfo);

        DesiredCapabilities androidWebCaps = new DesiredCapabilities();
        androidWebCaps.setCapability(MobileCapabilityType.DEVICE_NAME, "sri");
        androidWebCaps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");

        androidWebCaps.setCapability(MobileCapabilityType.UDID, "ZY2225CDCR");
        androidWebCaps.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), androidWebCaps);
        System.out.println("i am here");
        return driver;

    }

}

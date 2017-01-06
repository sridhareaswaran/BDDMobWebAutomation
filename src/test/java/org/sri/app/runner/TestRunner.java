package org.sri.app.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.android.AndroidDriver;
import org.junit.runner.RunWith;
import org.sri.app.appium.AppiumService;
import org.sri.app.appium.AppiumManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static org.sri.app.appium.AppiumManager.getDriver;
import static org.sri.app.appium.AppiumManager.storeAllConnectedDevices;
import static org.sri.app.utils.configReader.initConfigReader;
import static org.sri.app.utils.logManager.initLogManager;
import static org.sri.app.utils.reportManager.initExtentCucumberReport;
import static org.sri.app.utils.logManager.log;

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
public class TestRunner extends AbstractTestNGCucumberTests {

    private AndroidDriver driver;

    @BeforeClass
    public void setup() throws Exception {

        //configure the logManager
        initLogManager();

        initConfigReader();

        initExtentCucumberReport();

        storeAllConnectedDevices();

        AppiumService.start();

        log.info("hi from logManager");
    }


    @AfterClass
    public void tearDown() {

        AppiumService.stop();
        log.info("after - class");
    }

    @BeforeMethod()
    public void setupDriver() throws Exception {
        log.info("before - method");
       // createDriverInstance();
    }


    @AfterMethod()
    public void killDriverInstance(ITestResult result) {
        //getDriver().quit();
        log.info("after - method");
    }

}

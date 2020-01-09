package steps;

import cucumber.api.Scenario;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import objects.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class Setup {
    private Driver driver;
    private AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort());

    public Setup(Driver driver) {
        this.driver = driver;
    }

    @Before
    public void setupDriver() throws MalformedURLException {
        WebDriver driver;
        String siteUrl = System.getProperty("site") != null ? System.getProperty("site").toLowerCase() : "http://localhost:8080";
        String device = System.getProperty("device") != null ? System.getProperty("device").toLowerCase() : "";
        switch (device) {
            case "firefox":
                WebDriverManager.firefoxdriver().forceCache().setup();
                driver = new FirefoxDriver();
                break;
            case "android":
                service.start();
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
                WebDriverManager.chromedriver().forceCache().version("74").setup();
                capabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,
                        WebDriverManager.chromedriver().getBinaryPath());
                driver = new AndroidDriver<>(service, capabilities);
                break;
            default:
                WebDriverManager.chromedriver().forceCache().setup();
                driver = new ChromeDriver();
        }
        driver.get(siteUrl);
        this.driver.setDriver(driver);
    }

    @After
    public void tearDownDriver() {
        this.driver.getDriver().quit();
    }

    @AfterStep
    public void captureState(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) this.driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }

    //TODO, need to set this one up in the correct location
    @Then("I see the (.*) course")
    public void iSeeTheListedCourses() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}

package objects;

import org.openqa.selenium.WebDriver;

public class Driver {
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;
}

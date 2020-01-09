package steps;

import io.cucumber.java.en.Given;
import objects.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class User {
    private Driver driver;

    public User(Driver driver) {
        this.driver = driver;
    }

    @Given("I have a user account")
    public void iHaveAUserAccount() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

}

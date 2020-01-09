package steps;

import io.cucumber.java.en.When;
import objects.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    private Driver driver;

    public Login(Driver driver) {
        this.driver = driver;
    }

    @When("I login")
    public void iLogin() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

}

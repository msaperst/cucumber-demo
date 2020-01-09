import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions(
        plugin = {"json:target/cucumber-report/cucumber-report.json", "junit:target/cucumber-report/cucumber-report.xml", "html:target/cucumber-report/", "pretty", "summary"},
        strict = true,
        monochrome = true,
        glue = {"steps"},
        features = {"src/test/features"},
        snippets = CAMELCASE
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
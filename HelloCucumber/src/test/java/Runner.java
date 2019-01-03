import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"json:target/cucumber.json", "html:target/cucumber.html"},
        features = "src/test/feature",
        glue = {"Steps"},
        snippets = SnippetType.CAMELCASE
)

public class Runner {

}

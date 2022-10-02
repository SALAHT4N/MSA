package testing;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"testing"}
)
public class MappingTests {

}

package MyRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features={"C:\\CucumberPOM\\src\\main\\resources\\Features\\homePage.feature"},
        glue = {"stepsDefinations"},
        plugin = {"pretty","html:test-outout"},
        dryRun = false,
        tags ="@Test"
)

public class TestRunner{

}



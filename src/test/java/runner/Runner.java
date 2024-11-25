package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/features", glue = { "stepDefinitions" },
		plugin = { "pretty",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" },
		tags = "@smoke",
		dryRun = false,
		publish = true)

public class Runner {

}

package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/resources/features/",
		glue = "seleniumtests",
		dryRun = false,
//		tags = ,
		monochrome = true,
		plugin = {"pretty", "html: target/cucumber.html", "json: target/cucumber.json" }
		)
public class RunnerClass {

}

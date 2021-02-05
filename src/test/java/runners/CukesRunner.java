package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
/* This class allows me to control every corner of my framework and arrange connections
with plugins i can add reports settings
I added cucumber and html report
I get Cucumber report when execute my cases from mvn-verify
I get html reports when i use cukesRunner to execute
We can reach our report under the target folder.
Also i have rerun settings and it allows me to re-run failed test cases.
dryRun=true allows me to get all step definitions that needs to be implemented
tags allows me to choose specific test cases in this case it will run just a test that i am working
*/
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                  "html:target/default-html-reports"},
        features = "src/test/resources/features/",
        glue = "step_definitions",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {
}

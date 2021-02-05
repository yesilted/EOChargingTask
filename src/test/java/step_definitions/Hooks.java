package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigurationReader;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.baseURI;
// I keep my before and after annotations here and it allows me to handle in one place for common parts
// Also , i have added some codes for taking screenshot if the scenario is failed. You can see it inside html reports

public class Hooks {

	@Before
	public void setUp(){
		baseURI= ConfigurationReader.get("api.uri");
	}


	
}

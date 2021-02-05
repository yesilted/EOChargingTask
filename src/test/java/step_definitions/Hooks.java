package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigurationReader;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.baseURI;


public class Hooks {

	@Before
	public void setUp(){
		baseURI= ConfigurationReader.get("api.uri");
	}


	
}

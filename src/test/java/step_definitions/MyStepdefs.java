package step_definitions;


import POJO.Datum;
import POJO.Reqres;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.junit.Assert;
import utilities.ConfigurationReader;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MyStepdefs {
    Response response;
    Datum datum;
    @When("I send users {string} and {string} details to Api Endpoint {string}")
    public void iSendUsersAndDetailsToApiEndpoint(String name, String job, String endpoint) {
        Map<String,Object> map =new HashMap<>();
        map.put("name",name);
        map.put("job",job);
        response = given().accept(ContentType.JSON).and().contentType(ContentType.JSON).body(map).when().post(endpoint);

    }
    @Then("status code should be {int}")
    public void statusCodeShouldBe(int statuscode) {
    Assert.assertEquals(statuscode,response.statusCode());
    }
    @And("Content type should be {string}")
    public void contentTypeShouldBe(String contenttype) {
    Assert.assertEquals(contenttype,response.contentType());
    }
    @And("JSon response should contain {string}")
    public void jsonResponseShouldContain(String arg0) {
    Assert.assertTrue(response.body().asString().contains(arg0));
    }
    @When("I get users information from Api Endpoint {string}")
    public void iGetUsersInformationFromApiEndpoint(String endpoint) {
    response=given().accept(ContentType.JSON).and().contentType(ContentType.JSON).get(endpoint);
    }
    @When("I send users <name> and <job> details to Api Endpoint {string}")
    public void iSendUsersNameAndJobDetailsToApiEndpoint(String endpoint) {

    }
    @When("I try to get users information that does not exist from Api Endpoint {string}")
    public void iTryToGetUsersInformationThatDoesNotExistFromApiEndpoint(String endpoint) {
        response=given().accept(ContentType.JSON).and().contentType(ContentType.JSON).get(endpoint+"/34");
    }
    @Then("Users {string} and {string} should match")
    public void usersAndShouldMatch(String name, String lastname) {
        Map<String,Object> map = response.body().as(Map.class);
        Map<String,Object> map1 = (Map<String, Object>) map.get("data");
        Assert.assertEquals(name,map1.get("first_name"));
        Assert.assertEquals(lastname,map1.get("last_name"));

    }
}


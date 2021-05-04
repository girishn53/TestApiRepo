package stepdefinitions;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils {

	RequestSpecification req;
	ResponseSpecification res;

	Response response;

	TestDataBuild data = new TestDataBuild();
	 static String place_id;

	@Given("add place payload using {string} {string} and {string}")
	public void add_place_payload_using_and(String name, String language, String address) throws FileNotFoundException {

		req = given().spec(requestSpecification()).body(data.addPlace(name, language, address));

	}

	@When("user calls {string} using {string} method")
	public void user_calls_using_method(String resource, String method) {

		APIResources api = APIResources.valueOf(resource);

		if (method.equalsIgnoreCase("post")) {

			response = req.when().post(api.getResource());
			
			
		}

		else if (method.equalsIgnoreCase("get"))

		{

			response = req.when().get(api.getResource());

			
		}

	}

	@Then("the API call get success with status code {int} in response")
	public void the_API_call_get_success_with_status_code_in_response(Integer code) {

		// String s =String.valueOf(code);

		Integer actualcode = Integer.valueOf(response.getStatusCode());

		assertEquals(actualcode, code);

	}

	// @Then("{string} in response body is {string}")
	// public void in_response_body_is(String keyvalue, String expectedValue) {
	//
	// assertEquals(getJsonPath(response, keyvalue), expectedValue);
	//
	// }

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {

		assertEquals(getJsonPath(response, keyValue), Expectedvalue);
	}

	@Then("verify the place_id created maps to {string} using {string}")
	public void verify_the_place_id_created_maps_to_using_s(String name, String resource) throws FileNotFoundException {

		place_id = getJsonPath(response, "place_id");

		

		req = given().spec(requestSpecification()).queryParam("place_id", place_id);

		user_calls_using_method(resource, "get");

		String actualName = getJsonPath(response, "name");

		

		assertEquals(name, actualName);

	}
	
	
	@Given("Deleteplace payload")
	public void deleteplace_payload() throws FileNotFoundException {
	   
		
		req=given().spec(requestSpecification()
				.body(data.deletePlace(place_id)));
		
		
	}

	
	
	

}

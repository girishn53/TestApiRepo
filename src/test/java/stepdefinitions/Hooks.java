package stepdefinitions;

import java.io.FileNotFoundException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@deleteplace")

	public void beforeScenario() throws FileNotFoundException {

		StepDefinition m = new StepDefinition();
		if (m.place_id == null) {
			m.add_place_payload_using_and("testhouse", "German", "2020yahoo");

			m.user_calls_using_method("AddPlaceAPI", "post");
			m.verify_the_place_id_created_maps_to_using_s("testhouse", "getPlaceAPI");
		}
	}

}

package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceholder.JsonPlaceholderAPI;
import starter.Utils.Constant;

import java.io.File;

public class GetUsersStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;

    @Given("Get single users with valid parameter ID {int}")
    public void getSingleUsersWithValidParameterID(int id) {
        jsonPlaceholderAPI.getSingleUsersValidParam(id);
    }

    @Given("Get single users with invalid parameter ID {string}")
    public void getSingleUsersWithInvalidParameterID(String id) {
        jsonPlaceholderAPI.getSingleUsersInvalidParam(id);
    }

    @When("Send get single users")
    public void sendGetSingleUsers() {
        SerenityRest.when().get(JsonPlaceholderAPI.SINGLE_USERS);
    }

    @And("Validate get users JSON Schema")
    public void validateGetSingleUsersJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR+"Users/GetSingleUsersJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}

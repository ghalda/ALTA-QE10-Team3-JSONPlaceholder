package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceholder.JsonPlaceholderAPI;
import starter.JsonPlaceholder.JsonPlaceholderResponse;
import starter.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetAlbumsStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;

    @Given("Get albums with valid parameter ID {int}")
    public void getAlbumsValidParamId(int id){
        jsonPlaceholderAPI.getAlbumsValidParamId(id);
    }

    @When("Send get albums")
    public void sendGetAlbums() {
        SerenityRest.when().get(JsonPlaceholderAPI.SINGLE_ALBUMS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body ID should be {int}")
    public void responseBodyIDShouldBe(int id) {
        SerenityRest.and().body(JsonPlaceholderResponse.ID, equalTo(id));
    }

    @And("Validate get albums JSON Schema")
    public void validateGetAlbumsJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR+"Albums/GetAlbumsJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get albums with invalid parameter ID {string}")
    public void getAlbumsWithInvalidParameterID(String id) {
        jsonPlaceholderAPI.getAlbumsInvalidParamId(id);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @Given("Get albums with exceed parameter ID {int}")
    public void getAlbumsWithExceedParameterID(int id) {
        jsonPlaceholderAPI.getAlbumsExceedParamId(id);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
}

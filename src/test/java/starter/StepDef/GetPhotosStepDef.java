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

public class GetPhotosStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;

    @Given("Get photos with valid parameter ID {int}")
    public void getPhotosValidParamId(int id){
        jsonPlaceholderAPI.getPhotosValidParamId(id);
    }

    @When("Send get photos")
    public void sendGetPhotos() {
        SerenityRest.when().get(JsonPlaceholderAPI.SINGLE_PHOTOS);
    }

    @And("Validate get photos JSON Schema")
    public void validateGetPhotosJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR+"Photos/GetPhotosJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get photos with invalid parameter ID {string}")
    public void getPhotosWithInvalidParameterID(String id) {
        jsonPlaceholderAPI.getPhotosInvalidParamId(id);
    }

    @Given("Get photos with exceed parameter ID {int}")
    public void getPhotosWithExceedParameterID(int id) {
        jsonPlaceholderAPI.getPhotosExceedParamId(id);
    }
}

package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceholder.JsonPlaceholderAPI;
import starter.JsonPlaceholder.JsonPlaceholderResponse;
import starter.Utils.Constant;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class PutAlbumsStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;

    @Given("Put update albums with valid json and parameter ID {int}")
    public void putUpdateAlbumsValidJsonAndId(int id){
        File json = new File(Constant.REQ_BODY_DIR+"Albums/PutAlbumsValidBody.json");
        jsonPlaceholderAPI.putUpdateAlbumsValidJsonAndId(id, json);
    }

    @When("Send put update albums")
    public void sendPutUpdateAlbums() {
        SerenityRest.when().put(JsonPlaceholderAPI.SINGLE_ALBUMS);
    }

    @And("Response body update id should be {int}, userId was {int} and title was {string}")
    public void responseBodyUpdateUserIdWasAndTitleWas(int id, int userId, String title) {
        SerenityRest.and().body(JsonPlaceholderResponse.ID, equalTo(id)).body(JsonPlaceholderResponse.USER_ID, equalTo(userId)).body(JsonPlaceholderResponse.TITLE, equalTo(title));
    }

    @And("Validate put update albums JSON Schema")
    public void validatePutUpdateAlbumsJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR+"Albums/PutAlbumsJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Put update albums with invalid parameter ID {string} and valid json")
    public void putUpdateAlbumsWithInvalidParameterIDAndValidJson(String id) {
        File json = new File(Constant.REQ_BODY_DIR+"Albums/PutAlbumsValidBody.json");
        jsonPlaceholderAPI.putUpdateAlbumsInvalidIdAndValidJson(id, json);
    }

    @Given("Put update albums with valid parameter ID {int} and invalid json")
    public void putUpdateAlbumsWithValidParameterIDAndInvalidJson(int id) {
        File json = new File(Constant.REQ_BODY_DIR+"Albums/PutAlbumsInvalidBody.json");
        jsonPlaceholderAPI.putUpdateAlbumsValidIdAndInvalidJson(id, json);
    }

    @Given("Put update albums with invalid parameter ID {string} and invalid json")
    public void putUpdateAlbumsWithInvalidParameterIDAndInvalidJson(String id) {
        File json = new File(Constant.REQ_BODY_DIR+"Albums/PutAlbumsInvalidBody.json");
        jsonPlaceholderAPI.putUpdateAlbumsInvalidIdAndInvalidJson(id, json);
    }

    @Given("Put update albums with exceed parameter ID {int} and valid json")
    public void putUpdateAlbumsWithExceedParameterIDAndValidJson(int id) {
        File json = new File(Constant.REQ_BODY_DIR+"Albums/PutAlbumsValidBody.json");
        jsonPlaceholderAPI.putUpdateAlbumsExceedIdAndValidJson(id, json);
    }
}

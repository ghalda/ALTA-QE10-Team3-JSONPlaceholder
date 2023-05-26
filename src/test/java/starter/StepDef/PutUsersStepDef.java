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

public class PutUsersStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;
    @Given("Put Update users with valid id {int} and valid bodyjson")
    public void putUpdateUsersWithValidIdValidReqbody(int id) {
        File json = new File(Constant.REQ_BODY_DIR+"Users/PutUpdateUsersValidReqBody.json");
        jsonPlaceholderAPI.putUpdateUsersValidIdAndValidReqbody(json,id);
    }
    @Given("Put Update users with invalid parameter id {string} & valid reqbody")
    public void putUpdateUsersWithInvalidIdValidReqbody(String id) {
        File json = new File(Constant.REQ_BODY_DIR+"Users/PutUpdateUsersInvalidReqBody.json");
        jsonPlaceholderAPI.putUpdateUsersInvalidIdAndValidReqbody(id, json);
    }

    @Given("Put Update users with valid parameter id {int} and without request body")
    public void putUpdateUsersWithValidParameterIdIdAndWithoutRequestBody(int id) {
        jsonPlaceholderAPI.putUpdateUsersValidIdAndWithoutRequestBody(id);
    }
    @Given("Put update users with exceed parameter ID {int}")
    public void putUpdateUsersWithExceedParameterID(int id) {
        File json = new File(Constant.REQ_BODY_DIR+"Users/PutUpdateUsersValidReqBody.json");
        jsonPlaceholderAPI.putUpdateUsersWithExceedParameterID(json,id);
    }

    @When("Send Put Update users")
    public void sendPutUpdateUsers() {
        SerenityRest.when().put(JsonPlaceholderAPI.SINGLE_USERS);
    }
    @And("Validate users update JSON Schema")
    public void validateUpdateUsersJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR+"Users/PutUpdateUsersJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}

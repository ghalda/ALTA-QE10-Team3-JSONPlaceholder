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

public class PutCommentsStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;
    @Given("Put update comments with valid request body and parameter id {int}")
    public void putUpdateCommentsWithValidRequestBodyAndParameterId(int id) {
        File json = new File(Constant.REQ_BODY_DIR+"Comments/ValidReqBody.json");
        jsonPlaceholderAPI.putComments(id, json);
    }

    @When("Send put update comments")
    public void sendPutUpdateComments() {
        SerenityRest.when().put(JsonPlaceholderAPI.SINGLE_COMMENTS);
    }

    @And("Response body id was {int}, post Id was {int}, name was {string}, email was {string}, and body was {string}")
    public void responseBodyIdWasPostIdWasNameWasEmailWasAndBodyWas(int id, int postId, String name, String email, String body) {
        SerenityRest.and()
                .body(JsonPlaceholderResponse.ID, equalTo(id))
                .body(JsonPlaceholderResponse.POST_ID, equalTo(postId))
                .body(JsonPlaceholderResponse.NAME, equalTo(name))
                .body(JsonPlaceholderResponse.EMAIL, equalTo(email))
                .body(JsonPlaceholderResponse.BODY, equalTo(body));
    }

    @And("Validate put comments JSON Schema")
    public void validatePutCommentsJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR+"Comments/SuccessfulCreate.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    @Given("Put update post with valid request body and invalid parameter id {string}")
    public void putUpdatePostWithValidRequestBodyAndInvalidParameterId(String id) {
        File json = new File(Constant.REQ_BODY_DIR+"Comments/ValidReqBody.json");
        jsonPlaceholderAPI.putComments(id, json);
    }

    @Given("Put update comments with valid request body and exceed parameter id {int}")
    public void putUpdateCommentsWithValidRequestBodyAndExceedParameterId(int id) {
        File json = new File(Constant.REQ_BODY_DIR+"Comments/ValidReqBody.json");
        jsonPlaceholderAPI.putComments(id, json);
    }

    @Given("Put update comments with valid parameter id {int} and without request body")
    public void putUpdateCommentsWithValidParameterIdAndWithoutRequestBody(int id) {
        File json = new File(Constant.REQ_BODY_DIR+"Comments/WithoutReqBody.json");
        jsonPlaceholderAPI.putComments(id, json);
    }

    @Given("Put update comments with invalid request body and invalid parameter id {string}")
    public void putUpdateCommentsWithInvalidRequestBodyAndInvalidParameterId(String id) {
        File json = new File(Constant.REQ_BODY_DIR+"Comments/ValidReqBody.json");
        jsonPlaceholderAPI.putComments(id, json);
    }
}

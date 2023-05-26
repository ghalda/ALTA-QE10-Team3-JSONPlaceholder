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

public class PutPostsStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;
    @Given("Put update post with valid request body and parameter id {int}")
    public void putUpdatePostWithValidRequestBodyAndParameterId(int id) {
        File json = new File(Constant.REQ_BODY_DIR+"Posts/ValidReqBody.json");
        jsonPlaceholderAPI.putPosts(id, json);
    }

    @When("Send put update posts")
    public void sendPutUpdatePosts() {
        SerenityRest.when().put(JsonPlaceholderAPI.SINGLE_POSTS);
    }

    @And("Validate put posts JSON Schema")
    public void validatePutPostsJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR+"Posts/SuccessfulCreate.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Response body id was {int}, title was {string}, body was {string} and User Id was {int}")
    public void responseBodyIdWasTitleWasBodyWasAndUserIdWas(int id, String title, String body, int userId) {
        SerenityRest.and()
                .body(JsonPlaceholderResponse.ID, equalTo(id))
                .body(JsonPlaceholderResponse.TITLE, equalTo(title))
                .body(JsonPlaceholderResponse.BODY, equalTo(body))
                .body(JsonPlaceholderResponse.USER_ID, equalTo(userId));
    }

    @Given("Put update post with valid request and invalid parameter id {string}")
    public void putUpdatePostWithValidRequestAndInvalidParameterId(String id) {
        File json = new File(Constant.REQ_BODY_DIR+"Posts/ValidReqBody.json");
        jsonPlaceholderAPI.putPosts(id, json);
    }

    @Given("Put update post with valid request and exceed parameter id {int}")
    public void putUpdatePostWithValidRequestAndExceedParameterId(int id) {
        File json = new File(Constant.REQ_BODY_DIR+"Posts/ValidReqBody.json");
        jsonPlaceholderAPI.putPosts(id, json);
    }

    @Given("Put update post with valid parameter id {int} and without request body")
    public void putUpdatePostWithValidParameterIdAndWithoutRequestBody(int id) {
        File json = new File(Constant.REQ_BODY_DIR+"Posts/WithoutReqBody.json");
        jsonPlaceholderAPI.putPosts(id, json);
    }

    @Given("Put update post with invalid request body and string parameter id {string}")
    public void putUpdatePostWithInvalidRequestBodyAndStringParameterId(String id) {
        File json = new File(Constant.REQ_BODY_DIR+"Posts/InvalidReqBody.json");
        jsonPlaceholderAPI.putPosts(id, json);
    }
}

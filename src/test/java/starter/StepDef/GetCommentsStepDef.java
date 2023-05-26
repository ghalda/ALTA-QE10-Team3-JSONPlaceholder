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

import static org.hamcrest.Matchers.notNullValue;

public class GetCommentsStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;

    @Given("Get list comments")
    public void getListComments() {
        jsonPlaceholderAPI.getListComments();
    }

    @When("Send get comments")
    public void sendGetComments() {
        SerenityRest.when().get(JsonPlaceholderAPI.SINGLE_COMMENTS);
    }

    @And("Response body field id, postId, email, name, and body should be exist")
    public void responseBodyFieldIdPostIdEmailNameAndBodyShouldBeExist() {
        SerenityRest.and()
                .body(JsonPlaceholderResponse.ID, notNullValue())
                .body(JsonPlaceholderResponse.POST_ID, notNullValue())
                .body(JsonPlaceholderResponse.EMAIL, notNullValue())
                .body(JsonPlaceholderResponse.NAME, notNullValue())
                .body(JsonPlaceholderResponse.BODY, notNullValue());
    }

    @Given("Get comments with valid parameter ID {int}")
    public void getCommentsWithValidParameterID(int id) {
        jsonPlaceholderAPI.getComments(id);
    }

    @And("Validate get comments JSON Schema")
    public void validateGetCommentsJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Comments/SuccessfulCreate.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get comments with with invalid parameter ID {string}")
    public void getCommentsWithWithInvalidParameterID(String id) {
        jsonPlaceholderAPI.getComments(id);
    }

    @Given("Get comments with exceed parameter ID {int}")
    public void getCommentsWithExceedParameterID(int id) {
        jsonPlaceholderAPI.getComments(id);
    }

    @When("Send get list comments")
    public void sendGetListComments() {
        SerenityRest.when().get(JsonPlaceholderAPI.LIST_COMMENTS);
    }
}

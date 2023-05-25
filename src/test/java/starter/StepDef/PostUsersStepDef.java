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

public class PostUsersStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;
    @Given("Post Create users with valid bodyjson")
    public void postCreateUsersWithValidRequestBody() {
        File json = new File(Constant.REQ_BODY_DIR+"Users/PostCreateUsersValidReqBody.json");
        jsonPlaceholderAPI.postCreateTodosValidReqBody(json);
    }

    @Given("Post Create users with invalid reqbody name")
    public void postCreateUsersWithInvalidReqbodyName() {
        File json = new File(Constant.REQ_BODY_DIR+"Users/PostCreateUsersInvalidReqBodyName.json");
        jsonPlaceholderAPI.postCreateUsersInvalidReqBodyName(json);
    }
    @Given("Post Create users with invalid reqbody username")
    public void postCreateUsersWithInvalidReqbodyUsername() {
        File json = new File(Constant.REQ_BODY_DIR+"Users/PostCreateUsersInvalidReqBodyUsername.json");
        jsonPlaceholderAPI.postCreateUsersInvalidReqBodyUsername(json);
    }
    @And("Response body id exist, name was {string}, username was {string} and User Id was {int}")
    public void responseBodyForUserIdAndTitleShouldBe(String name, String username, int id) {
        SerenityRest.and()
                .body(JsonPlaceholderResponse.ID,equalTo(id))
                .body(JsonPlaceholderResponse.NAME,equalTo(name))
                .body(JsonPlaceholderResponse.USER_NAME,equalTo(username));
    }

    @When("Send Post Create users")
    public void sendPostCreateUsers() {
        SerenityRest.when().post(JsonPlaceholderAPI.POST_CREATE_USERS);
    }
    @And("Validate Post Create users JSON Schema")
    public void validatePostCreateUsersJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR+"Users/PostCreateUsersJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}

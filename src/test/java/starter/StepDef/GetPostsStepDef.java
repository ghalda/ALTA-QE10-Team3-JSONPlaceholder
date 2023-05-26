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
import static org.hamcrest.Matchers.notNullValue;

public class GetPostsStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;

    @Given("Get list posts")
    public void getListPosts() {
        jsonPlaceholderAPI.getListPosts();
    }

    @When("Send get posts")
    public void sendGetPosts() {
        SerenityRest.when().get(JsonPlaceholderAPI.SINGLE_POSTS);
    }

    @When("Send get list posts")
    public void sendGetListPosts() {
        SerenityRest.when().get(JsonPlaceholderAPI.LIST_POSTS);
    }

    @And("Response body field id, userId, title, body should be exist")
    public void responseBodyFieldIdUserIdTitleBodyShouldBeExist() {
        SerenityRest.and()
                .body(JsonPlaceholderResponse.ID, notNullValue())
                .body(JsonPlaceholderResponse.USER_ID, notNullValue())
                .body(JsonPlaceholderResponse.TITLE, notNullValue())
                .body(JsonPlaceholderResponse.BODY, notNullValue());
    }

    @Given("Get single posts with valid parameter id {int}")
    public void getSinglePostsWithValidParameterId(int id) {
        jsonPlaceholderAPI.getPosts(id);
    }

    @When("Send get single posts")
    public void sendGetSinglePosts() {
        SerenityRest.when().get(JsonPlaceholderAPI.SINGLE_POSTS);
    }

    @Given("Get single posts with invalid parameter id {string}")
    public void getSinglePostsWithInvalidParameterId(String id) {
        jsonPlaceholderAPI.getPosts(id);
    }

    @Given("Get single posts with exceed parameter id {int}")
    public void getSinglePostsWithExceedParameterId(int id) {
        jsonPlaceholderAPI.getPosts(id);
    }

    @And("Response body posts ID should be {int}")
    public void responseBodyPostsIDShouldBe(int id) {
        SerenityRest.and()
                .body(JsonPlaceholderResponse.ID, equalTo(id));
    }

    @And("Validate get posts JSON Schema")
    public void validateGetPostsJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Posts/SuccessfulCreate.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}

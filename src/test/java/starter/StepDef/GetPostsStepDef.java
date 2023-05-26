package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.var;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceholder.JsonPlaceholderAPI;
import starter.JsonPlaceholder.JsonPlaceholderResponse;

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
                .and().body(JsonPlaceholderResponse.TITLE, notNullValue())
                .and().body(JsonPlaceholderResponse.BODY, notNullValue());
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
}

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

public class PostPostsStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;

    @Given("Post create posts with valid body json")
    public void postCreatePostsWithValidBodyJson() {
        File json = new File(Constant.REQ_BODY_DIR+ "Posts/ValidReqBody.json");
        jsonPlaceholderAPI.postPosts(json);
    }

    @When("Send post create posts")
    public void sendPostCreatePosts() {
        SerenityRest.when().post(JsonPlaceholderAPI.LIST_POSTS);
    }

    @And("Validate post create posts JSON Schema")
    public void validatePostCreatePostsJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Posts/SuccessfulCreate.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Response body id exist, title was {string}, body was {string} and User Id was {int}")
    public void responseBodyIdExistTitleWasBodyWasAndUserIdWas(String title, String body, int userId) {
        SerenityRest.and()
                .body(JsonPlaceholderResponse.ID, notNullValue())
                .body(JsonPlaceholderResponse.TITLE, equalTo(title))
                .body(JsonPlaceholderResponse.BODY, equalTo(body))
                .body(JsonPlaceholderResponse.USER_ID, equalTo(userId));
    }

    @Given("Post create posts with invalid request body title")
    public void postCreatePostsWithInvalidRequestBodyTitle() {
        File json = new File(Constant.REQ_BODY_DIR+ "Posts/InvalidReqBodyTitle.json");
        jsonPlaceholderAPI.postPosts(json);
    }

    @Given("Post create posts with invalid request body post body")
    public void postCreatePostsWithInvalidRequestBodyPostBody() {
        File json = new File(Constant.REQ_BODY_DIR+ "Posts/InvalidReqBodyBody.json");
        jsonPlaceholderAPI.postPosts(json);
    }

    @Given("Post create posts with invalid request body userId")
    public void postCreatePostsWithInvalidRequestBodyUserId() {
        File json = new File(Constant.REQ_BODY_DIR+ "Posts/InvalidReqBodyUserId.json");
        jsonPlaceholderAPI.postPosts(json);
    }

    @Given("Post create posts without request body title")
    public void postCreatePostsWithoutRequestBodyTitle() {
        File json = new File(Constant.REQ_BODY_DIR+ "Posts/WithoutTitle.json");
        jsonPlaceholderAPI.postPosts(json);
    }

    @Given("Post create posts without request body posts body")
    public void postCreatePostsWithoutRequestBodyPostsBody() {
        File json = new File(Constant.REQ_BODY_DIR+ "Posts/WithoutBody.json");
        jsonPlaceholderAPI.postPosts(json);
    }

    @Given("Post create posts without request body userId")
    public void postCreatePostsWithoutRequestBodyUserId() {
        File json = new File(Constant.REQ_BODY_DIR+ "Posts/WithoutUserId.json");
        jsonPlaceholderAPI.postPosts(json);
    }

    @Given("Post create posts without request body")
    public void postCreatePostsWithoutRequestBody() {
        File json = new File(Constant.REQ_BODY_DIR+ "Posts/WithoutReqBody.json");
        jsonPlaceholderAPI.postPosts(json);
    }

    @Given("Post create posts with empty request body title")
    public void postCreatePostsWithEmptyRequestBodyTitle() {
        File json = new File(Constant.REQ_BODY_DIR+ "Posts/EmptyTitle.json");
        jsonPlaceholderAPI.postPosts(json);
    }

    @Given("Post create posts with empty request body posts body")
    public void postCreatePostsWithEmptyRequestBodyPostsBody() {
        File json = new File(Constant.REQ_BODY_DIR+ "Posts/EmptyBody.json");
        jsonPlaceholderAPI.postPosts(json);
    }

    @Given("Post create posts with empty request body userId")
    public void postCreatePostsWithEmptyRequestBodyUserId() {
        File json = new File(Constant.REQ_BODY_DIR+ "Posts/EmptyUserId.json");
        jsonPlaceholderAPI.postPosts(json);
    }
}

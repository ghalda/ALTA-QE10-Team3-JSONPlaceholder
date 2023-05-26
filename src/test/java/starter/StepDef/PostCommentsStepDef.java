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

public class PostCommentsStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;

    @Given("Post create comments with valid body json")
    public void postCreateCommentsWithValidBodyJson() {
        File json = new File(Constant.REQ_BODY_DIR+ "Comments/ValidReqBody.json");
        jsonPlaceholderAPI.postComments(json);
    }

    @When("Send post create comments")
    public void sendPostCreateComments() {
        SerenityRest.when().post(JsonPlaceholderAPI.LIST_COMMENTS);
    }

    @And("Response body id exist, post Id was {int}, name was {string}, email was {string}, and body was {string}")
    public void responseBodyIdExistPostIdWasNameWasEmailWasAndBodyWas(int postId, String name, String email, String body) {
        SerenityRest.and()
                .body(JsonPlaceholderResponse.ID, notNullValue())
                .body(JsonPlaceholderResponse.POST_ID, equalTo(postId))
                .body(JsonPlaceholderResponse.NAME, equalTo(name))
                .body(JsonPlaceholderResponse.EMAIL, equalTo(email))
                .body(JsonPlaceholderResponse.BODY, equalTo(body));
    }

    @And("Validate post create comments JSON Schema")
    public void validatePostCreateCommentsJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Comments/SuccessfulCreate.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post create comments with invalid request body postId")
    public void postCreateCommentsWithInvalidRequestBodyPostId() {
        File json = new File(Constant.REQ_BODY_DIR+ "Comments/InvalidReqBodyPostId.json");
        jsonPlaceholderAPI.postPosts(json);
    }

    @Given("Post create comments with invalid request body comment body")
    public void postCreateCommentsWithInvalidRequestBodyCommentBody() {
        File json = new File(Constant.REQ_BODY_DIR+ "Comments/InvalidReqBodyBody.json");
        jsonPlaceholderAPI.postPosts(json);
    }

    @Given("Post create comments with invalid request name")
    public void postCreateCommentsWithInvalidRequestName() {
        File json = new File(Constant.REQ_BODY_DIR+ "Comments/InvalidReqBodyName.json");
        jsonPlaceholderAPI.postPosts(json);
    }

    @Given("Post create comments with invalid type data request body email")
    public void postCreateCommentsWithInvalidTypeDataRequestBodyEmail() {
        File json = new File(Constant.REQ_BODY_DIR+ "Comments/InvalidTypeDataEmail.json");
        jsonPlaceholderAPI.postPosts(json);
    }

    @Given("Post create comments with invalid format request body email")
    public void postCreateCommentsWithInvalidFormatRequestBodyEmail() {
        File json = new File(Constant.REQ_BODY_DIR+ "Comments/InvalidFormatEmail.json");
        jsonPlaceholderAPI.postPosts(json);
    }

    @Given("Post create comments without request body postId")
    public void postCreateCommentsWithoutRequestBodyPostId() {
        File json = new File(Constant.REQ_BODY_DIR+ "Comments/WithoutPostId.json");
        jsonPlaceholderAPI.postPosts(json);
    }

    @Given("Post create comments without request body name")
    public void postCreateCommentsWithoutRequestBodyName() {
        File json = new File(Constant.REQ_BODY_DIR+ "Comments/WithoutName.json");
        jsonPlaceholderAPI.postPosts(json);
    }

    @Given("Post create comments without request body email")
    public void postCreateCommentsWithoutRequestBodyEmail() {
        File json = new File(Constant.REQ_BODY_DIR+ "Comments/WithoutEmail.json");
        jsonPlaceholderAPI.postPosts(json);
    }

    @Given("Post create comments without request body comments body")
    public void postCreateCommentsWithoutRequestBodyCommentsBody() {
        File json = new File(Constant.REQ_BODY_DIR+ "Comments/WithoutBody.json");
        jsonPlaceholderAPI.postPosts(json);
    }

    @Given("Post create comments without request body")
    public void postCreateCommentsWithoutRequestBody() {
        File json = new File(Constant.REQ_BODY_DIR+ "Comments/WithoutReqBody.json");
        jsonPlaceholderAPI.postPosts(json);
    }
}

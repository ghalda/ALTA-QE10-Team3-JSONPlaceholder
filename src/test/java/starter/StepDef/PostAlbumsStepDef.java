package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceholder.JsonPlaceholderAPI;
import starter.JsonPlaceholder.JsonPlaceholderResponse;
import starter.Utils.Constant;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class PostAlbumsStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;

    @Given("Post create albums with valid body json")
    public void postAlbumsWithValidJson(){
        File json = new File(Constant.REQ_BODY_DIR+"Albums/PostAlbumsValidBody.json");
        jsonPlaceholderAPI.postAlbumsValidBodyJson(json);
    }

    @When("Send post create albums")
    public void sendPostCreateAlbums() {
        SerenityRest.when().post(JsonPlaceholderAPI.POST_CREATE_ALBUMS);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body for userId should be {int} and title should be {string}")
    public void responseBodyForUserIdShouldBeAndTitleShouldBe(int userId, String title) {
        SerenityRest.and().body(JsonPlaceholderResponse.USER_ID, equalTo(userId)).body(JsonPlaceholderResponse.TITLE, equalTo(title));
    }

    @And("Validate post create albums JSON Schema")
    public void validatePostCreateAlbumsJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR+"Albums/PostAlbumsJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post create albums with invalid request body userId")
    public void postCreateAlbumsWithInvalidRequestBodyUserId() {
        File json = new File(Constant.REQ_BODY_DIR+"Albums/PostAlbumsInvalidBodyUserId.json");
        jsonPlaceholderAPI.postAlbumsInvalidBodyUserId(json);
    }

    @Given("Post create albums with invalid request body title")
    public void postCreateAlbumsWithInvalidRequestBodyTitle() {
        File json = new File(Constant.REQ_BODY_DIR+"Albums/PostAlbumsInvalidBodyTitle.json");
        jsonPlaceholderAPI.postAlbumsInvalidBodyTitle(json);
    }

    @Given("Post create albums only using valid body title without body userId")
    public void postCreateAlbumsOnlyUsingValidBodyTitleWithoutBodyUserId() {
        File json = new File(Constant.REQ_BODY_DIR+"Albums/PostAlbumsWithoutBodyUserId.json");
        jsonPlaceholderAPI.postAlbumsWithoutBodyUserId(json);
    }
}

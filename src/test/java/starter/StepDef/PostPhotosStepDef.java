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

public class PostPhotosStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;

    @Given("Post create photos with valid body json")
    public void postPhotosWithValidJson(){
        File json = new File(Constant.REQ_BODY_DIR+"Photos/PostPhotosValidBody.json");
        jsonPlaceholderAPI.postPhotosValidBodyJson(json);
    }

    @When("Send post create photos")
    public void sendPostCreatePhotos() {
        SerenityRest.when().post(JsonPlaceholderAPI.POST_CREATE_PHOTOS);
    }

    @And("Response body for albumId should be {int}, title should be {string}, url should be {string} and thumbnailUrl should be {string}")
    public void responseBodyForAlbumIdTitleUrlThumbnailUrl(int albumId, String title, String url, String thumbnailUrl) {
        SerenityRest.and().body(JsonPlaceholderResponse.ALBUM_ID, equalTo(albumId)).body(JsonPlaceholderResponse.TITLE, equalTo(title)).body(JsonPlaceholderResponse.URL, equalTo(url)).body(JsonPlaceholderResponse.THUMBNAIL_URL, equalTo(thumbnailUrl));
    }

    @And("Validate post create photos JSON Schema")
    public void validatePostCreatePhotosJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR+"Photos/PostPhotosJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post create photos with invalid body json")
    public void postCreatePhotosWithInvalidBodyJson() {
        File json = new File(Constant.REQ_BODY_DIR+"Photos/PostPhotosInvalidBody.json");
        jsonPlaceholderAPI.postPhotosInvalidBodyJson(json);
    }
}

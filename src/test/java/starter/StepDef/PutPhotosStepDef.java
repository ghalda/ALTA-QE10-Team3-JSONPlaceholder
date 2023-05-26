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

public class PutPhotosStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;

    @Given("Put update photos with valid json and parameter ID {int}")
    public void putUpdatePhotosValidJsonAndId(int id){
        File json = new File(Constant.REQ_BODY_DIR+"Photos/PutPhotosValidBody.json");
        jsonPlaceholderAPI.putUpdatePhotosValidJsonAndId(id, json);
    }
    @When("Send put update photos")
    public void sendPutUpdatePhotos() {
        SerenityRest.when().put(JsonPlaceholderAPI.SINGLE_PHOTOS);
    }
    @And("Response body update ID should be {int}, albumId should be {int}, title should be {string}, url should be {string} and thumbnailUrl should be {string}")
    public void responseBodyUpdateIDAlbumIdTitleUrlThumbnailUrl(int id, int albumId, String title, String url, String thumbnailUrl) {
        SerenityRest.and().body(JsonPlaceholderResponse.ID, equalTo(id)).body(JsonPlaceholderResponse.ALBUM_ID, equalTo(albumId)).body(JsonPlaceholderResponse.TITLE, equalTo(title)).body(JsonPlaceholderResponse.URL, equalTo(url)).body(JsonPlaceholderResponse.THUMBNAIL_URL, equalTo(thumbnailUrl));
    }
    @And("Validate put update photos JSON Schema")
    public void validatePutUpdatePhotosJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR+"Photos/PutPhotosJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Put update photos with invalid json and invalid parameter ID {string}")
    public void putUpdatePhotosWithInvalidJsonAndInvalidParameterID(String id) {
        File json = new File(Constant.REQ_BODY_DIR+"Photos/PutPhotosInvalidBody.json");
        jsonPlaceholderAPI.putUpdatePhotosInvalidJsonAndId(id, json);
    }
}

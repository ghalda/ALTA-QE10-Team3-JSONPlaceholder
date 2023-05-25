package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceholder.JsonPlaceholderAPI;

public class DeleteAlbumsStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;

    @Given("Delete albums with valid parameter ID {int}")
    public void deleteAlbumsValidParamId(int id){
        jsonPlaceholderAPI.deleteAlbumsValidParamId(id);
    }

    @When("Send delete albums")
    public void sendDeleteAlbums() {
        SerenityRest.when().delete(JsonPlaceholderAPI.DELETE_SINGLE_ALBUMS);
    }

    @Given("Delete albums with exceed parameter ID {int}")
    public void deleteAlbumsWithExceedParameterID(int id) {
        jsonPlaceholderAPI.deleteAlbumsExceedId(id);
    }

    @Given("Delete albums with invalid parameter ID {string}")
    public void deleteAlbumsWithInvalidParameterID(String id) {
        jsonPlaceholderAPI.deleteAlbumsInvalidParamId(id);
    }
}

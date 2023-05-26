package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceholder.JsonPlaceholderAPI;

public class DeletePhotosStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;

    @Given("Delete photos with valid parameter ID {int}")
    public void deletePhotosValidParamId(int id){
        jsonPlaceholderAPI.deletePhotosValidParamId(id);
    }
    @When("Send delete photos")
    public void sendDeletePhotos() {
        SerenityRest.when().delete(JsonPlaceholderAPI.SINGLE_PHOTOS);
    }
    @Given("Delete photos with exceed parameter ID {int}")
    public void deletePhotosWithExceedParameterID(int id) {
        jsonPlaceholderAPI.deletePhotosExceedParamId(id);
    }
    @Given("Delete photos with invalid parameter ID {string}")
    public void deletePhotosWithInvalidParameterID(String id) {
        jsonPlaceholderAPI.deletePhotosInvalidParamId(id);
    }
}

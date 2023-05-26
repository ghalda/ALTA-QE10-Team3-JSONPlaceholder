package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceholder.JsonPlaceholderAPI;

public class DeleteCommentsStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;

    @Given("Delete comments with valid parameter ID {int}")
    public void deleteCommentsWithValidParameterID(int id) {
        jsonPlaceholderAPI.deleteComments(id);
    }

    @When("Send delete comments")
    public void sendDeleteComments() {
        SerenityRest.when().get(JsonPlaceholderAPI.SINGLE_COMMENTS);
    }

    @Given("Delete comments with invalid parameter ID {string}")
    public void deleteCommentsWithInvalidParameterID(String id) {
        jsonPlaceholderAPI.deleteComments(id);
    }

    @Given("Delete comments with exceed parameter ID {int}")
    public void deleteCommentsWithExceedParameterID(int id) {
        jsonPlaceholderAPI.deleteComments(id);
    }

    @Given("Delete comments with empty parameter ID {string}")
    public void deleteCommentsWithEmptyParameterID(String id) {
        jsonPlaceholderAPI.deleteComments(id);
    }
}

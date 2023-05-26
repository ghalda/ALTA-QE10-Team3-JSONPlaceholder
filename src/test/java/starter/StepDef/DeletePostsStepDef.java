package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceholder.JsonPlaceholderAPI;

public class DeletePostsStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;

    @Given("Delete posts with valid parameter ID {int}")
    public void deletePostsWithValidParameterID(int id) {
        jsonPlaceholderAPI.deletePosts(id);
    }

    @When("Send delete posts")
    public void sendDeletePosts() {
        SerenityRest.when().get(JsonPlaceholderAPI.SINGLE_POSTS);
    }

    @Given("Delete posts with invalid parameter ID {string}")
    public void deletePostsWithInvalidParameterID(String id) {
        jsonPlaceholderAPI.deletePosts(id);
    }

    @Given("Delete posts with exceed parameter ID {int}")
    public void deletePostsWithExceedParameterID(int id) {
        jsonPlaceholderAPI.deletePosts(id);
    }

    @Given("Delete posts with empty parameter ID {string}")
    public void deletePostsWithEmptyParameterID(String id) {
        jsonPlaceholderAPI.deletePosts(id);
    }
}

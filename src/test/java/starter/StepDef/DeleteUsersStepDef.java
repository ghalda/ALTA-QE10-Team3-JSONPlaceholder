package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceholder.JsonPlaceholderAPI;

public class DeleteUsersStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;

    @Given("Delete Users with valid parameter id {int}")
    public void deleteUsersWithValidId(int id) {
        jsonPlaceholderAPI.deleteUsersValidParamId(id);
    }

    @When("Send Delete users")
    public void sendDeleteUsersWithValidId() {
        SerenityRest.when().delete(JsonPlaceholderAPI.SINGLE_USERS);
    }

    @Given("Delete Users with invalid parameter id {string}")
    public void deleteUsersWithInvalidId(String id) {
        jsonPlaceholderAPI.deleteUsersInvalidParamId(id);
    }

    @Given("Delete users with exceed parameter id {int}")
    public void deleteUsersWithExceedParameterId(int id) {
        jsonPlaceholderAPI.deleteUsersExceedParamId(id);
    }

}

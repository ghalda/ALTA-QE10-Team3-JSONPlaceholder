package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JsonPlaceholder.JsonPlaceholderAPI;

public class DeleteTodosStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;

    @Given("Delete Todos with valid id {int}")
    public void deleteTodosWithValidId(int id) {
        jsonPlaceholderAPI.deleteTodosValidId(id);
    }

    @When("Send Delete Todos")
    public void sendDeleteTodosWithValidId() {
        SerenityRest.when().delete(JsonPlaceholderAPI.DELETE_TODOS);
    }

    @Given("Delete Todos with invalid id {string}")
    public void deleteTodosWithInvalidId(String id) {
        jsonPlaceholderAPI.deleteTodosInvalidId(id);
    }

    @When("Send Delete Todos with invalid id")
    public void sendDeleteTodosWithInvalidId() {
        SerenityRest.when().delete(JsonPlaceholderAPI.DELETE_TODOS);
    }

    @Given("Delete Todos with exceed parameter id {int}")
    public void deleteTodosWithExceedParameterId(int id) {
        jsonPlaceholderAPI.deleteTodosExceedId(id);
    }
    @When("Send Delete Todos exceed parameter id")
    public void sendDeleteTodosExceedParameterId() {
        SerenityRest.when().delete(JsonPlaceholderAPI.DELETE_TODOS);
    }


}


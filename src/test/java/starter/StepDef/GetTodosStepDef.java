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

public class GetTodosStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;

    @Given("Get single todos with valid parameter ID {int}")
    public void getSingleTodosWithValidParameterID(int id) {
        jsonPlaceholderAPI.getSingleTodosValidParam(id);
    }

    @When("Send get single todos")
    public void sendGetSingleTodos() {
        SerenityRest.when().get(JsonPlaceholderAPI.GET_SINGLE_TODOS);
    }

    @And("Validate get single todos JSON Schema")
    public void validateGetSingleTodosJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Todos/GetSingleTodosJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get single todos with invalid parameter ID {string}")
    public void getSingleTodosWithInvalidParameterID(String id) {
        jsonPlaceholderAPI.getSingleTodosInvalidParam(id);
    }

    @When("Send get single todos with invalid parameter id")
    public void sendGetSingleTodosWithInvalidParameterId() {
        SerenityRest.when().get(JsonPlaceholderAPI.GET_SINGLE_TODOS);
    }
}


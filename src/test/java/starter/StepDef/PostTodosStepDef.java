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

public class PostTodosStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;

    @Given("Post Create todos with valid reqbody")
    public void postCreateTodosWithValidRequestBody() {
        File json = new File(Constant.REQ_BODY_DIR + "Todos/PostCreateTodosValidReqBody.json");
        jsonPlaceholderAPI.postCreateTodosValidReqBody(json);
    }

    @When("Send Post Create Todos")
    public void sendPostCreateTodos() {
        SerenityRest.when().post(JsonPlaceholderAPI.LIST_TODOS);
    }

    @And("Response body for userId {int} and  title should be {string}")
    public void responseBodyForUserIdAndTitleShouldBe(int userID, String title) {
        SerenityRest.and()
                .body(JsonPlaceholderResponse.USER_ID,equalTo(userID))
                .body(JsonPlaceholderResponse.TITLE,equalTo(title));
    }

    @And("Validate Post Create Todos JSON Schema")
    public void validatePostCreateTodosJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR+"Todos/PostCreateTodosJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @Given("Post Create todos with invalid reqbody title")
    public void postCreateTodosWithInvalidReqbodyTitle() {
        File json = new File(Constant.REQ_BODY_DIR+"Todos/PostCreateTodosInvalidReqBodyTitle.json");
        jsonPlaceholderAPI.postCreateTodosInvalidReqBodyTitle(json);
    }

    @Given("Post create todos with invalid reqbody userId")
    public void postCreateTodosWithInvalidReqbodyUserId() {
        File json = new File(Constant.REQ_BODY_DIR+"/Todos/PostCreateTodosInvalidReqBodyUserId.json");
        jsonPlaceholderAPI.postCreateTodosInvalidReqBodyUserId(json);
    }

    @When("Send Post Create Todos with invalid reqbody userId")
    public void sendPostCreateTodosWithInvalidReqbodyUserId() {
        SerenityRest.when().post(JsonPlaceholderAPI.LIST_TODOS);
    }

}


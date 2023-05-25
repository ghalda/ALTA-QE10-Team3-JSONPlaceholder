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

public class PutTodosStepDef {
    @Steps
    JsonPlaceholderAPI jsonPlaceholderAPI;

    @Given("Put Update Todos with valid id {int} & valid reqbody")
    public void putUpdateTodosWithValidIdValidReqbody(int id) {
        File json = new File(Constant.REQ_BODY_DIR + "Todos/PutUpdateTodosValidReqBody.json");
        jsonPlaceholderAPI.putUpdateTodosValidIdAndValidReqbody(json, id);
    }

    @When("Send Put Update Todos")
    public void sendPutUpdateTodos() {
        SerenityRest.when().put(JsonPlaceholderAPI.PUT_UPDATE_TODOS);
    }

    @And("Response body title should be user id {int} and title {string}")
    public void responseBodyTitleShouldBeUserIdAndTitle(int userId, String title) {
        SerenityRest.and().body(JsonPlaceholderResponse.USER_ID, equalTo(userId));
    }

    @And("Validate  Update Todos  Todos JSON Schema")
    public void validateUpdateTodosTodosJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Todos/PutUpdateTodosJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Put update Todos with exceed parameter ID {int}")
    public void putUpdateTodosWithExceedParameterID(int id) {
        File json = new File(Constant.REQ_BODY_DIR + "Todos/PutUpdateTodosValidReqBody.json");
        jsonPlaceholderAPI.putUpdateTodosExceed(json, id);
    }

    @When("Send put update todos exceed parameter ID")
    public void sendPutUpdateTodosExceedParameterID() {
        SerenityRest.when().put(JsonPlaceholderAPI.PUT_UPDATE_TODOS);
    }

    @Given("Put Update Todos with invalid id {string} & valid reqbody")
    public void putUpdateTodosWithInvalidIdValidReqbody(String id) {
        File json = new File (Constant.REQ_BODY_DIR+"Todos/PutUpdateTodosValidReqBody.json");
        jsonPlaceholderAPI.putUpdateTodosInvalidIdAndValidReqbody(id,json);
    }

    @When("Send Put Update Todos with invalid id & valid reqbody")
    public void sendPutUpdateTodosWithInvalidIdValidReqbody() {
        SerenityRest.when().put(JsonPlaceholderAPI.PUT_UPDATE_TODOS);
    }

    @Given("Put Update Todos with invalid reqbody title and valid id {int}")
    public void putUpdateTodosWithInvalidReqbodyTitleAndValidId(int id) {
        File json = new File(Constant.REQ_BODY_DIR+"Todos/PutUpdateTodosInvalidReqBodyTitle.json");
        jsonPlaceholderAPI.putUpdateTodosInvalidReqbodyAndValidId(json,id);
    }
    @When("Send Put Update Todos with invalid reqbody title and valid id")
    public void sendPutUpdateTodosWithInvalidReqbodyTitle() {
        SerenityRest.when().put(JsonPlaceholderAPI.PUT_UPDATE_TODOS);
    }


}

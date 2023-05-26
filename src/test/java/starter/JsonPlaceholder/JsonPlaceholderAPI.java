package starter.JsonPlaceholder;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constant;

import java.io.File;

public class JsonPlaceholderAPI {
    public static String LIST_POSTS = Constant.BASE_URL+ "/posts";
    public static String SINGLE_POST = Constant.BASE_URL+ "/posts/{id}";
    public static String LIST_COMMENTS = Constant.BASE_URL+ "/comments";
    public static String SINGLE_COMMENTS = Constant.BASE_URL+ "/comments/{id}";
    public static String SINGLE_ALBUMS = Constant.BASE_URL+"/albums/{id}";
    public static String LIST_ALBUMS = Constant.BASE_URL+"/albums";
    public static String SINGLE_TODOS = Constant.BASE_URL + "/todos/{id}";
    public static String LIST_TODOS = Constant.BASE_URL + "/todos";
    public static String SINGLE_PHOTOS = Constant.BASE_URL+"/photos/{id}";
    public static String LIST_PHOTOS = Constant.BASE_URL+"/photos";
    public static String SINGLE_USERS = Constant.BASE_URL + "/users/{id}";
    public static String LIST_USERS = Constant.BASE_URL + "/users";

    //Get single albums
    @Step("Get albums with valid parameter ID")
    public void getAlbumsValidParamId(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get albums with invalid parameter ID")
    public void getAlbumsInvalidParamId(String id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get albums with exceed parameter ID")
    public void getAlbumsExceedParamId(int id){
        SerenityRest.given().pathParam("id", id);
    }

    //Post create albums
    @Step("Post create albums with valid body json")
    public void postAlbumsValidBodyJson(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Post create albums with invalid request body userId")
    public void postAlbumsInvalidBodyUserId(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Post create albums with invalid request body title")
    public void postAlbumsInvalidBodyTitle(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Post create albums only using valid body title without body userId")
    public void postAlbumsWithoutBodyUserId(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    //Put update albums
    @Step("Put update albums with valid json and parameter ID")
    public void putUpdateAlbumsValidJsonAndId(int id, File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }
    @Step("Put update albums with invalid parameter ID and valid json")
    public void putUpdateAlbumsInvalidIdAndValidJson(String id, File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }
    @Step("Put update albums with valid parameter ID and invalid json")
    public void putUpdateAlbumsValidIdAndInvalidJson(int id, File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }
    @Step("Put update albums with invalid parameter ID and invalid json")
    public void putUpdateAlbumsInvalidIdAndInvalidJson(String id, File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }
    @Step("Put update albums with exceed parameter ID and valid json")
    public void putUpdateAlbumsExceedIdAndValidJson(int id, File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }

    //Delete single albums
    @Step("Delete albums with valid parameter ID")
    public void deleteAlbumsValidParamId(int id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Delete albums with exceed parameter ID")
    public void deleteAlbumsExceedId(int id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Delete albums with invalid parameter ID")
    public void deleteAlbumsInvalidParamId(String id){
        SerenityRest.given().pathParam("id", id);
    }

//Get Todos
    @Step("Get single Todos with valid parameter id ")
    public void getSingleTodosValidParam(int id) {
    SerenityRest.given().pathParam("id", id);
}

    @Step("Get single Todos with invalid parameter id ")
    public void getSingleTodosInvalidParam(String id) {
        SerenityRest.given().pathParam("id", id);
    }

    //Post Create Todos
    @Step("Post Create Todos with valid reqbody")
    public void postCreateTodosValidReqBody(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Create Todos with invalid reqbody userId")
    public void postCreateTodosInvalidReqBodyUserId(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Create Todos with invalid reqbody title")
    public void postCreateTodosInvalidReqBodyTitle(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
//Put Update Todos
    @Step("Put Update Todos with valid id and valid reqbody")
    public void putUpdateTodosValidIdAndValidReqbody(File json, int id) {
        SerenityRest.given().pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put Update Todos with invalid id and valid reqbody")
    public void putUpdateTodosInvalidIdAndValidReqbody(String id, File json) {
        SerenityRest.given().pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put Update Todos invalid reqbody title and valid Id")
    public void putUpdateTodosInvalidReqbodyAndValidId(File json, int id) {
        SerenityRest.given().pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put Update Todos with exceed id")
    public void putUpdateTodosExceed(File json, int id) {
        SerenityRest.given().pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
//Delete Todos
    @Step("Delete Todos with valid id")
    public void deleteTodosValidId(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Delete Todos with invalid id")
    public void deleteTodosInvalidId(String id) {
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Delete Todos with exceed id")
    public void deleteTodosExceedId(int id) {
        SerenityRest.given().pathParam("id",id);
    }

    //Get single photos
    @Step("Get photos with valid parameter ID")
    public void getPhotosValidParamId(int id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Get photos with invalid parameter ID")
    public void getPhotosInvalidParamId(String id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Get photos with exceed parameter ID")
    public void getPhotosExceedParamId(int id){
        SerenityRest.given().pathParam("id", id);
    }

    //Post create photos
    @Step("Post create photos with valid body json")
    public void postPhotosValidBodyJson(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Post create photos with invalid body json")
    public void postPhotosInvalidBodyJson(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    //Put update photos
    @Step("Put update photos with valid json and parameter ID")
    public void putUpdatePhotosValidJsonAndId(int id, File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }
    @Step("Put update photos with invalid json and invalid parameter ID")
    public void putUpdatePhotosInvalidJsonAndId(String id, File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }

    //Delete single photos
    @Step("Delete photos with valid parameter ID")
    public void deletePhotosValidParamId(int id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Delete photos with exceed parameter ID")
    public void deletePhotosExceedParamId(int id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Delete photos with invalid parameter ID")
    public void deletePhotosInvalidParamId(String id){
        SerenityRest.given().pathParam("id", id);
    }
    ///Get single users
    @Step("Get single users with valid parameter id ")
    public void getSingleUsersValidParam(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get single users with invalid parameter id ")
    public void getSingleUsersInvalidParam(String id) {
        SerenityRest.given().pathParam("id", id);
    }



    //Post Users
    @Step("Post Create users with valid bodyjson")
    public void postCreateUsersValidReqBody(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Create users with invalid reqbody name ")
    public void postCreateUsersInvalidReqBodyName(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Create users with invalid reqbody users username")
    public void postCreateUsersInvalidReqBodyUsername(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Put Users
    @Step("Put Update users with valid bodyjson")
    public void putUpdateUsersValidIdAndValidReqbody(File json, int id) {
        SerenityRest.given().pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step(" Put Update users with invalid parameter id & valid reqbody")
    public void putUpdateUsersInvalidIdAndValidReqbody(String id, File json) {
        SerenityRest.given().pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put Update users with valid parameter id and without request body")
    public void putUpdateUsersValidIdAndWithoutRequestBody(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Put update users with exceed parameter id")
    public void putUpdateUsersWithExceedParameterID(File json, int id) {
        SerenityRest.given().pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Delete Users
    @Step("Delete users with valid parameter id")
    public void deleteUsersValidParamId(int id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Delete users with exceed parameter id")
    public void deleteUsersExceedParamId(int id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Delete users with invalid parameter id")
    public void deleteUsersInvalidParamId(String id){
        SerenityRest.given().pathParam("id", id);
    }

}
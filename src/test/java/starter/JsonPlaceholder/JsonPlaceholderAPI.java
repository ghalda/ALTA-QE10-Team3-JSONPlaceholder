package starter.JsonPlaceholder;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constant;

import java.io.File;

public class JsonPlaceholderAPI {
    public static String GET_LIST_POSTS = Constant.BASE_URL+ "/posts";
    public static String GET_SINGLE_POST = Constant.BASE_URL+ "/posts/{id}";

    public static String GET_SINGLE_ALBUMS = Constant.BASE_URL+"/albums/{id}";

    public static String POST_CREATE_ALBUMS = Constant.BASE_URL+"/albums";

    public static String PUT_UPDATE_ALBUMS = Constant.BASE_URL+"/albums/{id}";

    public static String DELETE_SINGLE_ALBUMS = Constant.BASE_URL+"/albums/{id}";

    @Step("Get lists post")
    public void getListPost(Object page){
        SerenityRest.given()
                .pathParam("page", page);
    }
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
}

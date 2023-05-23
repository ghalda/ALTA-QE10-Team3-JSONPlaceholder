package starter.JsonPlaceholder;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constant;

public class JsonPlaceholderAPI {
    public static String GET_LIST_POSTS = Constant.BASE_URL+ "/posts";
    public static String GET_SINGLE_POST = Constant.BASE_URL+ "/posts/{id}";

    @Step("Get lists post")
    public void getListPost(Object page){
        SerenityRest.given()
                .pathParam("page", page);
    }
}

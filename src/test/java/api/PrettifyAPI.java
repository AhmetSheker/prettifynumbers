package api;

import baseurl.PrettifyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PrettifyAPI extends PrettifyBaseUrl {
    @Test
    public void test01(){
        spec.pathParam("1", "test");
        Map<String, Object> postPrettify = new HashMap<>();
        postPrettify.put("number", 2458707);
        Response response = given().spec(spec).contentType(ContentType.JSON).body(postPrettify).when().post("/{1}");
        response.then().assertThat().statusCode(200).body("number", equalTo(2458707)).body("prettified", equalTo("2.4M")).body("error", equalTo(false));
    }
    @Test
    public void test02(){
        spec.pathParam("1", "test");
        Map<String, Object> postPrettify = new HashMap<>();
        postPrettify.put("number", "notanumber");
        Response response = given().spec(spec).contentType(ContentType.JSON).body(postPrettify).when().post("/{1}");
        response.then().assertThat().statusCode(400).body("error", equalTo(true)).body("message", equalTo("Invalid input! Only numbers accepted."));
    }
}

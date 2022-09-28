package baseurl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class PrettifyBaseUrl {
    protected RequestSpecification spec;
    @Before
    public void baseUrl(){
        spec = new RequestSpecBuilder().setBaseUri("https://prettifyyournumber.com").build();
    }
}

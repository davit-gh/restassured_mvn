import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;

public class GetRequest {

    private static void makeRequest(String messageBody) {
        RestAssured
                .given().log().all().contentType("application/json").accept("application/json")
                .body(messageBody)
                .when().get("https://jsonplaceholder.typicode.com/posts/42")
                .then().assertThat().statusCode(200)
                .and().contentType(ContentType.JSON)
                .and().body("userId", equalTo(5)).body("title", containsString("sint")).log().all();
    }

    public static void main(String[] args){
       GetRequest.makeRequest("");
    }
}


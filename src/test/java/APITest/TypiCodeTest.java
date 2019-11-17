package APITest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TypiCodeTest {

    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = "https://my-json-server.typicode.com/typicode/demo/posts";
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-type", "application/json");
        System.out.println("====================Starting API Test==================");
    }

    @Test
    public void TypiCodeTest() {
        when()
            .get("/{id}", 1).
        then()
            .assertThat()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body(matchesJsonSchemaInClasspath("JsonSchema/jsonSchema.json"))
            .body("id",equalTo(1),
                    "title",equalTo("Post " + 1));
    }
}

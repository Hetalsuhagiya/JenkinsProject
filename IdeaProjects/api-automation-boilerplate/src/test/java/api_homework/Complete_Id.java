package api_homework;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Test
public class Complete_Id {
    public  void verify_that_id_2_is_not_completed(){
        Response response = given()
                .baseUri("https://jsonplaceholder.typicode.com/todos")
                .when()
                .get("2")
                .then()
                .extract().response();
        JsonPath jsonPath = response.getBody().jsonPath();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.jsonPath().getString("title"),"quis ut nam facilis et officia qui");
        Assert.assertEquals(response.jsonPath().getString("completed"),"false");

    }
    public void verify_that_id_4_is_completed(){
        Response response = given()
                .baseUri("https://jsonplaceholder.typicode.com/todos")
                .when()
                .get("4")
                .then()
                .extract().response();
        JsonPath jsonPath = response.getBody().jsonPath();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.jsonPath().getString("title"),"et porro tempora");
        Assert.assertEquals(response.jsonPath().getString("completed"),"true");

    }
}


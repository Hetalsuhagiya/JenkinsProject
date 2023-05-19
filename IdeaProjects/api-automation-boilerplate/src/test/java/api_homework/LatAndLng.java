package api_homework;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Test
public class LatAndLng {
    public void verify_that_latitude_and_longitude_is_correct(){
        Response response=given()
                .baseUri("https://jsonplaceholder.typicode.com/users/2")
                .when()
                .get()
                .then()
                .extract().response();
        JsonPath jsonPath = response.getBody().jsonPath();
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.jsonPath().getDouble("address.geo.lat"),-43.9509);
        Assert.assertEquals(response.jsonPath().getDouble("address.geo.lng"),-34.4618);

    }
}

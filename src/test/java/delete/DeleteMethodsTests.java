package delete;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import specification.DefaultSpecification;

import static io.restassured.RestAssured.given;

public class DeleteMethodsTests extends BaseTest {

    @Test
    public void deleteTest() {
        DefaultSpecification.installSpecification(DefaultSpecification.requestSpec(URL), DefaultSpecification.responseSpecCustomResponseCode(204));
        given()
                .when()
                .delete("/api/users/2")
                .then().log().all();
    }

    @Test
    public void deleteTest404Error() {
        DefaultSpecification.installSpecification(DefaultSpecification.requestSpec(URL), DefaultSpecification.responseSpecCustomResponseCode(404));
        given()
                .when()
                .delete("/api")
                .then().log().all();
    }



}

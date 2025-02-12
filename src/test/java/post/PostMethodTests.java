package post;

import baseTest.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.pojoRequests.UserCreationData;
import pojo.pojoRequests.UserRegisterData;
import pojo.pojoResponsces.SuccessRegistration;
import pojo.pojoResponsces.SuccessUserCreation;
import specification.DefaultSpecification;

import static io.restassured.RestAssured.given;

public class PostMethodTests extends BaseTest {

    @Test
    public void successRegistrationTest() {
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";

        UserRegisterData user = new UserRegisterData("eve.holt@reqres.in", "pistol");

        SuccessRegistration successRegistration =
                given()
                        .body(user)
                        .when()
                        .post("/api/register")
                        .then().log().all()
                        .extract().as(SuccessRegistration.class);

        Assertions.assertNotNull(successRegistration.getId());
        Assertions.assertNotNull(successRegistration.getToken());
        Assertions.assertEquals(id, successRegistration.getId());
        Assertions.assertEquals(token, successRegistration.getToken());
    }

    @Test
    public void testThatUserContainsEmailTest(){
        DefaultSpecification.installSpecification(DefaultSpecification.requestSpec(URL), DefaultSpecification.responseSpecCustomResponseCode(201));
        UserCreationData user = new UserCreationData("morpheus", "zion resident");

        SuccessUserCreation response = given()
                .when()
                .body(user)
                .post(URL + "/api/users")
                .then().log().all()
                .extract().body().as(SuccessUserCreation.class);

        Assertions.assertEquals(response.getName(), user.getName(), "Wrong name");
        Assertions.assertEquals(response.getJob(), user.getJob(), "Wrong job");
        Assertions.assertNotNull(response.getId(), "No id");
        Assertions.assertNotNull(response.getCreatedAt(), "No created at field");
    }

}

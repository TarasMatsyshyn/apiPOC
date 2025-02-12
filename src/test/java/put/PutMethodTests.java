package put;

import baseTest.BaseTest;
import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.pojoRequests.UserCreationData;
import pojo.pojoResponsces.SuccessUserCreation;
import specification.DefaultSpecification;

import static io.restassured.RestAssured.given;

@Slf4j
public class PutMethodTests extends BaseTest {

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
    //        Assertions.assertEquals(response.getId(), "622", "Wrong id");
        Assertions.assertNotNull(response.getCreatedAt(), "No created at field");
    }

}

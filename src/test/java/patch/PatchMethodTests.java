package patch;

import baseTest.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.pojoRequests.UpdateData;
import pojo.pojoResponsces.SuccessUpdate;

import static io.restassured.RestAssured.given;

public class PatchMethodTests extends BaseTest {

    @Test
    public void testThatUserContainsEmailTest(){
        UpdateData user = new UpdateData("morpheus", "zion resident");

        SuccessUpdate response = given()
                .when()
                .body(user)
                .patch(URL + "/api/users/2")
                .then().log().all()
                .extract().body().as(SuccessUpdate.class);

        Assertions.assertEquals(response.getName(), user.getName());
        Assertions.assertEquals(response.getJob(), user.getJob());
        Assertions.assertNotNull(response.getUpdatedAt());
    }

}

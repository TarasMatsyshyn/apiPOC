package baseTest;

import org.junit.jupiter.api.BeforeAll;
import specification.DefaultSpecification;

public class BaseTest {

    protected final static String URL = "https://reqres.in";

    @BeforeAll
    public static void initSpecifications(){
        DefaultSpecification.installSpecification(DefaultSpecification.requestSpec(URL), DefaultSpecification.responseSpecOK200());
    }


}

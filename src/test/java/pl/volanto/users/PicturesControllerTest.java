package pl.volanto.users;

import com.jayway.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import pl.volanto.Application;
import pl.volanto.users.model.UserRest;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.jayway.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PicturesControllerTest {

    @LocalServerPort
    private int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
//    @WithMockUser
    public void shouldName() throws Exception {
        // given
        Path filePath = Paths.get(getClass().getResource("test.png").toURI());

        // when
        given()
                .multiPart("file", filePath.toFile())
                .when()
                .log().all()
                .post("/api/pictures")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK);

        // then

    }
}
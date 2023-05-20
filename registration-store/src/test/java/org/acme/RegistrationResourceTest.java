package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.acme.registration.RegistrationDTO;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class RegistrationResourceTest {

    @Test
    void testRegistration() {
        var regIvan = new RegistrationDTO("Ivan", "Ivanov", "ivan.ivanov@gmail.com");
        given()
                .when()
                .body(regIvan)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post("/registration")
                .then()
                .statusCode(204);
    }

}

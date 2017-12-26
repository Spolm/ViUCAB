package edu.ucab.desarrollo.viucab.webService.M11_Estadistica;


import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;


import java.net.URI;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Daniel on 26/12/2017.
 */
class M11_EstadisticaTest {
    @Test
    void estadistica1()  {

        URI prueba = null;
        try {
            prueba = new URI("localhost:8888/viucab/Estadistica/Estadistica1?username=pepe");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        given().accept(ContentType.JSON).when().get(prueba).then().assertThat().statusCode(HttpStatus.SC_OK);

        String json = given().accept(ContentType.JSON).when()
                .get(prueba).thenReturn().body().asString();
        assertNotNull(json);
    }

    @Test
    void estadistica2() {

        URI prueba = null;
        try {
            prueba = new URI("localhost:8888/viucab/Estadistica/Estadistica2?username=pepe");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        given().accept(ContentType.JSON).when().get(prueba).then().assertThat().statusCode(HttpStatus.SC_OK);

        String json = given().accept(ContentType.JSON).when()
                .get(prueba).thenReturn().body().asString();
        assertNotNull(json);
    }

    @Test
    void estadistica3() {

        URI prueba = null;
        try {
            prueba = new URI("localhost:8888/viucab/Estadistica/Estadistica3?username=pepe");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        given().accept(ContentType.JSON).when().get(prueba).then().assertThat().statusCode(HttpStatus.SC_OK);

        String json = given().accept(ContentType.JSON).when()
                .get(prueba).thenReturn().body().asString();
        assertNotNull(json);
    }

    @Test
    void estadistica4() {
        URI prueba = null;
        try {
            prueba = new URI("localhost:8888/viucab/Estadistica/Estadistica4?username=pepe");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        given().accept(ContentType.JSON).when().get(prueba).then().assertThat().statusCode(HttpStatus.SC_OK);

        String json = given().accept(ContentType.JSON).when()
                .get(prueba).thenReturn().body().asString();
        assertNotNull(json);

    }

    @Test
    void estadistica5() {

        URI prueba = null;
        try {
            prueba = new URI("localhost:8888/viucab/Estadistica/Estadistica5?username=pepe");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        given().accept(ContentType.JSON).when().get(prueba).then().assertThat().statusCode(HttpStatus.SC_OK);

        String json = given().accept(ContentType.JSON).when()
                .get(prueba).thenReturn().body().asString();
        assertNotNull(json);
    }

    @Test
    void estadistica6() {

        URI prueba = null;
        try {
            prueba = new URI("localhost:8888/viucab/Estadistica/Estadistica6?username=pepe");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        given().accept(ContentType.JSON).when().get(prueba).then().assertThat().statusCode(HttpStatus.SC_OK);

        String json = given().accept(ContentType.JSON).when()
                .get(prueba).thenReturn().body().asString();
        assertNotNull(json);
    }

    @Test
    void estadistica7() {
        URI prueba = null;
        try {
            prueba = new URI("localhost:8888/viucab/Estadistica/Estadistica7?username=pepe");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        given().accept(ContentType.JSON).when().get(prueba).then().assertThat().statusCode(HttpStatus.SC_OK);

        String json = given().accept(ContentType.JSON).when()
                .get(prueba).thenReturn().body().asString();
        assertNotNull(json);
    }

    @Test
    void estadistica8() {
        URI prueba = null;
        try {
            prueba = new URI("localhost:8888/viucab/Estadistica/Estadistica8?username=pepe");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        given().accept(ContentType.JSON).when().get(prueba).then().assertThat().statusCode(HttpStatus.SC_OK);

        String json = given().accept(ContentType.JSON).when()
                .get(prueba).thenReturn().body().asString();
        assertNotNull(json);
    }

    @Test
    void estadistica9() {

        URI prueba = null;
        try {
            prueba = new URI("localhost:8888/viucab/Estadistica/Estadistica9?username=pepe");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        given().accept(ContentType.JSON).when().get(prueba).then().assertThat().statusCode(HttpStatus.SC_OK);

        String json = given().accept(ContentType.JSON).when()
                .get(prueba).thenReturn().body().asString();
        assertNotNull(json);
    }

}
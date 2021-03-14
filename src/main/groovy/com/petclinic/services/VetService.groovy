package com.petclinic.services

import com.petclinic.dto.Vet

import groovy.transform.CompileStatic

import static io.restassured.RestAssured.given
import static org.apache.http.HttpStatus.SC_OK

@CompileStatic
class VetService {

    static Vet[] getAllVets() {
        //@formatter:off
        given()
                .spec(RequestSpecs.basicSpec())
        .when()
                .get(Paths.VETS)
        .then()
                .statusCode(SC_OK)
                .extract().as(Vet[].class)
        //@formatter:on
    }

    static Vet getVet(int vetId) {
        //@formatter:off
        given()
                .spec(RequestSpecs.basicSpec())
                .pathParam('vetId', vetId)
        .when()
                .get(Paths.VET)
        .then()
                .statusCode(SC_OK)
                .extract().response().<Vet>as(Vet)
        //@formatter:on
    }
}

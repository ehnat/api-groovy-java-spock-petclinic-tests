package com.petclinic.services

import com.petclinic.dto.Owner
import groovy.transform.CompileStatic

import static io.restassured.RestAssured.given
import static org.apache.http.HttpStatus.SC_CREATED
import static org.apache.http.HttpStatus.SC_OK

@CompileStatic
class OwnerService {

    static Owner[] getAllOwners() {
        //@formatter:off
        given()
                .spec(RequestSpecs.basicSpec())
        .when()
                .get(Paths.OWNERS)
        .then()
                .statusCode(SC_OK)
                .extract().as(Owner[].class)
        //@formatter:on
    }

    static Owner getOwner(int ownerId) {
        //@formatter:off
        given()
                .spec(RequestSpecs.basicSpec())
                .pathParam('ownerId', ownerId)
        .when()
                .get(Paths.OWNER)
        .then()
                .statusCode(SC_OK)
                .extract().response().<Owner>as(Owner)
        //@formatter:on
    }

    static Owner addOwner(Owner requestBody) {
        //@formatter:off
        given()
                .spec(RequestSpecs.basicSpec())
                .body(requestBody)
        .when()
                .post(Paths.OWNERS)
                .then()
                .statusCode(SC_CREATED)
                .extract().response().<Owner>as(Owner)
        //@formatter:on
    }
}

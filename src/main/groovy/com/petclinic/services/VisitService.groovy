package com.petclinic.services


import com.petclinic.dto.Visit
import groovy.transform.CompileStatic

import static io.restassured.RestAssured.given
import static org.apache.http.HttpStatus.SC_CREATED
import static org.apache.http.HttpStatus.SC_OK

@CompileStatic
class VisitService {

    static Visit[] getAllVisits() {
        //@formatter:off
        given()
                .spec(RequestSpecs.basicSpec())
        .when()
                .get(Paths.VISITS)
        .then()
                .statusCode(SC_OK)
                .extract().as(Visit[].class)
        //@formatter:on
    }

    static Visit getVisit(int visitId) {
        //@formatter:off
        given()
                .spec(RequestSpecs.basicSpec())
                .pathParam('visitId', visitId)
        .when()
                .get(Paths.VISIT)
        .then()
                .statusCode(SC_OK)
                .extract().response().<Visit>as(Visit)
        //@formatter:on
    }

    static Visit addVisit(Visit requestBody) {
        //@formatter:off
        given()
                .spec(RequestSpecs.basicSpec())
                .body(requestBody)
        .when()
                .post(Paths.VISITS)
        .then()
                .statusCode(SC_CREATED)
                .extract().response().<Visit>as(Visit)
        //@formatter:on
    }
}

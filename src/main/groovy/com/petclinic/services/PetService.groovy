package com.petclinic.services

import com.petclinic.dto.Pet
import com.petclinic.dto.PetType
import groovy.transform.CompileStatic

import static io.restassured.RestAssured.given
import static org.apache.http.HttpStatus.SC_CREATED
import static org.apache.http.HttpStatus.SC_OK

@CompileStatic
class PetService {

    static PetType getPetType(int petTypeId) {
        //@formatter:off
        given()
                .spec(RequestSpecs.basicSpec())
                .pathParam('petTypeId', petTypeId)
        .when()
                .get(Paths.PET_TYPE)
        .then()
                .statusCode(SC_OK)
                .extract().response().<PetType>as(PetType)
        //@formatter:on
    }

    static List<Pet> getAllPets() {
        //@formatter:off
        Arrays.asList(given()
                .spec(RequestSpecs.basicSpec())
        .when()
                .get(Paths.PETS)
        .then()
                .statusCode(SC_OK)
                .extract().as(Pet[].class))
        //@formatter:on
    }

    static Pet getPet(int petId) {
        //@formatter:off
        given()
                .spec(RequestSpecs.basicSpec())
                .pathParam('id', petId)
        .when()
                .get(Paths.PET)
        .then()
                .statusCode(SC_OK)
                .extract().response().<Pet>as(Pet)
        //@formatter:on
    }

    static Pet addPet(Pet requestBody) {
        //@formatter:off
        given()
                .spec(RequestSpecs.basicSpec())
                .body(requestBody)
        .when()
                .post(Paths.PETS)
        .then()
                .statusCode(SC_CREATED)
                .extract().response().<Pet>as(Pet)
        //@formatter:on
    }
}

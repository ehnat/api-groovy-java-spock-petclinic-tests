package com.petclinic.databuilders

import com.github.javafaker.Faker
import com.petclinic.dto.Owner
import groovy.transform.CompileStatic

import static com.petclinic.databuilders.util.PropertiesValidator.validatePropertyNames
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric

@CompileStatic
class OwnerCreator {

    private static final Faker FAKER = new Faker()

    private static final Map DEFAULT_OWNER_PROPERTIES = [
            id       : null,
            firstName: FAKER.name().firstName(),
            lastName : FAKER.name().lastName(),
            address  : FAKER.address().fullAddress(),
            city     : FAKER.address().city(),
            telephone: randomNumeric(2)
    ]

    static Owner sampleOwnerRequest(Map properties = [:]) {
        validatePropertyNames(DEFAULT_OWNER_PROPERTIES, properties)

        properties = DEFAULT_OWNER_PROPERTIES + properties

        return new Owner(
                id: properties.id as Integer,
                firstName: properties.firstName as String,
                lastName: properties.lastName as String,
                address: properties.address as String,
                city: properties.city as String,
                telephone: properties.telephone as String,
        )
    }
}

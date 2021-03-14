package com.petclinic.databuilders

import com.petclinic.dto.Pet
import com.petclinic.dto.Visit
import com.petclinic.services.PetService
import groovy.transform.CompileStatic

import static com.petclinic.databuilders.util.PropertiesValidator.validatePropertyNames
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic

@CompileStatic
class VisitCreator {

    private static final Map DEFAULT_VISIT_PROPERTIES = [
            id         : 0,
            date       : "2010/01/20",
            description: randomAlphabetic(10),
            pet        : PetService.getPet(7)
    ]

    static Visit sampleVisitRequest(Map properties = [:]) {
        validatePropertyNames(DEFAULT_VISIT_PROPERTIES, properties)

        properties = DEFAULT_VISIT_PROPERTIES + properties

        return new Visit(
                id: properties.id as int,
                date: properties.date as String,
                description: properties.description as String,
                pet: properties.pet as Pet
        )
    }
}

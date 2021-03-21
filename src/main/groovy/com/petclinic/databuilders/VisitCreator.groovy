package com.petclinic.databuilders

import com.petclinic.databuilders.util.Utils
import com.petclinic.dto.Pet
import com.petclinic.dto.Visit
import groovy.transform.CompileStatic

import static com.petclinic.databuilders.util.PropertiesValidator.validatePropertyNames
import static com.petclinic.services.PetService.getPet
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic

@CompileStatic
class VisitCreator {

    private static final Map DEFAULT_VISIT_PROPERTIES = [
            id         : 0,
            date       : Utils.todayDate,
            description: randomAlphabetic(10),
            pet        : getPet(7)
    ]

    static Visit sampleVisitRequest(Map properties = [:]) {
        validatePropertyNames(DEFAULT_VISIT_PROPERTIES, properties)

        properties = DEFAULT_VISIT_PROPERTIES + properties

        return new Visit().tap {
            id = properties.id as int
            date = properties.date as String
            description = properties.description as String
            pet = properties.pet as Pet
        }
    }
}

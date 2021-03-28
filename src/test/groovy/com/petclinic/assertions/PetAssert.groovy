package com.petclinic.assertions

import com.petclinic.dto.Pet
import org.assertj.core.api.*

class PetAssert extends AbstractAssert<PetAssert, Pet> {

    PetAssert(Pet actual) {
        super(actual, PetAssert.class)
    }

    PetAssert hasName(String expectedName) {
        isNotNull()
        if (expectedName != actual.name) {
            failWithMessage("Expected pet's name: <%s> but was <%s>", expectedName, actual.name)
        }
        myself
    }

    PetAssert hasOwnerId(Integer expectedOwnerId) {
        isNotNull()
        if (expectedOwnerId != actual.owner.id) {
            failWithMessage("Expected pet's ownerId: <%s> but was <%s>", expectedOwnerId, actual.owner.id)
        }
        myself
    }
}

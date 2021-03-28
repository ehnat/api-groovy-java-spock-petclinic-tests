package com.petclinic.assertions

import com.petclinic.dto.Vet
import org.assertj.core.api.*

class VetAssert extends AbstractAssert<VetAssert, Vet> {

    VetAssert(Vet actual) {
        super(actual, VetAssert.class)
    }

    VetAssert hasFirstName(String expectedFirstName) {
        isNotNull()
        if (expectedFirstName != actual.firstName) {
            failWithMessage("Expected vet's first name: <%s> but was <%s>", expectedFirstName, actual.firstName)
        }
        myself
    }

    VetAssert hasId(Integer expectedId) {
        isNotNull()
        if (expectedId != actual.id) {
            failWithMessage("Expected vet's id: <%s> but was <%s>", expectedId, actual.id)
        }
        myself
    }
}

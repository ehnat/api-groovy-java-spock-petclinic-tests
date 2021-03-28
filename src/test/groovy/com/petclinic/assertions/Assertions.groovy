package com.petclinic.assertions

import com.petclinic.dto.Pet
import com.petclinic.dto.Vet

class Assertions {

    static PetAssert assertThat(Pet actual) {
        new PetAssert(actual)
    }

    static VetAssert assertThat(Vet actual) {
        new VetAssert(actual)
    }
}

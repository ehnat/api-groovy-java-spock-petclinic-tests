package com.petclinic.spec.basic

import com.petclinic.common.testgroups.Regression
import com.petclinic.common.testgroups.Smoke
import com.petclinic.dto.Pet
import com.petclinic.services.PetService
import com.petclinic.spec.BaseSpec
import groovy.util.logging.Slf4j
import org.junit.experimental.categories.Category

import static com.petclinic.assertions.Assertions.assertThat
import static com.petclinic.databuilders.PetCreator.samplePetRequest

@Slf4j //for java use lombok annotation
@Category(Regression)
class PetSpec extends BaseSpec {

    @Category(Smoke)
    def 'should return all pets'() {
        when: 'request for getting all pets is sent'
        log.info("send request for get all pets")
        Pet[] allPets = PetService.getAllPets()

        then: 'all pets are returned'
        allPets.size() >= 0
    }

    def 'should add a new pet'() {
        given: 'a new pet sample'
        int initialPetAmounts = PetService.getAllPets().size()
        Pet petRequest = samplePetRequest()

        when: 'request for adding pet is sent'
        Pet addedPet = PetService.addPet(petRequest)

        then: 'pet is created'
        assertThat(addedPet)
                .hasName(petRequest.name)
                .hasOwnerId(petRequest.owner.id)

        and: 'pets amount increases'
        int actualPetsAmount = PetService.getAllPets().size()
        actualPetsAmount == initialPetAmounts + 1
    }
}

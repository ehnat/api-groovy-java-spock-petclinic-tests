package com.petclinic.spec.basic

import com.petclinic.common.testgroups.Regression
import com.petclinic.common.testgroups.Smoke
import com.petclinic.dto.PetType
import com.petclinic.services.PetService
import com.petclinic.spec.BaseSpec
import org.junit.experimental.categories.Category
import spock.lang.Unroll

@Category(Regression)
class PetTypeSpec extends BaseSpec {

    @Unroll
    @Category(Smoke)
    def 'should return pet type = #expectedPetTypeName'() {
        when: 'request for getting pet type is sent'
        PetType petType = PetService.getPetType(petId)

        then: 'expected pet type is returned'
        petType.name == expectedPetTypeName

        where:
        petId || expectedPetTypeName
        1     || 'cat'
        2     || 'dog'
        3     || 'lizard'
        4     || 'snake'
        5     || 'bird'
        6     || 'hamster'
    }
}

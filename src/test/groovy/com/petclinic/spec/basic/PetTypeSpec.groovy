package com.petclinic.spec.basic

import com.petclinic.common.testgroups.Regression
import com.petclinic.common.testgroups.Smoke
import com.petclinic.dto.PetType
import com.petclinic.spec.BaseSpec
import org.junit.experimental.categories.Category
import spock.lang.Unroll

import static com.petclinic.common.OperatingOnPetclinicLibActions.petService

@Category(Regression)
class PetTypeSpec extends BaseSpec {

    @Unroll
    @Category(Smoke)
    def 'should return pet type = #expectedPetTypeName'() {
        when: 'request for getting pet type is sent'
        PetType petType = petService.getPetType(petTypeId)

        then: 'expected pet type is returned'
        petType.name == expectedPetTypeName

        where:
        petTypeId || expectedPetTypeName
        1         || 'cat'
        2         || 'dog'
        3         || 'lizard'
        4         || 'snake'
        5         || 'bird'
        6         || 'hamster'
    }
}

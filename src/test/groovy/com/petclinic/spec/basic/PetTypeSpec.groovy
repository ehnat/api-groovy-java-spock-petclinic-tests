package com.petclinic.spec.basic

import com.petclinic.common.testgroups.Regression
import com.petclinic.common.testgroups.Smoke
import com.petclinic.dto.PetType
import com.petclinic.services.PetService
import com.petclinic.spec.BaseSpec
import spock.lang.Unroll

@Regression
class PetTypeSpec extends BaseSpec {

    @Unroll
    @Smoke
    def 'should return pet type = #expectedPetTypeName'() {
        when: 'request for getting pet type is sent'
        PetType petType = PetService.getPetType(petTypeId)

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

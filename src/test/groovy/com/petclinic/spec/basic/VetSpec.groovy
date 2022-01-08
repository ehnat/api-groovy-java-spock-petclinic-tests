package com.petclinic.spec.basic

import com.petclinic.common.testgroups.Regression
import com.petclinic.common.testgroups.Smoke
import com.petclinic.dto.Vet
import com.petclinic.spec.BaseSpec
import org.junit.experimental.categories.Category
import spock.lang.Unroll

import static com.petclinic.assertions.Assertions.assertThat
import static com.petclinic.common.OperatingOnPetclinicLibActions.vetService

@Category([Smoke, Regression])
class VetSpec extends BaseSpec {

    def 'should return all vets'() {
        when: 'request for getting all vets is sent'
        Vet[] allVets = vetService.getAllVets()

        then: 'all vets are returned'
        allVets.size() == 6
    }

    @Unroll
    def 'should return vet = #vetId'() {
        when: 'request for getting vet=#vetId is sent'
        Vet returnedVet = vetService.getVet(vetId as int)

        then: 'data for vet is returned'
        assertThat(returnedVet)
                .hasId(vetId)
                .hasFirstName(expectedFirstName)

        where:
        vetId || expectedFirstName
        1     || 'James'
        3     || 'Linda'
    }
}

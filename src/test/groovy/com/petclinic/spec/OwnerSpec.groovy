package com.petclinic.spec

import com.petclinic.common.testgroups.Regression
import com.petclinic.common.testgroups.Smoke
import com.petclinic.dto.Owner
import com.petclinic.services.OwnerService
import org.junit.experimental.categories.Category
import spock.lang.Unroll

import static com.petclinic.databuilders.OwnerCreator.sampleOwnerRequest

@Category(Regression)
class OwnerSpec extends BaseSpec {

    @Category(Smoke)
    def 'should return all owners'() {
        when: 'request for getting all owners is sent'
        Owner[] allOwners = OwnerService.getAllOwners()

        then: 'all owners are returned'
        allOwners.size() > 0
    }

    @Unroll
    @Category(Smoke)
    def 'should return owner=#ownerId'() {
        when: 'request for getting owner=#ownerId is sent'
        Owner owner = OwnerService.getOwner(ownerId)

        then: 'data for owner is returned'
        owner.id == ownerId
        owner.firstName == expectedFirstName

        where:
        ownerId || expectedFirstName
        1       || 'George'
        3       || 'Eduardo'
    }

    def 'should add a new owner'() {
        given: 'owner request'
        Owner ownerRequest = sampleOwnerRequest([
                firstName: 'Max'
        ])

        when: 'request for adding new owner is sent'
        Owner addedOwner = OwnerService.addOwner(ownerRequest)

        then: 'new owner is added'
        addedOwner.firstName == ownerRequest.firstName
    }
}

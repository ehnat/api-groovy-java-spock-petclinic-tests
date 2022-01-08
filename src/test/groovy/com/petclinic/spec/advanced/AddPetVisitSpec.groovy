package com.petclinic.spec.advanced

import com.petclinic.common.testgroups.Regression
import com.petclinic.dto.Owner
import com.petclinic.dto.Pet
import com.petclinic.dto.Visit
import com.petclinic.spec.BaseSpec
import org.junit.experimental.categories.Category

import static com.petclinic.common.OperatingOnPetclinicLibActions.ownerService
import static com.petclinic.common.OperatingOnPetclinicLibActions.petService
import static com.petclinic.common.OperatingOnPetclinicLibActions.visitService
import static com.petclinic.databuilders.OwnerCreator.sampleOwnerRequest
import static com.petclinic.databuilders.PetCreator.samplePetRequest
import static com.petclinic.databuilders.VisitCreator.sampleVisitRequest

@Category(Regression)
class AddPetVisitSpec extends BaseSpec {
    private static final int INITIAL_VISITS_AMOUNT = visitService.getAllVisits().size()

    def 'new visit should be scheduled for new pet'() {
        given: 'owner is added to database'
        Owner newOwner = ownerService.addOwner(ownerRequest())

        and: 'his pet is added to database'
        Pet newPet = petService.addPet(petRequest(newOwner))

        when: 'visit for this pet is scheduled'
        Visit newVisit = visitService.addVisit(visitRequest(newPet))

        then: 'visit is added to database'
        newVisit.pet.id == newPet.id
        newVisit.pet.owner.id == newOwner.id

        and: 'visits amount increases'
        visitService.getAllVisits().size() == INITIAL_VISITS_AMOUNT + 1
    }

    private static Owner ownerRequest() {
        sampleOwnerRequest(
                [
                        firstName: 'Jan',
                        lastName : 'Kowalski',
                        address  : 'Nowa Street',
                        city     : 'Cracow',
                        telephone: '111222333'
                ])
    }

    Pet petRequest(Owner owner) {
        samplePetRequest(
                [
                        birthDate: "2021/01/01",
                        name     : 'Rex',
                        owner    : owner,
                        type     : petService.getPetType(2),
                ])
    }

    Visit visitRequest(Pet pet) {
        sampleVisitRequest(
                [
                        date       : "2010/01/20",
                        description: 'Rex has a problem with his skin',
                        pet        : pet
                ]
        )
    }
}

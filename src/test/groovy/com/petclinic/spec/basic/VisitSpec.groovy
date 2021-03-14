package com.petclinic.spec.basic

import com.petclinic.common.testgroups.Regression
import com.petclinic.common.testgroups.Smoke
import com.petclinic.dto.Visit
import com.petclinic.services.VisitService
import com.petclinic.spec.BaseSpec
import org.junit.experimental.categories.Category
import spock.lang.Unroll

import static com.petclinic.databuilders.VisitCreator.sampleVisitRequest

@Category(Regression)
class VisitSpec extends BaseSpec {

    @Category(Smoke)
    def 'should return all visits'() {
        when: 'request for getting all visits is sent'
        Visit[] allVisits = VisitService.getAllVisits()

        then: 'all visits are returned'
        allVisits.size() >= 0
    }

    @Unroll
    @Category(Smoke)
    def 'should return visit=#visitId'() {
        when: 'request for getting visit=#visitId is sent'
        Visit returnedVisit = VisitService.getVisit(visitId as int)

        then: 'data for vet is returned'
        returnedVisit.id == visitId
        returnedVisit.description == expectedDescription

        where:
        visitId || expectedDescription
        1       || 'rabies shot'
        3       || 'neutered'
    }

    def 'should add a new visit'() {
        given: 'a new visit sample'
        int initialVisitAmounts = VisitService.getAllVisits().size()
        Visit visitRequest = sampleVisitRequest()

        when: 'request for adding visit is sent'
        Visit createdVisit = VisitService.addVisit(visitRequest)

        then: 'visit is created'
        createdVisit.description == visitRequest.description
        createdVisit.pet.id == visitRequest.pet.id

        and: 'visits amount increases'
        int actualVisitsAmount = VisitService.getAllVisits().size()
        actualVisitsAmount == initialVisitAmounts + 1
    }
}

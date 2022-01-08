package com.petclinic.common

import com.petclinic.PetClinicService
import com.petclinic.PetClinicServiceFactory
import com.petclinic.config.PetClinicApiConfig
import com.petclinic.services.OwnerService
import com.petclinic.services.PetService
import com.petclinic.services.VetService
import com.petclinic.services.VisitService

import static com.petclinic.config.TestConfig.getEnvConfig

class OperatingOnPetclinicLibActions {

    private static final PetClinicApiConfig PET_CLINIC_API_CONFIG = PetClinicApiConfig.builder()
            .baseUrl(envConfig.baseUrl())
            .build()

    private static final PetClinicService PET_CLINIC_SERVICE = PetClinicServiceFactory.defaultService(PET_CLINIC_API_CONFIG)

    static OwnerService getOwnerService() {
        PET_CLINIC_SERVICE.getOwnerService()
    }

    static PetService getPetService() {
        PET_CLINIC_SERVICE.getPetService()
    }

    static VetService getVetService() {
        PET_CLINIC_SERVICE.getVetService()
    }

    static VisitService getVisitService() {
        PET_CLINIC_SERVICE.getVisitService()
    }
}

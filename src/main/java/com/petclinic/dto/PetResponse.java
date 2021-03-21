package com.petclinic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetResponse {

    private int id;
    private String name;
    private String birthDate;
    private PetType type;
    @JsonProperty("owner")
    private int ownerId;
    private List<VisitResponse> visits;
}

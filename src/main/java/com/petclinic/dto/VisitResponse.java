package com.petclinic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitResponse {

    private int id;
    private String date; //example: yyyy/MM/dd
    private String description;
    @JsonProperty("pet")
    private int petId;
}

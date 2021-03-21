package com.petclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    private int id;
    private String name;
    private String birthDate;
    private PetType type;
    private Owner owner;
    private List<VisitResponse> visits;
}

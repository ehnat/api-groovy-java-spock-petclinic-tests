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
public class Vet {

    private int id;
    private String firstName;
    private String lastName;
    private List<Specialty> specialties;
}

package com.capstone.diary.pet.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class PetUpdateDto {
    private String name;
    private String profile;
    private String gender;
    private LocalDate adoptionDate;
    private LocalDate birthDate;
    private Double weight;
    private List<String> images;
    private List<Long> deletedImageIds;
}

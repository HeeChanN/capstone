package com.capstone.diary.pet.dto;


import com.capstone.diary.image.Image;
import com.capstone.diary.pet.Pet;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class PetResDto {

    private Long id;
    private String name;
    private String profile;
    private String gender;
    private LocalDate adoptionDate;
    private LocalDate birthDate;
    private Double weight;
    private List<String> images;

    public PetResDto(Pet pet) {
        this.id = pet.getId();
        this.name = pet.getName();
        this.profile = pet.getProfile();
        this.gender = pet.getGender();
        this.adoptionDate = pet.getAdoptionDate();
        this.birthDate =pet.getBirthDate();
        this.weight = pet.getWeight();
        this.images = pet.getImages().stream().map(Image::getImage).toList();
    }
}

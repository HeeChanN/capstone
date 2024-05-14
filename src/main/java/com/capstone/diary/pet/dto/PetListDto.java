package com.capstone.diary.pet.dto;


import com.capstone.diary.pet.Pet;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PetListDto {
    private Long petId;
    private String profile;
    private String name;

    public PetListDto(Pet pet) {
        this.petId = pet.getId();
        this.profile = pet.getProfile();
        this.name = pet.getName();
    }
}

package com.capstone.diary.pet.service;


import com.capstone.diary.pet.dto.PetCreateDto;
import com.capstone.diary.pet.dto.PetListDto;
import com.capstone.diary.pet.dto.PetResDto;
import com.capstone.diary.pet.dto.PetUpdateDto;

import java.util.List;

public interface PetService {
    public PetResDto createPet(Long memberId, PetCreateDto petCreateDto);
    public PetResDto updatePet(Long petId, PetUpdateDto petUpdateDto);
    public List<PetListDto> getAllPets(Long memberId);
}

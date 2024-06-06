package com.capstone.diary.pet.controller;

import com.capstone.diary.pet.Pet;
import com.capstone.diary.pet.dto.PetCreateDto;
import com.capstone.diary.pet.dto.PetResDto;
import com.capstone.diary.pet.dto.PetUpdateDto;
import com.capstone.diary.pet.service.PetService;
import com.capstone.diary.pet.swagger.PetCreateApi;
import com.capstone.diary.pet.swagger.PetUpdateApi;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pets")
@Tag(name = "Pet APi", description = "반려 동물 API")
public class PetController {
    private final PetService petService;

    @PostMapping
    @PetCreateApi
    public PetResDto createPet(@RequestParam("memberId") Long memberId, @RequestBody PetCreateDto petCreateDto) {
        return petService.createPet(memberId, petCreateDto);
    }

    @PetUpdateApi
    @PatchMapping("/{petId}")
    public PetResDto updatePet(@PathVariable("petId") Long petId, @RequestBody PetUpdateDto petUpdateDto) {
        return petService.updatePet(petId, petUpdateDto);
    }

    @GetMapping("/{petId}")
    public PetResDto getPet(@PathVariable("petId") Long petId) {
        return petService.getPet(petId);
    }
}

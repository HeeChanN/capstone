package com.capstone.diary.home;

import com.capstone.diary.home.swagger.PetGetsApi;
import com.capstone.diary.pet.dto.PetListDto;
import com.capstone.diary.pet.service.PetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "Setting API", description = "환경설정 관련 API")
public class HomeController {
    private final PetService petService;

    @GetMapping("/{memberId}/setting")
    @PetGetsApi
    public List<PetListDto> getPetList(@PathVariable Long memberId){
        return petService.getAllPets(memberId);
    }
}

package com.capstone.diary.emotion;



import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class EmotionController {
    private final EmotionService emotionService;

    @GetMapping("/api/emotions")
    @SecurityRequirement(name = "bearerAuth")
    public EmotionDto getActions(@RequestParam("petId") Long petId,
                                @RequestParam("date") LocalDate date) {
        return emotionService.getActions(petId, date);
    }
}

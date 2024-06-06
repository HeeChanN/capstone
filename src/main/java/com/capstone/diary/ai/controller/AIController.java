package com.capstone.diary.ai.controller;


import com.capstone.diary.ai.service.AIService;
import com.capstone.diary.ai.dto.AIMessageDto;
import com.capstone.diary.ai.swagger.AIMessageCreateApi;
import com.capstone.diary.ai.swagger.AIMessageGetApi;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ai")
@Slf4j
@Tag(name = "AI API", description = "AI 분석 결과를 가져오는 API")
public class AIController {

    private final AIService aiService;

    @AIMessageCreateApi
    @PostMapping("/message")
    public String sendMessage(@RequestBody AIMessageDto aiMessageDto) {
        return aiService.sendMessage(aiMessageDto);
    }

    @AIMessageGetApi
    @GetMapping("/message")
    public AIMessageDto getMessage(@RequestParam("petId") Long petId,
                                   @RequestParam("date") LocalDate date) {
        return aiService.getDiary(petId,date);
    }
}

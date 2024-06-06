package com.capstone.diary.action;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ActionController {
    private final ActionService actionService;

    @GetMapping("/api/actions")
    @SecurityRequirement(name = "bearerAuth")
    public ActionDto getActions(@RequestParam("petId") Long petId,
                                @RequestParam("date") LocalDate date) {
        return actionService.getActions(petId, date);
    }

}

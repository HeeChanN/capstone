package com.capstone.diary.ai.dto;


import com.capstone.diary.ai.AI;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
public class AIMessageDto {
    private String message;
    private LocalDateTime dateTime;

    public AIMessageDto(AI ai) {
        this.message = ai.getMessage();
        this.dateTime = ai.getDateTime();
    }
}

package com.capstone.diary.ai.dto;


import com.capstone.diary.ai.AI;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@ToString
public class AIMessageDto {
    private String message;
    private LocalDate dateTime;

    public AIMessageDto(AI ai) {
        this.message = ai.getMessage();
        this.dateTime = ai.getDate();
    }
}

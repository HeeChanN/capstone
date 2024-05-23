package com.capstone.diary.ai;


import com.capstone.diary.ai.dto.AIMessageDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class AI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private LocalDateTime dateTime;

    public AI(AIMessageDto aiMessageDto) {
        this.message = aiMessageDto.getMessage();
        this.dateTime = aiMessageDto.getDateTime();
    }
}

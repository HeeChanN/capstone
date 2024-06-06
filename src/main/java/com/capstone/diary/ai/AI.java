package com.capstone.diary.ai;


import com.capstone.diary.ai.dto.AIMessageDto;
import com.capstone.diary.pet.Pet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class AI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petId")
    private Pet pet;

    public AI(AIMessageDto aiMessageDto) {
        this.message = aiMessageDto.getMessage();
        this.date = aiMessageDto.getDateTime();
    }
}

package com.capstone.diary.emotion;


import com.capstone.diary.pet.Pet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class Emotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private Integer happy;
    private Integer sad;
    private Integer angry;
    private Integer relaxed;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petId")
    private Pet pet;

    public Emotion(LocalDate date, Pet pet) {
        this.date = date;
        this.pet = pet;
        this.happy = 0;
        this.sad = 0;
        this.angry = 0;
        this.relaxed = 0;
    }
}

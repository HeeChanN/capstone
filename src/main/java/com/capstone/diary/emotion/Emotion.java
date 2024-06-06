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

    private Integer happinessJoy;
    private Integer comfortStability;
    private Integer anxietySadness;
    private Integer angerDispleasure;
    private Integer fear;
    private Integer aggression;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petId")
    private Pet pet;

    public Emotion(LocalDate date, Pet pet) {
        this.date = date;
        this.pet = pet;
        this.happinessJoy = 0;
        this.comfortStability = 0;
        this.anxietySadness = 0;
        this.angerDispleasure = 0;
        this.fear = 0;
        this.aggression = 0;
    }
}

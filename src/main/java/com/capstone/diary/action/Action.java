package com.capstone.diary.action;


import com.capstone.diary.pet.Pet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private Integer bodyLower;
    private Integer bodyScratch;
    private Integer bodyShake;
    private Integer feetUp;
    private Integer footUp;
    private Integer heading;
    private Integer lying;
    private Integer mounting;
    private Integer sit;
    private Integer tailing;
    private Integer tailLow;
    private Integer turn;
    private Integer walkRun;

    public Action(LocalDate date, Pet pet) {
        this.date = date;
        this.bodyLower = 0;
        this.bodyScratch = 0;
        this.bodyShake = 0;
        this.feetUp = 0;
        this.footUp = 0;
        this.heading = 0;
        this.lying = 0;
        this.mounting = 0;
        this.sit = 0;
        this.tailing = 0;
        this.tailLow = 0;
        this.turn = 0;
        this.walkRun = 0;
        this.pet = pet;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petId")
    private Pet pet;
}

package com.capstone.diary.emotion;

import com.capstone.diary.action.Action;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class EmotionDto {
    private LocalDate date;

    private Integer happinessJoy;
    private Integer comfortStability;
    private Integer anxietySadness;
    private Integer angerDispleasure;
    private Integer fear;
    private Integer aggression;

    public EmotionDto(Emotion emotion) {
        this.date = emotion.getDate();
        this.happinessJoy = emotion.getHappinessJoy();
        this.comfortStability = emotion.getComfortStability();
        this.anxietySadness = emotion.getAnxietySadness();
        this.angerDispleasure = emotion.getAngerDispleasure();
        this.fear = emotion.getFear();
        this.aggression = emotion.getAggression();
    }
}

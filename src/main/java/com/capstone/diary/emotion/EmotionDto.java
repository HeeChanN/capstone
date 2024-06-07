package com.capstone.diary.emotion;

import com.capstone.diary.action.Action;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class EmotionDto {
    private LocalDate date;

    private Integer happy;
    private Integer sad;
    private Integer angry;
    private Integer relaxed;

    public EmotionDto(Emotion emotion) {
        this.date = emotion.getDate();
        this.happy = emotion.getHappy();
        this.sad = emotion.getSad();
        this.angry = emotion.getAngry();
        this.relaxed = emotion.getRelaxed();
    }
}

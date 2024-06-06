package com.capstone.diary.action;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ActionDto {
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


    public ActionDto(Action action) {
        this.date = action.getDate();
        this.bodyLower = action.getBodyLower();
        this.bodyScratch = action.getBodyScratch();
        this.bodyShake = action.getBodyShake();
        this.feetUp = action.getFeetUp();
        this.footUp = action.getFootUp();
        this.heading = action.getHeading();
        this.lying = action.getLying();
        this.mounting = action.getMounting();
        this.sit = action.getSit();
        this.tailing = action.getTailing();
        this.tailLow = action.getTailLow();
        this.turn = action.getTurn();
        this.walkRun = action.getWalkRun();
    }
}

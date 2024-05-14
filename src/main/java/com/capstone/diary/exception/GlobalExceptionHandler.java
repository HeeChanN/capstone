package com.capstone.diary.exception;


import com.capstone.diary.exception.common.DuplicatedDataException;
import com.capstone.diary.exception.common.NoDataInDatabaseException;
import com.capstone.diary.exception.common.WrongDataException;
import com.capstone.diary.member.exception.NoMatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicatedDataException.class)
    public ResponseEntity<String> handleDuplicatedElement(DuplicatedDataException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(WrongDataException.class)
    public ResponseEntity<String> handleWrongElement(WrongDataException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    @ExceptionHandler(NoDataInDatabaseException.class)
    public ResponseEntity<String> handleWrongElement(NoDataInDatabaseException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage()+"를 찾을 수 없습니다.");
    }

    @ExceptionHandler(NoMatchException.class)
    public ResponseEntity<String> handleNoMatchElement(NoMatchException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
}

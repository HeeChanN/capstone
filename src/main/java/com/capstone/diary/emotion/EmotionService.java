package com.capstone.diary.emotion;



import com.capstone.diary.exception.common.NoDataInDatabaseException;
import com.capstone.diary.pet.Pet;
import com.capstone.diary.pet.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EmotionService {
    private final EmotionRepository emotionRepository;
    private final PetRepository petRepository;

    public EmotionDto getActions(Long petId, LocalDate date) {
        Pet pet = petRepository.findById(petId).orElseThrow(()->new NoDataInDatabaseException("애완동물"));

        if(!emotionRepository.existsByPetAndDate(pet,date)) {
            return new EmotionDto(emotionRepository.save(new Emotion(date,pet)));
        }
        else {
            return new EmotionDto(emotionRepository.findByPetAndDate(pet,date).orElseThrow(()-> new NoDataInDatabaseException("감정정보")));
        }
    }
}

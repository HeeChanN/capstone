package com.capstone.diary.action;


import com.capstone.diary.exception.common.NoDataInDatabaseException;
import com.capstone.diary.pet.Pet;
import com.capstone.diary.pet.repository.PetRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActionService {

    private final ActionRepository actionRepository;
    private final PetRepository petRepository;

    public ActionDto getActions(Long petId, LocalDate date) {
        Pet pet = petRepository.findById(petId).orElseThrow(()-> new NoDataInDatabaseException("애완동물"));
        if(!actionRepository.existsByPetAndDate(pet,date)) {
            return new ActionDto(actionRepository.save(new Action(date,pet)));
        }
        else {
            return new ActionDto(actionRepository.findByPetAndDate(pet,date).orElseThrow(()-> new NoDataInDatabaseException("행동정보")));
        }
    }
}

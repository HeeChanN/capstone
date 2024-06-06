package com.capstone.diary.emotion;

import com.capstone.diary.action.Action;
import com.capstone.diary.pet.Pet;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface EmotionRepository extends CrudRepository<Emotion, Long> {
    boolean existsByPetAndDate(Pet pet, LocalDate date);

    Optional<Emotion> findByPetAndDate(Pet pet, LocalDate date);
}

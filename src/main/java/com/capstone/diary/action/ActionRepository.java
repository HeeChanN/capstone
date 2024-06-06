package com.capstone.diary.action;

import com.capstone.diary.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ActionRepository extends JpaRepository<Action, Long> {
    boolean existsByPetAndDate(Pet pet, LocalDate date);

    Optional<Action> findByPetAndDate(Pet pet, LocalDate date);
}


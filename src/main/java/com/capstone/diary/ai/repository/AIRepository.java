package com.capstone.diary.ai.repository;

import com.capstone.diary.ai.AI;
import com.capstone.diary.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public interface AIRepository extends JpaRepository<AI, Long> {
    Optional<AI> findByPetAndDate(Pet pet, LocalDate date);
}

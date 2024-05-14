package com.capstone.diary.pet.repository;


import com.capstone.diary.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet,Long> {
    List<Pet> findAllByMemberId(Long memberId);
}

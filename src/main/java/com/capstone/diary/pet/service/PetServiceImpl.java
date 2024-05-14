package com.capstone.diary.pet.service;


import com.capstone.diary.exception.common.NoDataInDatabaseException;
import com.capstone.diary.image.Image;
import com.capstone.diary.image.ImageRepository;
import com.capstone.diary.member.repository.MemberRepository;
import com.capstone.diary.pet.Pet;
import com.capstone.diary.pet.dto.PetCreateDto;
import com.capstone.diary.pet.dto.PetListDto;
import com.capstone.diary.pet.dto.PetResDto;
import com.capstone.diary.pet.dto.PetUpdateDto;
import com.capstone.diary.pet.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final MemberRepository memberRepository;
    private final ImageRepository imageRepository;


    public PetResDto createPet(Long memberId, PetCreateDto petCreateDto) throws NoDataInDatabaseException {
        Pet pet = new Pet(petCreateDto,memberRepository.findById(memberId).orElseThrow(()->new NoDataInDatabaseException("유저정보")));
        pet.setImages(petCreateDto.getImages().stream().map(Image::new).toList());
        return new PetResDto(petRepository.save(pet));
    }

    @Transactional
    public PetResDto updatePet(Long petId, PetUpdateDto petUpdateDto) {
        Pet pet = petRepository.findById(petId).orElseThrow(() -> new NoDataInDatabaseException("반려동물"));
        pet.removeImages(imageRepository.findByIdIn(petUpdateDto.getDeletedImageIds()));
        pet.updatePet(petUpdateDto);
        return new PetResDto(pet);
    }

    @Override
    public List<PetListDto> getAllPets(Long memberId) {
        return petRepository.findAllByMemberId(memberId).stream().map(PetListDto::new).toList();
    }
}

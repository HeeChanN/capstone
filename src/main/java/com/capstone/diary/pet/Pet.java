package com.capstone.diary.pet;

import com.capstone.diary.image.Image;
import com.capstone.diary.member.Member;
import com.capstone.diary.pet.dto.PetCreateDto;
import com.capstone.diary.pet.dto.PetUpdateDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String profile;
    private String gender;
    private LocalDate adoptionDate;
    private LocalDate birthDate;
    private Double weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    @OneToMany(mappedBy = "pet",fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval = true)
    private List<Image> images = new ArrayList<>();

    public Pet(PetCreateDto petCreateDto, Member member) {
        this.name = petCreateDto.getName();
        this.profile = petCreateDto.getProfile();
        this.gender = petCreateDto.getGender();
        this.adoptionDate = petCreateDto.getAdoptionDate();
        this.birthDate = petCreateDto.getBirthDate();
        this.weight = petCreateDto.getWeight();
        this.member = member;
    }

    public void updatePet(PetUpdateDto petUpdateDto){
        this.name = petUpdateDto.getName();
        this.profile = petUpdateDto.getProfile();
        this.gender = petUpdateDto.getGender();
        this.adoptionDate = petUpdateDto.getAdoptionDate();
        this.birthDate = petUpdateDto.getBirthDate();
        this.weight = petUpdateDto.getWeight();
        updateImages(petUpdateDto.getImages().stream().map(Image::new).toList());
    }

    public void setImages(List<Image> images) {
        this.images = images;
        images.forEach(o->o.setPet(this));
    }

    public void removeImages(List<Image> images) {
        this.images.removeAll(images);
    }

    public void updateImages(List<Image> images) {
        this.images.addAll(images);
        images.forEach(o->o.setPet(this));
    }

}

package com.shubham.toothlesspetclinic.services;

import com.shubham.toothlesspetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}

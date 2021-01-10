package com.shubham.toothlesspetclinic.repositories;

import com.shubham.toothlesspetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}

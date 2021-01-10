package com.shubham.toothlesspetclinic.repositories;

import com.shubham.toothlesspetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}

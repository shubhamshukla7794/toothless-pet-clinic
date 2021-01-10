package com.shubham.toothlesspetclinic.repositories;

import com.shubham.toothlesspetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}

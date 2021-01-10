package com.shubham.toothlesspetclinic.repositories;

import com.shubham.toothlesspetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}

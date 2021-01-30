package com.shubham.toothlesspetclinic.services;

import com.shubham.toothlesspetclinic.model.Owner;

import java.util.List;


public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}

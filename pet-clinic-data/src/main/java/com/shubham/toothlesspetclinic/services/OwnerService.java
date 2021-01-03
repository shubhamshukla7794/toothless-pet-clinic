package com.shubham.toothlesspetclinic.services;

import com.shubham.toothlesspetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}

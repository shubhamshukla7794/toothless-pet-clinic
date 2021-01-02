package com.shubham.toothlesspetclinic.services;

import com.shubham.toothlesspetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
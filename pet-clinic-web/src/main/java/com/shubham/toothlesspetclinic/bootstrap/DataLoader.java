//package com.shubham.toothlesspetclinic.bootstrap;
//
//import com.shubham.toothlesspetclinic.model.*;
//import com.shubham.toothlesspetclinic.services.*;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//
//    private final OwnerService ownerService;
//    private final VetService vetService;
//    private final PetTypeService petTypeService;
//    private final SpecialtyService specialtyService;
//    private final VisitService visitService;
//
//    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
//                      SpecialtyService specialtyService, VisitService visitService) {
//        this.ownerService = ownerService;
//        this.vetService = vetService;
//        this.petTypeService = petTypeService;
//        this.specialtyService = specialtyService;
//        this.visitService = visitService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        int count = petTypeService.findAll().size();
//
//        if (count == 0) {
//            loadData();
//        }
//    }
//
//    private void loadData() {
//        PetType dog = new PetType();
//        dog.setName("Dog");
//        PetType savedDogPetType = petTypeService.save(dog);
//
//        PetType owl = new PetType();
//        owl.setName("Owl");
//        PetType savedOwlPetType = petTypeService.save(owl);
//
//        Owner owner1 = new Owner();
//        owner1.setFirstName("Dean");
//        owner1.setLastName("Winchester");
//        owner1.setAddress("123 Super St.");
//        owner1.setCity("Lebanon");
//        owner1.setTelephone("7855550128");
//
//        Pet deansDog = new Pet();
//        deansDog.setPetType(savedDogPetType);
//        deansDog.setOwner(owner1);
//        deansDog.setBirthDate(LocalDate.now());
//        deansDog.setName("Miracle");
//        owner1.getPets().add(deansDog);
//
//        ownerService.save(owner1);
//
//        Owner owner2 = new Owner();
//        owner2.setFirstName("Harry");
//        owner2.setLastName("Potter");
//        owner2.setAddress("4 Private Drive");
//        owner2.setCity("London");
//        owner2.setTelephone("6054756961");
//
//        Pet harrysOwl = new Pet();
//        harrysOwl.setPetType(savedOwlPetType);
//        harrysOwl.setOwner(owner2);
//        harrysOwl.setBirthDate(LocalDate.now());
//        harrysOwl.setName("Hedwig");
//        owner2.getPets().add(harrysOwl);
//
//        ownerService.save(owner2);
//
//        Visit owlVisit = new Visit();
//        owlVisit.setPet(harrysOwl);
//        owlVisit.setDate(LocalDate.now());
//        owlVisit.setDescription("Sneezy Owl");
//
//        visitService.save(owlVisit);
//
//        System.out.println("Loaded Owners......");
//
//        Specialty radiology = new Specialty();
//        radiology.setDescription("Radiology");
//        Specialty savedRadiology = specialtyService.save(radiology);
//
//        Specialty surgery = new Specialty();
//        surgery.setDescription("Surgery");
//        Specialty savedSurgery = specialtyService.save(surgery);
//
//        Specialty dentistry = new Specialty();
//        dentistry.setDescription("Dentistry");
//        Specialty savedDentistry = specialtyService.save(dentistry);
//
//        Vet vet1 = new Vet();
//        vet1.setFirstName("Bobby");
//        vet1.setLastName("Singer");
//        vet1.getSpecialties().add(savedRadiology);
//
//        vetService.save(vet1);
//
//        Vet vet2 = new Vet();
//        vet2.setFirstName("Rubeus");
//        vet2.setLastName("Hagrid");
//        vet2.getSpecialties().add(savedSurgery);
//
//        vetService.save(vet2);
//
//        System.out.println("Loaded Vets......");
//    }
//}

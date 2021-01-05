package com.shubham.toothlesspetclinic.bootstrap;

import com.shubham.toothlesspetclinic.model.Owner;
import com.shubham.toothlesspetclinic.model.Vet;
import com.shubham.toothlesspetclinic.services.OwnerService;
import com.shubham.toothlesspetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Dean");
        owner1.setLastName("Winchester");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Harry");
        owner2.setLastName("Potter");

        ownerService.save(owner2);

        System.out.println("Loaded Owners......");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Bobby");
        vet1.setLastName("Singer");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Rubeus");
        vet2.setLastName("Hagrid");

        vetService.save(vet2);

        System.out.println("Loaded Vets......");
    }
}

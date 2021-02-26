package com.shubham.toothlesspetclinic.cache;

import com.shubham.toothlesspetclinic.services.VetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PetClinicIntegrationTest {

    @Autowired
    private VetService vetService;

    @Test
    void testCacheFindAll() {
        vetService.findAll();
        vetService.findAll(); //served from cache
    }
}

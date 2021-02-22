package com.shubham.toothlesspetclinic.controllers;

import com.shubham.toothlesspetclinic.model.Owner;
import com.shubham.toothlesspetclinic.model.Pet;
import com.shubham.toothlesspetclinic.model.PetType;
import com.shubham.toothlesspetclinic.services.PetService;
import com.shubham.toothlesspetclinic.services.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.HashSet;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VisitControllerTest {

    @Mock
    VisitService visitService;

    @Mock
    PetService petService;

    @InjectMocks
    VisitController visitController;

    MockMvc mockMvc;

    Owner owner = Owner.builder().id(1L).build();

    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();

        when(petService.findById(anyLong())).thenReturn(Pet.builder()
                .id(1L)
                .birthDate(LocalDate.now())
                .name("Pet")
                .visits(new HashSet<>())
                .owner(owner)
                .petType(PetType.builder().name("Dog").build())
                .build());

    }

    @Test
    void initNewVisitForm() throws Exception {
        mockMvc.perform(get("/owners/1/pets/1/visits/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("pet"))
                .andExpect(model().attributeExists("visit"))
                .andExpect(view().name("pets/createOrUpdateVisitForm"));
    }

    @Test
    void processNewVisitForm() throws Exception {

        mockMvc.perform(post("/owners/1/pets/1/visits/new")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("date","2021-02-22")
                .param("description", "Desc"))
                .andExpect(status().is3xxRedirection())
                .andExpect(model().attributeExists("pet"))
                .andExpect(model().attributeExists("visit"))
                .andExpect(view().name("redirect:/owners/1"));

        verify(visitService).save(any());
    }

    @Test
    void processNewVisitFormValidationFailed() throws Exception {
        mockMvc.perform(post("/owners/1/pets/1/visits/new").contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("pet"))
                .andExpect(model().attributeExists("visit"))
                .andExpect(view().name("pets/createOrUpdateVisitForm"));
    }
}
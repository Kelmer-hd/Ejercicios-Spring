package com.kelmerdev.service;

import com.kelmerdev.entities.Persona;

import java.util.List;

public interface IPersonService {

    void saveAll(List<Persona> personaList);
}

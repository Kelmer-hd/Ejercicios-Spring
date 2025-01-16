package com.kelmerdev.service;

import com.kelmerdev.entities.Persona;
import com.kelmerdev.persistence.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService{

    @Autowired
    private PersonDAO personDAO;

    @Override
    @Transactional
    public void saveAll(List<Persona> personaList) {
        personDAO.saveAll(personaList);
    }
}

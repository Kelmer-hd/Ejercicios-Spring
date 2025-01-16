package com.kelmerdev.persistence;

import com.kelmerdev.entities.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonDAO extends CrudRepository<Persona, Long> {
}

package com.asignatura.app.dao;

import com.asignatura.app.modelo.Asignatura;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IAsignaturaCrud extends CrudRepository<Asignatura, String> {
    Optional<Asignatura> findByNombre(String nombre);
}

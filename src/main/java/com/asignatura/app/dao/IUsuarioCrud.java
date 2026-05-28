package com.asignatura.app.dao;

import com.asignatura.app.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUsuarioCrud extends CrudRepository<Usuario, String> {
    Optional<Usuario> findByEmail(String email);
}

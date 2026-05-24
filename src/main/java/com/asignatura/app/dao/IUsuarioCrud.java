package com.asignatura.app.dao;

import com.asignatura.app.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioCrud extends CrudRepository<Usuario, String> {


}

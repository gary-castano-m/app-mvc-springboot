package com.asignatura.app.servicio;

import com.asignatura.app.dao.IAsignaturaCrud;
import com.asignatura.app.modelo.Asignatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AsignaturaServicioImp implements IAsignaturaServicio {
    @Autowired
    IAsignaturaCrud crudAsignatura;

    @Transactional(readOnly = true)
    @Override
    public List<Asignatura> listarAsignaturas() {
        return (List<Asignatura>) crudAsignatura.findAll();
    }

    @Transactional
    @Override
    public void guardarAsignatura(Asignatura asignatura) {
        crudAsignatura.save(asignatura);
    }

    @Transactional
    @Override
    public void eliminar(Asignatura asignatura) {
        crudAsignatura.delete(asignatura);
    }

    @Transactional
    @Override
    public Asignatura buscar(Asignatura asignatura) {
        return crudAsignatura.findById(asignatura.getId()).orElse(null);
    }
}

package com.asignatura.app.servicio;

import com.asignatura.app.modelo.Asignatura;

import java.util.List;

public interface IAsignaturaServicio {
    public List<Asignatura> listarAsignaturas();
    public void guardarAsignatura(Asignatura asignatura);
    public void eliminar(Asignatura asignatura);
    public Asignatura buscar(Asignatura asignatura);
}
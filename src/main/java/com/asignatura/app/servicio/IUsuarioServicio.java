package com.asignatura.app.servicio;

import com.asignatura.app.modelo.Usuario;

import java.util.List;

public interface IUsuarioServicio {
    public List<Usuario>listarUsuarios();
    public void guardarUsuario(Usuario user);
    public void eliminar (Usuario user);
    public Usuario buscar (Usuario user);
}

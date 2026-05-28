package com.asignatura.app.servicio;

import com.asignatura.app.dao.IUsuarioCrud;
import com.asignatura.app.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioServicioImp implements IUsuarioServicio{
    @Autowired
    IUsuarioCrud crudUser;

    @Transactional (readOnly = true)
    @Override
    public List<Usuario> listarUsuarios(){
        return (List<Usuario>) crudUser.findAll();
    }
    @Transactional
    @Override
    public void guardarUsuario (Usuario user){
        crudUser.save(user);
    }

    @Transactional
    @Override
    public void eliminar(Usuario user) {
        crudUser.delete(user);
    }

    @Transactional
    @Override
    public Usuario buscar(Usuario user) {
        return crudUser.findById(user.getId()).orElse(null);
    }

    @Transactional
    public void eliminarUsuario (Usuario user){
        crudUser.delete(user);
    }

    @Transactional(readOnly = true)
    public Usuario buscarUsuario (Usuario user){
        return crudUser.findById(user.getCedula()).orElse(null);
    }
}

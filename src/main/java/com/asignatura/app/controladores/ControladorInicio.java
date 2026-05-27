package com.asignatura.app.controladores;

import com.asignatura.app.dao.IUsuarioCrud;
import com.asignatura.app.servicio.IUsuarioServicio;
import com.asignatura.app.servicio.UsuarioServicioImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.asignatura.app.modelo.Usuario;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    IUsuarioServicio userServicio;

    @GetMapping("/")
    public String inicio(Model modelo) {
        List<Usuario> listaUsuarios = (List<Usuario>) userServicio.listarUsuarios();
        modelo.addAttribute ("users", listaUsuarios);
        log.info("Ejecutando el contralodor Inicio MVC");
        return "index";
    }
    @GetMapping("/agregar")
    public String agregar(Usuario usuario){
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Usuario usuario){
        if (usuario.getId() == null || usuario.getId().isEmpty()){
            usuario.setId(UUID.randomUUID().toString());
        }
        userServicio.guardarUsuario(usuario);
        return "redirect:/";
    }

    @GetMapping("editar/{id}")
    public String editar(Usuario usuario, Model modelo){
        log.info("Invocando el metodo EDITAR ");
        usuario = userServicio.buscar(usuario);
        modelo.addAttribute("usuario", usuario);
        return "modificar";
    }

    @GetMapping("eliminar/{id}")
    public String eliminar(Usuario usuario) {
        userServicio.eliminar(usuario);
        return "redirect:/";
    }

}

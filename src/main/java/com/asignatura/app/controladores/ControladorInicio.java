package com.asignatura.app.controladores;

import com.asignatura.app.dao.IUsuarioCrud;
import com.asignatura.app.servicio.UsuarioServicioImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.asignatura.app.modelo.Usuario;

import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class ControladorInicio {
    @Autowired
    UsuarioServicioImp userServicio;

    @GetMapping("/")
    public String inicio(Model modelo) {
        List<Usuario> listaUsuarios = (List<Usuario>) userServicio.listarUsuarios();
        modelo.addAttribute ("users", listaUsuarios);
        log.info("Ejecutando el contralodor Inicio");
        return "index";
    }
}

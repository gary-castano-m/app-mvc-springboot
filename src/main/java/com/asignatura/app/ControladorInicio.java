package com.asignatura.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.asignatura.app.modelo.Usuario;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
public class ControladorInicio {
    @Value ("${index.mensaje}")
    String dato;
    @GetMapping("/")
    public String inicio(Model modelo) {
        String mensaje = "Saludos desde Spring MVC";
        modelo.addAttribute ("mensaje", mensaje);
        modelo.addAttribute ("dato", dato);
        Usuario u = new Usuario ();
        u.setCedula("123456789");
        u.setClave("Abcd");
        u.setNombre("GARY JOSE CASTAÑO MOLINA");
        u.setEmail("gcastanom@unicartagena.edu.co");
        modelo.addAttribute ("alguien", u);
        log.info("Ejecutando el contralodor Inicio");
        return "index";
    }
}

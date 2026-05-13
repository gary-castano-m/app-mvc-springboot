package com.asignatura.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        log.info("Ejecutando el contralodor Inicio");
        return "index";
    }
}

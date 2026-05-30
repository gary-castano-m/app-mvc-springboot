package com.asignatura.app.controladores;

import com.asignatura.app.modelo.Asignatura;
import com.asignatura.app.servicio.IAsignaturaServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
public class ControladorAsignatura {

    @Autowired
    IAsignaturaServicio asignaturaServicio;

    @GetMapping("/asignaturas")
    public String inicio(Model modelo) {
        List<Asignatura> listaAsignaturas = asignaturaServicio.listarAsignaturas();
        modelo.addAttribute("asignaturas", listaAsignaturas);
        log.info("Ejecutando el controlador de Asignaturas MVC");
        return "asignaturas/index";
    }

    @GetMapping("/asignaturas/agregar")
    public String agregar(Asignatura asignatura) {
        return "asignaturas/modificar";
    }

    @PostMapping("/asignaturas/guardar")
    public String guardar(Asignatura asignatura, Errors errors) {
        if (asignatura.getId() == null || asignatura.getId().isEmpty()) {
            asignatura.setId(UUID.randomUUID().toString());
        }

        if (errors.hasErrors()) {
            return "asignaturas/modificar";
        }

        asignaturaServicio.guardarAsignatura(asignatura);
        return "redirect:/asignaturas";
    }

    @GetMapping("/asignaturas/editar/{id}")
    public String editar(Asignatura asignatura, Model modelo) {
        asignatura = asignaturaServicio.buscar(asignatura);
        modelo.addAttribute("asignatura", asignatura);
        return "asignaturas/modificar";
    }

    @GetMapping("/asignaturas/eliminar")
    public String eliminar(Asignatura asignatura) {
        asignaturaServicio.eliminar(asignatura);
        return "redirect:/asignaturas";
    }
}
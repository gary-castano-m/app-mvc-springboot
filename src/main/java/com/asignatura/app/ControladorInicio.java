package com.asignatura.app;

import lombok.extern.slf4j.Slf4j;
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
    @Value ("${index.mensaje}")
    String dato;
    @GetMapping("/")
    public String inicio(Model modelo) {
        String mensaje = "Saludos desde Spring MVC";
        modelo.addAttribute ("mensaje", mensaje);
        modelo.addAttribute ("dato", dato);
        Usuario u1 = new Usuario ();
        u1.setCedula("123456789");
        u1.setClave("Abcd");
        u1.setNombre("GARY JOSE CASTAÑO MOLINA");
        u1.setEmail("gcastanom@unicartagena.edu.co");
        modelo.addAttribute ("alguien", u1);
        Usuario u2 = new Usuario ();
        u2.setCedula("45549964");
        u2.setClave("Vaya");
        u2.setNombre("YURIS MARCELA TOVAR DEL CASTILLO");
        u2.setEmail("cami041002@hotmail.com");
        Usuario u3 = new Usuario ();
        u3.setCedula("45471861");
        u3.setClave("Jack");
        u3.setNombre("JACKELIN MOLINA BELTRAN");
        u3.setEmail("jamobe27@hotmail.com");
        List<Usuario> listaUsuarios = Arrays.asList(u2, u3);
        modelo.addAttribute ("usuarios", listaUsuarios);
        log.info("Ejecutando el contralodor Inicio");
        return "index";
    }
}

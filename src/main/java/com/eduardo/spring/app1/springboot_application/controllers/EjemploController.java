package com.eduardo.spring.app1.springboot_application.controllers;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EjemploController {

    @GetMapping("/detalles_info")
    public String info(Map<String, Object> model) {
        model.put("titulo", "Servidor arriba");
        model.put("subtitulo", "Bienvenido a mi aplicación web con Spring Boot");
        model.put("presentacion", "Mi nombre es Eduardo y estoy aprendiendo Spring Boot");
        model.put("descripcion", "Este es un ejemplo de una aplicación web con Spring Boot");

        return "detalles_info";
    }
}

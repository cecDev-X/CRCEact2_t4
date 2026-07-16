package com.eduardo.spring.app1.springboot_application.controllers;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EjemploRESTController {

    @GetMapping("/detalles_info2")
    public Map<String, Object> detalles_info2() {
        Map<String, Object> respuesta = new java.util.HashMap<>();
        respuesta.put("titulo", "Servidor arriba");
        respuesta.put("subtitulo", "Bienvenido a mi aplicación web con Spring Boot");
        respuesta.put("presentacion", "Mi nombre es Eduardo y estoy aprendiendo Spring Boot");
        respuesta.put("descripcion", "Este es un ejemplo de una aplicación web con Spring Boot");

        return respuesta;
    }

    @GetMapping("/identidad")
    public Map<String, Object> identidad(){
        return Map.of("nombres", "Carlos Eduardo", "apellidos", "Castellanos Rios",
                "numeroControl", "23160863", "carrera", "Ingenieria en Sistemas Computacionales"
        );
    }

    @GetMapping("/gustos")
    public Map<String, Object> gustos(){
        return Map.of("gustos", new String[]{"Fresas con crema", "Escuchar música", "Ver películas", "Apostar a lo tonto $10 pesos"});
    }

    @GetMapping("/objetivos")
    public Map<String, Object> objetivos(){
        return Map.of("objetivos", new String[]{"Graduarme", "Encontrar un trabajo", "Viajar por el mundo", "Comprar una casa"});
    }
    
    
}

package com.eduardo.spring.app1.springboot_application.controllers;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.spring.app1.springboot_application.model.Empleado;

@RestController
@RequestMapping("/api")
public class EjemploRESTController {
    
    @GetMapping("/detalles_info2")
    public Map<String, Object> objetivos(){
        Empleado empleado = new Empleado("Carlos Eduardo", "Castellanos Rios", "carlos.eduardo@example.com", "Desarrollador", 25, 50000, 1);
     
        return Map.of("Empleado", empleado);
    }
    
    
}

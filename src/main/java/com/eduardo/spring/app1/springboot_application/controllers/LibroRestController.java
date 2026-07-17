package com.eduardo.spring.app1.springboot_application.controllers;

import com.eduardo.spring.app1.springboot_application.model.dto.LibrosDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/libros")
public class LibroRestController {

    // ==========================================
    // Endpoint POST (REST) que recibe el DTO y retorna JSON
    // URL de prueba: POST http://localhost:8080/api/libros
    // ==========================================
    @PostMapping
    public ResponseEntity<Map<String, Object>> registrarLibroRest(@RequestBody LibrosDTO nuevoLibroDto) {
        
        // Simulamos que procesamos el DTO
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("datosRecibidos", nuevoLibroDto); // Retorna el mismo DTO mapeado como JSON
        
        return ResponseEntity.status(201).body(respuesta);
    }
}
package com.eduardo.spring.app1.springboot_application.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eduardo.spring.app1.springboot_application.model.Libros;
import com.eduardo.spring.app1.springboot_application.model.dto.LibrosDTO;

@Controller
@RequestMapping("/libros")
public class LibroController {

    @Value("${mi.proyecto.nombre:Mi Biblioteca Spring}")
    private String nombreProyecto;

    private static final List<Libros> biblioteca = new ArrayList<>();

    static {
        biblioteca.add(new Libros("978-0132350884", "Clean Code", "Robert C. Martin", "Un manual de artesanía del software ágil.", 10, 350.0));
        biblioteca.add(new Libros("978-0201633610", "Design Patterns", "Erich Gamma", "Elementos de software de objetos reutilizables.", 5, 450.0));
    }

    @GetMapping("/lista")
    public String listarLibros(Model model) {
        // Pasamos el título del proyecto (leído con @Value)
        model.addAttribute("tituloProyecto", nombreProyecto);
        
        // Pasamos la lista de libros al modelo
        model.addAttribute("listaLibros", biblioteca);
        
        return "lista-libros"; // Nombre del archivo HTML (lista-libros.html)
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        // Pasamos un objeto DTO vacío para enlazar los campos del formulario
        model.addAttribute("libroDto", new LibrosDTO());
        return "formulario-libro"; // Nombre del archivo HTML (formulario-libro.html)
    }

    // b) Procesamiento del Formulario (POST)
    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute("libroDto") LibrosDTO libroDto, Model model) {
        Libros nuevoLibro = new Libros(
                libroDto.getIsbn(),
                libroDto.getNombre(),
                libroDto.getAutor(),
                libroDto.getDescripcion(),
                1, // Stock por defecto
                0.0 // Precio por defecto
        );
        biblioteca.add(nuevoLibro);
        
        return "redirect:/libros/lista";
    }
}
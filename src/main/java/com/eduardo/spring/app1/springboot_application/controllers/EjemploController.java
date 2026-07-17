package com.eduardo.spring.app1.springboot_application.controllers;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.eduardo.spring.app1.springboot_application.model.Empleado;


@Controller
public class EjemploController {

    @GetMapping("/detalles_info")
    public String info(Model model) {
        Empleado empleado = new Empleado("Carlos Eduardo", "Castellanos Rios", "carlos.eduardo@example.com", "Desarrollador", 25, 50000, 1);
        model.addAttribute("empleado", empleado);
        return "detalles_info";
    }

    @ModelAttribute("Empleado")
    public List<Empleado> ListaEmpleados(){
        return Arrays.asList(
            new Empleado("Edwin Alexis", "Esperanza Chavez", "guia@gmail.com","Dev Frontend", 21, 18000, 4),
            new Empleado("Angel Jahir", "Gomez Roblero", "jahir@byte.com", "Full Stack", 15, 12000, 2)
        );
    }
}

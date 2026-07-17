package com.eduardo.spring.app1.springboot_application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libros {
    private String isbn;
    private String nombre;
    private String autor;
    private String descripcion;
    private int stock;
    private double precio;
}

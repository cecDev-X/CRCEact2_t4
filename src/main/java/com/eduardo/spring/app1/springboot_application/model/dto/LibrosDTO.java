package com.eduardo.spring.app1.springboot_application.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibrosDTO {
    private String isbn;
    private String nombre;
    private String autor;
    private String descripcion;
}

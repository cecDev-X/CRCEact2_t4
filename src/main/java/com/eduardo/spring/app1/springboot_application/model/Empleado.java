package com.eduardo.spring.app1.springboot_application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empleado {
    private String nombre, apellido, email, puesto;
    private int edad, salario, id;
}

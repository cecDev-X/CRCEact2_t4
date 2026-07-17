package com.eduardo.spring.app1.springboot_application.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.spring.app1.springboot_application.model.dto.ParametroDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/parametros")
public class RequestParamControllers {

    @GetMapping("/detalle")
    public ParametroDTO detalle(@RequestParam(required = false) String informacion){
        ParametroDTO parametro1 = new ParametroDTO();
        parametro1.setInformacion(informacion);
        return parametro1;
    }
    
    
}

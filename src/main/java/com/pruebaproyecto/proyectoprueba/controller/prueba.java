package com.pruebaproyecto.proyectoprueba.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")

public class prueba {
    @GetMapping("")
    public String prueba_hola(){
        return "Hola sonsote";
    }
}
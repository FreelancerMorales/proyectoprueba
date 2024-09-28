package com.pruebaproyecto.proyectoprueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaproyecto.proyectoprueba.models.clientesModel;
import com.pruebaproyecto.proyectoprueba.service.clientesService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/clientes")

public class clientesController {
    @Autowired
    private clientesService cS;

    @GetMapping("/listar")
    public Iterable<clientesModel> getClientes() {
        return this.cS.findAll();
    }
    
}
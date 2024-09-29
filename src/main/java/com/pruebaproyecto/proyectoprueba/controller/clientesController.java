package com.pruebaproyecto.proyectoprueba.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaproyecto.proyectoprueba.models.clientesModel;
import com.pruebaproyecto.proyectoprueba.service.clientesService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/clientes")
@CrossOrigin //Para hacerlo publico

public class clientesController {
    @Autowired
    private clientesService cS;

    @GetMapping("/listar")
    public Iterable<clientesModel> getClientes() {
        return this.cS.findAll();
    }
    
    @GetMapping("/guardar")
    public ResponseEntity<String> saveClientes(@RequestBody clientesModel entity) {
        try {
            this.cS.save(entity);
            return ResponseEntity.ok("Cliente Guardado Correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el Servidor");
        }
    }

    @DeleteMapping("/eliminar/{idCliente}")
    public ResponseEntity<String> deleteClientes(@PathVariable int idCliente) {
        try {
            this.cS.deleteById(idCliente);
            return ResponseEntity.ok("Cliente Eliminado Correctamente");
        } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error en el Servidor");
        }
    }
    
    @PutMapping("/actualizar/{idClientes}")
    public ResponseEntity<String> updateClientes(@PathVariable int idClientes, @RequestBody clientesModel entity) {
        try {
            Optional<clientesModel> clienteOptional = this.cS.findById(idClientes);
            
            if (clienteOptional.isPresent()) {
                clientesModel clientesExistente = clienteOptional.get();
                
                clientesExistente.setNombre(entity.getNombre());
                clientesExistente.setApellido(entity.getApellido());
                
                this.cS.save(clientesExistente);
                
                return ResponseEntity.ok("Cliente Actualizado Correctamente");
            } else {
                return ResponseEntity.badRequest().body("Cliente no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el Servidor");
        }
    }
}
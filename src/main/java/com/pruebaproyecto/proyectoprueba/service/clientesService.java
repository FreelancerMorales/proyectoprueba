package com.pruebaproyecto.proyectoprueba.service;

import java.util.Optional;

import com.pruebaproyecto.proyectoprueba.common.CommonSvc;
import com.pruebaproyecto.proyectoprueba.models.clientesModel;

public interface clientesService extends CommonSvc<clientesModel>{
    public Iterable<clientesModel> findAll();
    public Optional<clientesModel>  findById(int id);
    public clientesModel findByNombre(String nombre);
    public clientesModel save(clientesModel entity);
    public void deleteById(int id);
    Iterable<clientesModel> saveAll(Iterable<clientesModel> entities);
}

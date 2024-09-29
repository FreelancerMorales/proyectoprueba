package com.pruebaproyecto.proyectoprueba.service;

import java.util.Optional;

import com.pruebaproyecto.proyectoprueba.common.CommonSvc;
import com.pruebaproyecto.proyectoprueba.models.productosModel;

public interface productosService extends CommonSvc<productosModel> {
    public Iterable<productosModel> findAll();
    public Optional<productosModel> findById(int id);
    public productosModel save(productosModel entity);
    public void deleteById(int id);
    Iterable<productosModel> saveAll(Iterable<productosModel> entities);
}

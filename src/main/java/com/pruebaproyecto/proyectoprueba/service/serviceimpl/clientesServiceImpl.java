package com.pruebaproyecto.proyectoprueba.service.serviceimpl;

import java.util.Optional;

import com.pruebaproyecto.proyectoprueba.common.CommonSvcImpl;
import com.pruebaproyecto.proyectoprueba.models.clientesModel;
import com.pruebaproyecto.proyectoprueba.repository.clienteRepository;
import com.pruebaproyecto.proyectoprueba.service.clientesService;

public class clientesServiceImpl extends CommonSvcImpl<clientesModel, clienteRepository> implements clientesService {

    @Override
    public void deleteById(int id) {
        if (id == 5) {
            throw  new RuntimeException("No se puede eliminar el cliente con id 5");
        }else{
            this.repository.deleteById(id);
        }
    }

    @Override
    public Iterable<clientesModel> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<clientesModel> findById(int id) {
        return this.repository.findById(id);
    }

    @Override
    public clientesModel save(clientesModel entity) {
        return this.repository.save(entity);
    }

    @Override
    public Iterable<clientesModel> saveAll(Iterable<clientesModel> entities) {
        return this.repository.saveAll(entities);
    }

    @Override
    public clientesModel findByNombre(String nombre) {
        return this.repository.findByNombre(nombre);
    }
}

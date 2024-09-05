package com.example.vetnet.servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vetnet.entidad.Cliente;
import com.example.vetnet.repositorio.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired 
    ClienteRepository repo;

    @Override
    public Cliente SearchById(Long id) {
        return repo.findById(id).get();
    }
    @Override
    public Collection<Cliente> SearchAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void add(Cliente cliente) {
        repo.save(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        repo.save(cliente);
    }

    @Override
    public Cliente SearchByCedula(int cedula) {
        return repo.findByCedula(cedula);
    }
}

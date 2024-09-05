package com.example.vetnet.servicio;

import java.util.Collection;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vetnet.entidad.Cliente;
import com.example.vetnet.entidad.Mascota;
import com.example.vetnet.repositorio.MascotaRepository;
@Service
public class MascotaServiceImpl implements MascotaService {
    
    @Autowired
    MascotaRepository repo;

    @Override
    public Mascota SearchById(Long id) {
        // TODO Auto-generated method stub
        return repo.findById(id).get();
    }
    @Override
    public Collection<Mascota> SearchAll() {
        // TODO Auto-generated method stub
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);
    }
    @Override
    public void add(Mascota mascota) {
        // TODO Auto-generated method stub
        repo.save(mascota);
    }
    @Override
    public void update(Mascota mascota) {
        // TODO Auto-generated method stub
        repo.save(mascota);
    }

    public List<Mascota> findByCliente(Cliente cliente) {
        return repo.findByCliente(cliente);
    }
}

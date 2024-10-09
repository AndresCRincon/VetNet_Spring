package com.example.vetnet.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vetnet.entidad.Tratamiento;
import com.example.vetnet.repositorio.TratamientoRepository;

@Service
public class TratamientoServiceImpl implements TratamientoService {
    
    @Autowired
    TratamientoRepository repo;

    @Override
    public Tratamiento SearchById(Long id) {
        // TODO Auto-generated method stub
        return repo.findById(id).get();
    }
    @Override
    public List<Tratamiento> SearchAll() {
        // TODO Auto-generated method stub
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);
    }
    @Override
    public void add(Tratamiento tratamiento) {
        // TODO Auto-generated method stub
        repo.save(tratamiento);
    }
    @Override
    public void update(Tratamiento tratamiento) {
        // TODO Auto-generated method stub
        repo.save(tratamiento);
    }

    public List<Tratamiento> SearchByVeterinarioId(Long id) {
        return repo.findByVeterinarioId(id);
    }
}

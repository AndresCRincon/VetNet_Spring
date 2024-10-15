package com.example.vetnet.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vetnet.entidad.Tratamiento;
import com.example.vetnet.entidad.Veterinario;
import com.example.vetnet.repositorio.TratamientoRepository;
import com.example.vetnet.repositorio.VeterinarioRepository;

@Service
public class TratamientoServiceImpl implements TratamientoService {
    
    @Autowired
    TratamientoRepository repo;

    @Autowired
    VeterinarioRepository veterinarioRepository;

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
        Tratamiento tratamiento = repo.findById(id).orElse(null);
        if (tratamiento != null) {
            Veterinario veterinario = tratamiento.getVeterinario();
            repo.deleteById(id);
            if (veterinario != null) {
                veterinario.setNum_atenciones(veterinario.getTratamientos().size());
                veterinarioRepository.save(veterinario);
            }
        }
    }

    @Override
    public void add(Tratamiento tratamiento) {
        // TODO Auto-generated method stub
        repo.save(tratamiento);

        Veterinario veterinario = tratamiento.getVeterinario();
        if (veterinario != null) {
            veterinario.setNum_atenciones(veterinario.getTratamientos().size());
            veterinarioRepository.save(veterinario);
        }
    }
    
    @Override
    public void update(Tratamiento tratamiento) {
        repo.save(tratamiento);
        Veterinario veterinario = tratamiento.getVeterinario();
        if (veterinario != null) {
            veterinario.setNum_atenciones(veterinario.getTratamientos().size());
            veterinarioRepository.save(veterinario);
        }
    }

    public List<Tratamiento> SearchByVeterinarioId(Long id) {
        return repo.findByVeterinarioId(id);
    }

    @Override
    public Long countTotalTreatments() {
        return repo.countTotalTreatments();
    }

    @Override
    public Double calculateTotalTreatmentCost() {
        return repo.calculateTotalTreatmentCost();
    }
}

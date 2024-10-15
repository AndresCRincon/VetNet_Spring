package com.example.vetnet.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vetnet.entidad.Veterinario;
import com.example.vetnet.repositorio.VeterinarioRepository;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {

    @Autowired 
    VeterinarioRepository repo;

    @Override
    public Veterinario SearchById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Veterinario> SearchAll() {
        return repo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void add(Veterinario veterinario) {
        repo.save(veterinario);
    }

    @Override
    public void update(Veterinario veterinario) {
        repo.save(veterinario);
    }

    @Override
    public Veterinario SearchByCedula(int cedula) {
        return repo.findByCedula(cedula);
    }

    public Map<String, Long> getSpecialtiesDistribution() {
        List<Object[]> results = repo.getSpecialtiesDistribution();
        Map<String, Long> specialtiesCount = new HashMap<>();

        for (Object[] result : results) {
            String specialty = (String) result[0];
            Long count = (Long) result[1];
            specialtiesCount.put(specialty, count);
        }

        return specialtiesCount;
    }
}

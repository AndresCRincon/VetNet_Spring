package com.example.vetnet.servicio;

import java.util.List;

import com.example.vetnet.entidad.Tratamiento;


public interface TratamientoService {
    public Tratamiento SearchById(Long id);
    public List<Tratamiento> SearchAll();
    public void add(Tratamiento tratamiento);
    public void deleteById(Long id);
    public void update(Tratamiento tratamiento);

    public List<Tratamiento> SearchByVeterinarioId(Long id);
}

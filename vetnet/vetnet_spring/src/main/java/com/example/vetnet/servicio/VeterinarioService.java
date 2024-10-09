package com.example.vetnet.servicio;

import java.util.List;


import com.example.vetnet.entidad.Veterinario;

public interface VeterinarioService{
    public Veterinario SearchById(Long id);
    public List<Veterinario> SearchAll();
    public void add(Veterinario veterinario);
    public void deleteById(Long id);
    public void update(Veterinario veterinario);
    
    Veterinario SearchByCedula(int cedula);
}

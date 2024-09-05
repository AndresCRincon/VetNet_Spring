package com.example.vetnet.servicio;

import java.util.Collection;

import java.util.List;

import com.example.vetnet.entidad.Cliente;
import com.example.vetnet.entidad.Mascota;

public interface MascotaService {
    public Mascota SearchById(Long id);
    public Collection<Mascota> SearchAll();
    public void add(Mascota mascota);
    public void deleteById(Long id);
    public void update(Mascota mascota);

    public List<Mascota> findByCliente(Cliente cliente);
}

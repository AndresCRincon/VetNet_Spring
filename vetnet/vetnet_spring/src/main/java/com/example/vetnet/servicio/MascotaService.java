package com.example.vetnet.servicio;

import java.util.List;

import com.example.vetnet.entidad.Cliente;
import com.example.vetnet.entidad.Mascota;

public interface MascotaService {
    public Mascota SearchById(Long id);
    public List<Mascota> SearchAll();
    public void add(Mascota mascota);
    public void deleteById(Long id);
    public void update(Mascota mascota);

    public List<Mascota> SearchByClienteId(Long id);

    Long countActivePets();
}

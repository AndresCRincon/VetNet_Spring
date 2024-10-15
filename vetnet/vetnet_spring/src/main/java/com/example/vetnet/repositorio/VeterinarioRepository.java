package com.example.vetnet.repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.vetnet.entidad.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario,Long> {
    Veterinario findByCedula(int cedula);

    @Query("SELECT v.especialidad, COUNT(v) FROM Veterinario v GROUP BY v.especialidad")
    List<Object[]> getSpecialtiesDistribution();

}

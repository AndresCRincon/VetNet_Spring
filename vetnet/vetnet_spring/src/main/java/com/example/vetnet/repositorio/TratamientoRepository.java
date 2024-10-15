package com.example.vetnet.repositorio;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.vetnet.entidad.Tratamiento;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
    List<Tratamiento> findByVeterinarioId(Long id);


    @Query("SELECT COUNT(t) FROM Tratamiento t")
    Long countTotalTreatments();

    @Query("SELECT SUM(t.droga.precio_venta) FROM Tratamiento t")
    Double calculateTotalTreatmentCost();

}

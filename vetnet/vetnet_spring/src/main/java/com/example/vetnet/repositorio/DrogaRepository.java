package com.example.vetnet.repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.vetnet.entidad.Droga;

@Repository
public interface DrogaRepository extends JpaRepository<Droga, Long> {

    @Query(value = "SELECT d FROM Droga d ORDER BY d.precio_compra DESC LIMIT 5")
    List<Droga> findTopExpensiveMedications(); 


}

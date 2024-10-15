package com.example.vetnet.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vetnet.entidad.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {
    Administrador findByCedula(int cedula);
}


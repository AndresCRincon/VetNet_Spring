package com.example.vetnet.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vetnet.entidad.Administrador;
import com.example.vetnet.repositorio.AdministradorRepository;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public Administrador findByCedula(int cedula) {
        return administradorRepository.findByCedula(cedula);
    }

}


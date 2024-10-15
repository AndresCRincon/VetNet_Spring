package com.example.vetnet.controlador;

import org.springframework.web.bind.annotation.RestController;

import com.example.vetnet.entidad.Cliente;
import com.example.vetnet.entidad.Droga;
import com.example.vetnet.repositorio.DrogaRepository;
import com.example.vetnet.servicio.DrogaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/droga")
@CrossOrigin(origins = "http://localhost:4200")
public class DrogaController {
    
    @Autowired
    private DrogaService drogaService;

    @GetMapping("/find/{id}")
    public Droga mostrarDroga(@PathVariable("id") Long id) {
    return drogaService.SearchById(id);
    }

    @GetMapping("/all")
    public List<Droga> allDrogas() {
        return drogaService.SearchAll();
    }
}

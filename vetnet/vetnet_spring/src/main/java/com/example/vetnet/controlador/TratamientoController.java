package com.example.vetnet.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.vetnet.entidad.Tratamiento;
import com.example.vetnet.servicio.TratamientoService;
import com.example.vetnet.servicio.VeterinarioService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.servlet.http.HttpSession;



@RequestMapping("/tratamiento")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TratamientoController {
    @Autowired
    TratamientoService tratamientoService;

    @Autowired
    VeterinarioService veterinarioService;

    @GetMapping("/all")
    public List<Tratamiento> mostrarTratamientos() {
    return tratamientoService.SearchAll();
    }

    @GetMapping("/veterinario/{id}")
    public List<Tratamiento> mostrarTratamientosVet(@PathVariable("id") Long id) {
        return tratamientoService.SearchByVeterinarioId(id);
    }
    


    @GetMapping("/find/{id}")
    public Tratamiento mostrarinfoTratamiento(Model model, @PathVariable("id") Long id) {
        return tratamientoService.SearchById(id);
    }
    
    @GetMapping("path")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    @PostMapping("/registrar")
    public void registroTratamiento(@RequestBody Tratamiento tratamiento) {
    tratamientoService.add(tratamiento);
}


    @DeleteMapping("/eliminar/{id}")
    public void borrarTratamiento(@PathVariable("id") Long id) {
        tratamientoService.deleteById(id);
    }


    @PutMapping("/modificar/{id}")
    public void actualizarTratameinto(@RequestBody Tratamiento tratamiento) {
        tratamientoService.update(tratamiento);
    }

}

package com.example.vetnet.controlador;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import java.util.Map;
import java.util.HashMap;


import com.example.vetnet.entidad.Cliente;
import com.example.vetnet.entidad.Mascota;
import com.example.vetnet.entidad.Tratamiento;
import com.example.vetnet.entidad.Veterinario;
import com.example.vetnet.servicio.ClienteService;
import com.example.vetnet.servicio.VeterinarioService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/veterinario")
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class VetController {

    @Autowired
    VeterinarioService veterinarioService;

    @GetMapping("/find/{id}")
    public Veterinario mostrarinfoVet(@PathVariable("id") Long id) {
    //Cliente cliente = clienteService.SearchById(id);
    //model.addAttribute("cliente", cliente);
    //model.addAttribute("mascotas", cliente.getMascotas()); // Esto pasa la lista de mascotas al modelo
    //return "detalle_cliente";
    return veterinarioService.SearchById(id);
}


    @PostMapping("/registrar")
    public void registroVeterinario(@RequestBody Veterinario veterinario) {
        veterinarioService.add(veterinario);
    }

    @GetMapping("/all")
    public List<Veterinario> allVets() {
        return veterinarioService.SearchAll();
    }

    @GetMapping("/{id}")
    public Veterinario vetPorId(@PathVariable Long id) {
        return veterinarioService.SearchById(id);
    }

    @PutMapping("/modificar/{id}")
    public void actualizarVeterinario(@RequestBody Veterinario veterinario) {
        veterinarioService.update(veterinario);
    }


    @DeleteMapping("/eliminar/{id}")
    public void borrarVeterinario(@PathVariable("id") Long id) {
        veterinarioService.deleteById(id);
    }


@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody Veterinario veterinario, HttpSession session) {
    Veterinario encontrado = veterinarioService.SearchByCedula(veterinario.getCedula());
    if (encontrado != null && encontrado.getPassword().equals(veterinario.getPassword())) {
        session.setAttribute("veterinario", encontrado);
        
        Map<String, Object> response = new HashMap<>();
        response.put("id", encontrado.getId()); 
        response.put("message", "Login exitoso");
        
        return ResponseEntity.ok(response);
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Cédula o contraseña incorrectos.");
    }
}



   @GetMapping("/tratamientos/{id}")
   public List<Tratamiento> mostrarTratamientosVet(@PathVariable Long vetId) {
       Veterinario veterinario = veterinarioService.SearchById(vetId);
       if (veterinario != null) {
           return veterinario.getTratamientos();
       } else {
           return new ArrayList<>(); 
       }
   }
    
}

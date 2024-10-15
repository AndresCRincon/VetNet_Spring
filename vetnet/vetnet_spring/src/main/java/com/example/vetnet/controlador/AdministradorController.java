package com.example.vetnet.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vetnet.entidad.Administrador;
import com.example.vetnet.entidad.Droga;
import com.example.vetnet.servicio.AdministradorService;
import com.example.vetnet.servicio.DrogaService;
import com.example.vetnet.servicio.MascotaService;
import com.example.vetnet.servicio.TratamientoService;
import com.example.vetnet.servicio.VeterinarioService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.servlet.http.HttpSession;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private TratamientoService tratamientoService;

    @Autowired
    private VeterinarioService veterinarioService;

    @Autowired
    private DrogaService drogaService;

    @GetMapping("/mascotasActivas")
    public Long getActivePetsCount() {
        return mascotaService.countActivePets();
    }

    @GetMapping("/tratamientosTotales")
    public Long getTotalTreatmentsCount() {
        return tratamientoService.countTotalTreatments();
    }

    @GetMapping("/costoTratamientos")
    public Double getTotalTreatmentCost() {
        return tratamientoService.calculateTotalTreatmentCost();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Administrador administrador, HttpSession session) {
    Administrador encontrado = administradorService.findByCedula(administrador.getCedula());
    if (encontrado != null && encontrado.getPassword().equals(administrador.getPassword())) {
        session.setAttribute("administrador", encontrado);
        
        Map<String, Object> response = new HashMap<>();
        response.put("cedula", encontrado.getCedula());
        response.put("message", "Login exitoso");
        
        return ResponseEntity.ok(response);
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Cédula o contraseña incorrectos.");
    }
   }

   @GetMapping("/specialtiesDistribution")
    public Map<String, Long> getSpecialtiesDistribution() {
        return veterinarioService.getSpecialtiesDistribution();
    }

     @GetMapping("/medicamentos/top-prices")
    public List<Droga> getTopPricedMedications() {
        return drogaService.getTopExpensiveMedications();
    }

}


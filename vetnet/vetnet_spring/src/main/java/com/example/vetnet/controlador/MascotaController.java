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

import com.example.vetnet.entidad.Cliente;
import com.example.vetnet.entidad.Mascota;
import com.example.vetnet.servicio.ClienteService;
import com.example.vetnet.servicio.MascotaService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/mascota")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {
    @Autowired
    MascotaService mascotaService;

    @Autowired
    ClienteService clienteService;

    @GetMapping("/all")
    public List<Mascota> mostrarMascotas() {
    /*Cliente cliente = (Cliente) session.getAttribute("cliente");
    if (cliente != null) {
        model.addAttribute("mascotas", mascotaService.findByCliente(cliente));
    } else {
        model.addAttribute("mascotas", mascotaService.SearchAll());
    }
    return "listado_mascotas";*/
    return mascotaService.SearchAll();
    }

    @GetMapping("/cliente/{id}")
    public List<Mascota> mostrarMascotasCliente(@PathVariable("id") Long id) {
        return mascotaService.SearchByClienteId(id);
    }
    


    /*@GetMapping("/mascotas")
    public String listarMascotas(Model model, HttpSession session) {
    Cliente cliente = (Cliente) session.getAttribute("cliente");
    if (cliente == null) {
        return "redirect:/login"; 
    }
    model.addAttribute("mascotas", mascotaService.findByCliente(cliente));
    return "listado_mascotas"; 
}*/





    @GetMapping("/find/{id}")
    public Mascota mostrarinfoMascota(Model model, @PathVariable("id") Long id) {
        //model.addAttribute("mascota", mascotaService.SearchById(id));
        return mascotaService.SearchById(id);
    }
    
    @GetMapping("path")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        Mascota mascota = new Mascota("","","","","",0,"");
        model.addAttribute("mascota", mascota);
        return "registro_mascotas";
    }

    @PostMapping("/registrar/{clienteId}")
    public void registroMascota(@RequestBody Mascota mascota, @PathVariable("clienteId") Long clienteId) {
        Cliente cliente = clienteService.SearchById(clienteId);
        mascota.setCliente(cliente);
    /*Cliente cliente = clienteService.SearchById(clienteId);
    mascota.setCliente(cliente);*/
    mascotaService.add(mascota);
}


    @DeleteMapping("/eliminar/{id}")
    public void borrarMascota(@PathVariable("id") Long id) {
        mascotaService.deleteById(id);
    }

   /*@GetMapping("/modificar/{id}")
    public String mostrarFormularioModificar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("mascota", mascotaService.SearchById(id));
        return "modificar_mascota";
    }*/

    @PutMapping("/modificar/{id}/{clienteId}")
    public void actualizarMascota(@RequestBody Mascota mascota, @PathVariable Long id, @PathVariable("clienteId") Long clienteId) {
        Cliente cliente = clienteService.SearchById(clienteId);
        Mascota mascotaExistente = mascotaService.SearchById(id);
        if (mascotaExistente != null) {
            mascota.setCliente(cliente); 
            mascotaService.update(mascota);
        }
    }

}
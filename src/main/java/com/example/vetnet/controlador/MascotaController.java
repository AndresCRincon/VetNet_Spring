package com.example.vetnet.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.vetnet.entidad.Cliente;
import com.example.vetnet.entidad.Mascota;
import com.example.vetnet.servicio.ClienteService;
import com.example.vetnet.servicio.MascotaService;

import jakarta.servlet.http.HttpSession;



@RequestMapping("/mascota")
@Controller
public class MascotaController {
    @Autowired
    MascotaService mascotaService;

    @Autowired
    ClienteService clienteService;

    @GetMapping("/all")
    public String mostrarMascotas(Model model, HttpSession session) {
    Cliente cliente = (Cliente) session.getAttribute("cliente");
    if (cliente != null) {
        model.addAttribute("mascotas", mascotaService.findByCliente(cliente));
    } else {
        model.addAttribute("mascotas", mascotaService.SearchAll());
    }
    return "listado_mascotas"; 
    }


    @GetMapping("/mascotas")
    public String listarMascotas(Model model, HttpSession session) {
    Cliente cliente = (Cliente) session.getAttribute("cliente");
    if (cliente == null) {
        return "redirect:/login"; 
    }
    model.addAttribute("mascotas", mascotaService.findByCliente(cliente));
    return "listado_mascotas"; 
}




    @GetMapping("/find/{id}")
    public String mostrarinfoMascota(Model model, @PathVariable("id") Long id) {
        model.addAttribute("mascota", mascotaService.SearchById(id));
        return "mostrar_mascota";
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

    @PostMapping("/registrar")
    public String registroMascota(@ModelAttribute("mascota") Mascota mascota, @RequestParam Long clienteId) {
    Cliente cliente = clienteService.SearchById(clienteId);
    mascota.setCliente(cliente);
    mascotaService.add(mascota);
    return "redirect:/mascota/all";
}


    @GetMapping("/eliminar/{id}")
    public String borrarMascota(@PathVariable("id") Long id) {
        mascotaService.deleteById(id);
        return "redirect:/mascota/all";
    }

    @GetMapping("/modificar/{id}")
    public String mostrarFormularioModificar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("mascota", mascotaService.SearchById(id));
        return "modificar_mascota";
    }

    @PostMapping("/modificar/{id}")
    public String actualizarMascota(@PathVariable("id") Long id, @ModelAttribute("mascota") Mascota mascota) {
        mascota.setId(id);
        mascotaService.update(mascota);
        return "redirect:/mascota/all";
    }

}
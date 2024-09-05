package com.example.vetnet.controlador;

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
import com.example.vetnet.servicio.ClienteService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/cliente")
@Controller
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/find/{id}")
    public String mostrarinfoCliente(Model model, @PathVariable("id") Long id) {
    Cliente cliente = clienteService.SearchById(id);
    model.addAttribute("cliente", cliente);
    model.addAttribute("mascotas", cliente.getMascotas()); // Esto pasa la lista de mascotas al modelo
    return "detalle_cliente";
}


    
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        Cliente cliente = new Cliente("","","",0,0);
        model.addAttribute("cliente", cliente);
        return "registro";
    }

    @PostMapping("/registrar")
    public String registroCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.add(cliente);
        return "redirect:/cliente/all";
    }

    @GetMapping("/all")
    public String allClientes(Model model) {
        model.addAttribute("clientes", clienteService.SearchAll());
        return "usuarios";
    }

    @GetMapping("/{id}")
    public Cliente clientePorId(@PathVariable Long id) {
        return clienteService.SearchById(id);
    }

    @GetMapping("/modificar/{id}")
    public String mostrarFormularioModificar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cliente", clienteService.SearchById(id));
        return "modificar";
    }

    @PostMapping("/modificar/{id}")
    public String actualizarCliente(@PathVariable("id") Long id, @ModelAttribute("cliente") Cliente cliente) {
        cliente.setId(id);
        clienteService.update(cliente);
        return "redirect:/cliente/all";
    }


    @GetMapping("/eliminar/{id}")
    public String borrarCliente(@PathVariable("id") Long id) {
        clienteService.deleteById(id);
        return "redirect:/cliente/all";
    }

    @PostMapping("/login")
    public String login(@RequestParam int cedula, @RequestParam String password, Model model, HttpSession session) {
    Cliente cliente = clienteService.SearchByCedula(cedula);
    if (cliente != null && cliente.getPassword().equals(password)) {
        session.setAttribute("cliente", cliente);
        return "redirect:/mascota/all";
    } else {
        model.addAttribute("error", "Cédula o contraseña incorrectos.");
        return "clinica";
    }
}

   @GetMapping("/logout")
   public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/clinica"; 
   }


  @GetMapping("/cliente/mascotas/{id}")
    public String mostrarMascotasCliente(@PathVariable("id") Long id, Model model) {
    Cliente cliente = clienteService.SearchById(id);
    model.addAttribute("cliente", cliente);
    model.addAttribute("mascotas", cliente.getMascotas());
    return "listado_mascotas";
    } 

    @GetMapping("/perfil")
    public String mostrarPerfilCliente(HttpSession session, Model model) {
    Cliente cliente = (Cliente) session.getAttribute("cliente");
    if (cliente == null) {
        return "redirect:/clinica";
    }
    model.addAttribute("cliente", cliente);
    return "perfil_cliente";
    }

    
}

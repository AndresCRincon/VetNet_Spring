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
import com.example.vetnet.servicio.ClienteService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/find/{id}")
    public Cliente mostrarinfoCliente(@PathVariable("id") Long id) {
    //Cliente cliente = clienteService.SearchById(id);
    //model.addAttribute("cliente", cliente);
    //model.addAttribute("mascotas", cliente.getMascotas()); // Esto pasa la lista de mascotas al modelo
    //return "detalle_cliente";
    return clienteService.SearchById(id);
}


    
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        Cliente cliente = new Cliente("","","",0,0);
        model.addAttribute("cliente", cliente);
        return "registro";
    }

    @PostMapping("/registrar")
    public void registroCliente(@RequestBody Cliente cliente) {
        clienteService.add(cliente);
    }

    @GetMapping("/all")
    public List<Cliente> allClientes() {
        //model.addAttribute("clientes", clienteService.SearchAll());
        //return "usuarios";
        return clienteService.SearchAll();
    }

    @GetMapping("/{id}")
    public Cliente clientePorId(@PathVariable Long id) {
        return clienteService.SearchById(id);
    }

    /*@GetMapping("/modificar/{id}")
    public String mostrarFormularioModificar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cliente", clienteService.SearchById(id));
        return "modificar";
    }*/

    @PutMapping("/modificar/{id}")
    public void actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
    cliente.setId(id); 
    clienteService.update(cliente);
    }



    @DeleteMapping("/eliminar/{id}")
    public void borrarCliente(@PathVariable("id") Long id) {
        clienteService.deleteById(id);
    }

    /*@PostMapping("/login")
    public String login(@RequestParam int cedula, @RequestParam String password, Model model, HttpSession session) {
    Cliente cliente = clienteService.SearchByCedula(cedula);
    if (cliente != null && cliente.getPassword().equals(password)) {
        session.setAttribute("cliente", cliente);
        return "redirect:/portal";
    } else {
        model.addAttribute("error", "Cédula o contraseña incorrectos.");
        return "clinica";
    }
}*/

@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody Cliente cliente, HttpSession session) {
    Cliente encontrado = clienteService.SearchByCedula(cliente.getCedula());
    if (encontrado != null && encontrado.getPassword().equals(cliente.getPassword())) {
        session.setAttribute("cliente", encontrado);
        
        Map<String, Object> response = new HashMap<>();
        response.put("id", encontrado.getId()); 
        response.put("message", "Login exitoso");
        
        return ResponseEntity.ok(response);
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Cédula o contraseña incorrectos.");
    }
}







   @GetMapping("/logout")
   public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/clinica"; 
   }


   @GetMapping("/cliente/mascotas/{id}")
    public List<Mascota> mostrarMascotasCliente(@PathVariable("id") Long clienteId) {
    Cliente cliente = clienteService.SearchById(clienteId);
        return cliente.getMascotas();
    }

    
}

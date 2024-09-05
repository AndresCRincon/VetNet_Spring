package com.example.vetnet.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.vetnet.entidad.Cliente;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/index")
    public String Home() {
        return "index";
    }

    @GetMapping("/servicios")
    public String Servicios() {
        return "servicios";
    }

    @GetMapping("/galeria")
    public String Galeria() {
        return "galeria";
    }

    @GetMapping("/contacto")
    public String Contacto() {
        return "contacto";
    }

    @GetMapping("/clinica")
    public String showLogin(Model model) {
    model.addAttribute("cliente", new Cliente());
    return "clinica";
}

@GetMapping("/logout")
public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/";
}



    
}

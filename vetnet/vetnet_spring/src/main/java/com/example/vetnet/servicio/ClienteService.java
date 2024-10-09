package com.example.vetnet.servicio;

import java.util.List;

import com.example.vetnet.entidad.Cliente;

public interface ClienteService{
    public Cliente SearchById(Long id);
    public List<Cliente> SearchAll();
    public void add(Cliente cliente);
    public void deleteById(Long id);
    public void update(Cliente cliente);
    
    Cliente SearchByCedula(int cedula);
}

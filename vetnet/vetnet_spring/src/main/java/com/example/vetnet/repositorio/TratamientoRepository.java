package com.example.vetnet.repositorio;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vetnet.entidad.Tratamiento;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
    List<Tratamiento> findByVeterinarioId(Long id);



    /*private Map<Integer, Cliente> data = new HashMap<>();

    public ClienteRepository() {
        this.data.put(1, new Cliente("pepe", "pepe@gmail.com", 123456789, 923874920));
        this.data.put(2, new Cliente("gustavo uribe", "centrohumano@yahoo.com", 246810, 393487493));
        this.data.put(3, new Cliente("James Rodriguez", "james@hotmail.com", 409856765, 43948435));
        this.data.put(4, new Cliente("Don Juan", "juanitojuan@gmail.com", 349843345, 95867956));
    }

    public Cliente findById(int id) {
        return data.get(id);
    }

    public Collection<Cliente> findAll() {
        return data.values();
    }

    public void deleteById(int id) {
        data.remove(id);
    }

    public void update(Cliente cliente) {
        data.put(cliente.getId(), cliente);
    }

    public void add(Cliente cliente) {
        int tam = data.size();
        int lastId = data.get(tam).getId();
        cliente.setId(lastId + 1);
        data.put(cliente.getId(), cliente);
    }*/

}

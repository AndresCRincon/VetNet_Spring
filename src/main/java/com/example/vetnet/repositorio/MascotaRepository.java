package com.example.vetnet.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vetnet.entidad.Cliente;
import com.example.vetnet.entidad.Mascota;

@Repository	
public interface MascotaRepository extends JpaRepository<Mascota, Long>{
     List<Mascota> findByCliente(Cliente cliente);


    /*private Map<Integer, Mascota> data = new HashMap<>();

    public MascotaRepository() {
        this.data.put(1, new Mascota("Rex", "25kg", "Pastor Alemán", "Ninguna", "Activo", 5, "/img/jhony.jpg"));
        this.data.put(2, new Mascota("Luna", "8kg", "Chihuahua", "Catarro", "Enferma", 3, "/img/Zeus.jpg"));
        this.data.put(3, new Mascota("Pablo", "30kg", "Labrador", "Problemas de piel", "Activo", 7, "/img/pablo.jpg"));
        this.data.put(4, new Mascota("Bella", "12kg", "Beagle", "Alérgica a los alimentos", "Recuperándose", 4, "/img/lucas.jpg"));
        this.data.put(5, new Mascota("Charlie", "20kg", "Bulldog Francés", "Ninguna", "Activo", 6, "/img/miguel.jpg"));
    }


    
    public Mascota findById(int id) {
        return data.get(id);
    }
    public Collection<Mascota> findAll() {
        return data.values();
    }
    //Sprint 3
    public void deleteById(int id) {
        data.remove(id);
    }
    public void update(Mascota mascota) {
        data.put(mascota.getId(), mascota);
    }

    public void add(Mascota mascota) {
        int tam = data.size();
        int lastId = data.get(tam).getId();
        mascota.setId(lastId + 1);
        data.put(mascota.getId(), mascota);
    }*/
}

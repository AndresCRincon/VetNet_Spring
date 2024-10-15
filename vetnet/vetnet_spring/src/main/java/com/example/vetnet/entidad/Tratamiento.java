package com.example.vetnet.entidad;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Tratamiento {

    @Id
    @GeneratedValue
    private Long id;

    private Date fecha;

    @ManyToOne
    private Mascota mascota;

    @ManyToOne
    private Veterinario veterinario;

    @ManyToOne
    private Droga droga;

    public Tratamiento(Long id, Droga droga, Date fecha, Mascota mascota, Veterinario veterinario) {
        this.id = id;
        this.droga = droga;
        this.fecha = fecha;
        this.mascota = mascota;
        this.veterinario = veterinario;
    }

    public Tratamiento() {}

    public Tratamiento(Droga droga, Date fecha, Mascota mascota, Veterinario veterinario) {
        this.droga = droga;
        this.fecha = fecha;
        this.mascota = mascota;
        this.veterinario = veterinario;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Droga getDroga() {
        return droga;
    }

    public void setDroga(Droga droga) {
        this.droga = droga;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
}

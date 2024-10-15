package com.example.vetnet.entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
    private String nombre;
    private String correo;
    private int cedula;
    private int celular;
    private String password;
    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mascota> mascotas = new ArrayList<>();

    public Cliente(Long id,String nombre, String password, String correo, int cedula, int celular) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.correo = correo;
        this.cedula = cedula;
        this.celular = celular;
    }

    public Cliente(){}

    public Cliente(String nombre, String password,String correo, int cedula, int celular) {
        this.nombre = nombre;
        this.password = password;
        this.correo = correo;
        this.cedula = cedula;
        this.celular = celular;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}


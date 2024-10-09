package com.example.vetnet.entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Mascota {
    private String nombre;
    private String peso;
    private String raza;
    private String enfermedad;
    private String estado;
    private int edad;
    private String imagen; // Nuevo atributo para la URL de la imagen
    @Id
    @GeneratedValue
    private Long id;


    @JsonIgnore
    @ManyToOne
    private Cliente cliente;

    @JsonIgnore
    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tratamiento> tratamientos = new ArrayList<>();

    public Mascota(Long id, String nombre, String peso, String raza, String enfermedad, String estado, int edad, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.raza = raza;
        this.enfermedad = enfermedad;
        this.estado = estado;
        this.edad = edad;
        this.imagen = imagen; 
    }

    public Mascota(){}

    public Mascota(String nombre, String peso, String raza, String enfermedad, String estado, int edad, String imagen) {
        this.nombre = nombre;
        this.peso = peso;
        this.raza = raza;
        this.enfermedad = enfermedad;
        this.estado = estado;
        this.edad = edad;
        this.imagen = imagen;
    }

    // Getters y Setters
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

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen; 
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
}

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
public class Veterinario{
    private String nombre;
    private String especialidad;
    private int cedula;
    private int num_atenciones;
    private String password;
    private String foto;
    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tratamiento> tratamientos = new ArrayList<>();

    public Veterinario(Long id,String nombre, String password, String especialidad, int cedula, int num_atenciones, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.especialidad = especialidad;
        this.cedula = cedula;
        this.num_atenciones = num_atenciones;
        this.foto = foto;
    }

    public Veterinario(){}

    public Veterinario(String nombre, String password,String especialidad, int cedula, int num_atenciones, String foto) {
        this.nombre = nombre;
        this.password = password;
        this.especialidad = especialidad;
        this.cedula = cedula;
        this.num_atenciones = num_atenciones;
        this.foto = foto;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getNumAtenciones() {
        return num_atenciones;
    }

    public void setCelular(int num_atenciones) {
        this.num_atenciones = num_atenciones;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto(){
        return foto;
    }

    public void setFoto(String foto){
        this.foto = foto;
    }

    public int getNum_atenciones() {
        return num_atenciones;
    }

    public void setNum_atenciones(int num_atenciones) {
        this.num_atenciones = num_atenciones;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    

}


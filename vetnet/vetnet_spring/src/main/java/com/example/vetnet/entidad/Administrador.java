package com.example.vetnet.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Administrador {

    @Id
    private int cedula;

    private String password;
    private int mascotasTratamiento;
    private int numAtenciones;
    private int precioTotal;

    public Administrador() {}

    public Administrador(int cedula, String password){
        this.cedula = cedula;
        this.password = password;
    }

    public Administrador(int cedula, String password, int mascotasTratamiento, int numAtenciones, int precioTotal) {
        this.cedula = cedula;
        this.password = password;
        this.mascotasTratamiento = mascotasTratamiento;
        this.numAtenciones = numAtenciones;
        this.precioTotal = precioTotal;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMascotasTratamiento() {
        return mascotasTratamiento;
    }

    public void setMascotasTratamiento(int mascotasTratamiento) {
        this.mascotasTratamiento = mascotasTratamiento;
    }

    public int getNumAtenciones() {
        return numAtenciones;
    }

    public void setNumAtenciones(int numAtenciones) {
        this.numAtenciones = numAtenciones;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }
}

package com.example.vetnet.entidad;

import jakarta.persistence.Entity;

public class Administrador {
    private int mascotas_tratamiento;
    private int num_atenciones;
    private int precio_total;

    public Administrador(int mascotas_tratamiento, int num_atenciones, int precio_total) {
        this.mascotas_tratamiento = mascotas_tratamiento;
        this.num_atenciones = num_atenciones;
        this.precio_total = precio_total;
    }

    public int getMascotas_tratamiento() {
        return mascotas_tratamiento;
    }

    public void setMascotas_tratamiento(int mascotas_tratamiento) {
        this.mascotas_tratamiento = mascotas_tratamiento;
    }

    public int getNum_atenciones() {
        return num_atenciones;
    }

    public void setNum_atenciones(int num_atenciones) {
        this.num_atenciones = num_atenciones;
    }

    public int getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(int precio_total) {
        this.precio_total = precio_total;
    }

}

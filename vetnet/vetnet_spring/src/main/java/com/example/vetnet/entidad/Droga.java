package com.example.vetnet.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Droga {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private float precio_compra;
    private float precio_venta;
    private int unidades_disp;
    private int unidades_vendidas;

    public Droga(Long id, String nombre, float precio_compra, float precio_venta, int unidades_disp, int unidades_vendidas) {
        this.id = id;
        this.nombre = nombre;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.unidades_disp = unidades_disp;
        this.unidades_vendidas = unidades_vendidas;
    }

    public Droga() {}

    public Droga(String nombre, float precio_compra, float precio_venta, int unidades_disp, int unidades_vendidas) {
        this.nombre = nombre;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.unidades_disp = unidades_disp;
        this.unidades_vendidas = unidades_vendidas;
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

    public float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getUnidades_disp() {
        return unidades_disp;
    }

    public void setUnidades_disp(int unidades_disp) {
        this.unidades_disp = unidades_disp;
    }

    public int getUnidades_vendidas() {
        return unidades_vendidas;
    }

    public void setUnidades_vendidas(int unidades_vendidas) {
        this.unidades_vendidas = unidades_vendidas;
    }
}

package com.example.notas.Model;

public class Notas {
    private String titulo;
    private String descripcion;
    private EstadoNota colorNota;


    public Notas(String titulo, String descripcion, EstadoNota estado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.colorNota = EstadoNota.AMARILLO;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoNota getEstado() {
        return colorNota;
    }
    public void setEstado(EstadoNota estado) {
        this.colorNota = colorNota;
    }

    @Override
    public String toString() {
        return titulo + " (" + colorNota.toString() + ")";

    }
}

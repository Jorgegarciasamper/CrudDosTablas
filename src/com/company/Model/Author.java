package com.company.Model;

import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Primero empezamos creando el modelo que es la clase autor.java
 * y que es la clase que va mapear los atributos de la tabla auto en la base de datos libreriasPerez.
 * **/

public class Author {
    private int codautor;
    private String nombre;
    private String apellidos;
    private Date fechan;
    private Date fechaf;
    private String genero;
    private String paisorigen;
    private String estudios;
    private String observaciones;

    public Author(){}//Solo se hace en las veces en que tener un objeto vacio funciones

    public Author(String nombre, String apellidos, Date fechan, Date fechaf, String genero, String paisorigen, String estudios, String observaciones)
    {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechan = fechan;
        this.fechaf = fechaf;
        this.genero = genero;
        this.paisorigen = paisorigen;
        this.estudios = estudios;
        this.observaciones = observaciones;

    }

    public int getCodautor() {
        return codautor;
    }

    public void setCodautor(int codautor) {
        this.codautor = codautor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechan() {
        return fechan;
    }

    public void setFechan(Date fechan) {
        this.fechan = fechan;
    }

    public Date getFechaf() {
        return fechaf;
    }

    public void setFechaf(Date fechaf) {
        this.fechaf = fechaf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPaisorigen() {
        return paisorigen;
    }

    public void setPaisorigen(String paisorigen) {
        this.paisorigen = paisorigen;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Author{" +
                "codautor=" + codautor +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}

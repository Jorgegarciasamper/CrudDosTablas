package com.company.Model;
/**
 * Primero empezamos creando el modelo que es la clase autor.java
 * y que es la clase que va mapear los atributos de la tabla autor en la base de datos libreriasperes.
 * **/
public class Book {
    private int codlibro;

    private String titulo;
    private String descripcion;
    private int precio;
    private int stock;
    private String idioma;
    private String genero;
    private String editorial;

    public Book(){}

    public Book(int codlibro, String titulo, String descripcion, int precio, int stock, String idioma, String genero, String editorial) {
        this.codlibro = codlibro;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.idioma = idioma;
        this.genero = genero;
        this.editorial = editorial;
    }

    public int getCodlibro() {
        return codlibro;
    }

    public void setCodlibro(int codlibro) {
        this.codlibro = codlibro;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
}

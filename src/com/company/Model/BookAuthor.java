package com.company.Model;

public class BookAuthor {
    private int codLibroAutor;
    private int codLibro;
    private int codAutor;//Ventaja de utilizar int y no un objeto author. Si usamos un int cada dao es independiente. Si se
    //usa objeto los dao son dependientes entre si y cada vez que rellenaramos un libro tendriamos que llamar al dao de
    // libroauthor para rellenar libro author y libro
    private String ordenLibro;

    //private Author author; Ojo hacer la relacion en el dao impl
    //private Book book;


    public BookAuthor(int codLibroAutor, int codLibro, int codAutor, String ordenLibro) {
        this.codLibroAutor = codLibroAutor;
        this.codLibro = codLibro;
        this.codAutor = codAutor;
        this.ordenLibro = ordenLibro;
    }

    public int getCodLibroAutor() {
        return codLibroAutor;
    }

    public void setCodLibroAutor(int codLibroAutor) {
        this.codLibroAutor = codLibroAutor;
    }

    public int getCodLibro() {
        return codLibro;
    }

    public void setCodLibro(int codLibro) {
        this.codLibro = codLibro;
    }

    public int getCodAutor() {
        return codAutor;
    }

    public void setCodAutor(int codAutor) {
        this.codAutor = codAutor;
    }

    public String getOrdenLibro() {
        return ordenLibro;
    }

    public void setOrdenLibro(String ordenLibro) {
        this.ordenLibro = ordenLibro;
    }
}





package com.company.View;

import com.company.Model.Author;

import java.util.List;

public class ViewAutor {

    public void verautores(List<Author> autores) {
        for (Author author : autores) {
            System.out.println("Datos del autor: "+ author.getCodautor() + ' '
                                                  + author.getNombre() + ' '
                                                  + author.getApellidos() + ' '
                                                  + author.getGenero());
        }
    }
}

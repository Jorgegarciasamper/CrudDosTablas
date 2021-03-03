package com.company.Controller;
import com.company.DAOException.DAOException;
import com.company.Model.Author;
import com.company.DAO.AuthorDAO;
import com.company.DAO.AuthorDAOImpl;
import com.company.View.ViewAutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerAutor {
    private ViewAutor vista= new ViewAutor();

    public ControllerAutor() {
    }

    //llama al DAO para guardar un autor
    public void createAuthor(Author author) {
        AuthorDAO dao= new AuthorDAOImpl();
        try {
            dao.create(author);
        } catch (DAOException e) {
            System.out.println(e.getCode() + " Message: " + e.getMessage() + "Exception SQL:" + e.getMessage() );
        }
    }
    //llama al DAO para obtener todos los autores y luego los muestra en la vista
    public void readAuthor() {
        List<Author> autores = new ArrayList<Author>();
        AuthorDAO dao= new AuthorDAOImpl();
        try {
            autores=dao.read();
            vista.verautores(autores);
        } catch (DAOException e) {
            System.out.println(e.getCode() + " Message: " + e.getMessage() + "Exception SQL:" + e.getMessage() );
        }
    }
    //llama al DAO para actualizar un autor
    public boolean updateAuthor(Author author)  {
        boolean updated = false;
        AuthorDAO dao = new AuthorDAOImpl();
        try {
            updated = dao.update(author);
        } catch (DAOException e) {
            System.out.println(e.getCode() + " Message: " + e.getMessage() + "Exception SQL:" + e.getMessage() );
        }
        return updated;
    }
    //llama al DAO para eliminar un autor
    public void deleteAuthor(Author author)  {
        AuthorDAO dao = new AuthorDAOImpl();
        try {
            dao.delete(author);
        } catch (DAOException e) {
            System.out.println(e.getCode() + " Message: " + e.getMessage() + "Exception SQL:" + e.getMessage() );
        }
    }
}
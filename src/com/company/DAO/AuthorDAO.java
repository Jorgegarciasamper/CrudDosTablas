package com.company.DAO;

import com.company.DAOException.DAOException;
import com.company.Model.Author;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
/**
 * Este metodo registrara los métodos del CRUD en autor
 */
public interface AuthorDAO extends DAO<Author>{//quitar los rollos I de interface y TODAS las clases en mayus
    //public void create(Author author) throws DAOException;
    //public List<Author> read() throws DAOException;
    //public boolean update(Author author) throws DAOException;
    //public boolean delete(Author author) throws DAOException;
}


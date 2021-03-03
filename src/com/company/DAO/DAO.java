package com.company.DAO;
import com.company.DAOException.DAOException;

import java.util.List;

public interface DAO<T>  {
    void create(T t) throws DAOException;
    List<T> read() throws DAOException;
    boolean update(T t) throws DAOException;
    void delete(T t) throws DAOException;

}

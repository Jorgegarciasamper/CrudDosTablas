package com.company.DAO;

import com.company.Model.Book;
import com.company.ConnectionBD.ConnectBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    @Override
    public void create(Book Book) {
        boolean registrar = false;

        Statement stm= null;
        //Connection con=null;

        String sql="INSERT INTO libro values (NULL,'"
                + Book.getTitulo()       +"','"
                + Book.getDescripcion()  +"','"
                + Book.getPrecio()       +"','"
                + Book.getStock()        +"','"
                + Book.getGenero()       +"','"
                + Book.getIdioma()       +"','"
                + Book.getGenero()       +"','"
                + Book.getEditorial()    +"')";

        try {
            //con= ConnectBD.conectar();
            stm= ConnectBD.Connect().createStatement();
            stm.execute(sql);
            registrar=true;
            stm.close();
            //con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase libroDaoImple, método registrar");
            e.printStackTrace();
        }
        //return registrar;
    }


    @Override
    public List<Book> read() {
        //Connection co =null;
        Statement stm= null;
        ResultSet rs=null;

        String sql="SELECT * FROM libro ORDER BY codlibro";

        List<Book> listalibro= new ArrayList<Book>();

        try {
            //co= ConnectBD.conectar();
            stm=ConnectBD.Connect().createStatement();
            rs=stm.executeQuery(sql);
            while (rs.next()) {
                Book c=new Book();
                c.setCodlibro(rs.getInt(1));
                c.setTitulo(rs.getString(2));
                c.setDescripcion(rs.getString(3));
                c.setPrecio(rs.getInt(4));
                c.setStock(rs.getInt(5));
                c.setIdioma(rs.getString(6));
                c.setGenero(rs.getString(7));
                c.setEditorial(rs.getString(8));
                listalibro.add(c);
            }
            stm.close();
            rs.close();
            //co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase libroDaoImple, método obtener");
            e.printStackTrace();
        }

        return listalibro;
    }

    @Override
    public boolean update(Book Book) {
        Connection connect= null;
        Statement stm= null;

        boolean actualizar=false;

        String sql="UPDATE libro SET titulo = '" +  Book.getTitulo()
                +"',  descripcion = '"           + Book.getDescripcion()
                +"',  precio    = '"             + Book.getPrecio()
                +"',  stock    = '"              + Book.getStock()
                +"',  idioma    = '"             + Book.getIdioma()
                +"',  genero= '"                 + Book.getGenero()
                +"',  editorial  = '"            + Book.getEditorial()
                +"'" +" WHERE codlibro ="        + Book.getCodlibro();
        try {
            //connect= ConnectBD.conectar();
            stm=connect.createStatement();
            stm.execute(sql);
            actualizar=true;
        } catch (SQLException e) {
            System.out.println("Error: Clase libroDaoImple, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    @Override
    public void delete(Book Book) {
        //Connection connect= null;
        Statement stm= null;

        boolean eliminar=false;

        String sql=" DELETE FROM libro WHERE codlibro = " + Book.getCodlibro();
        try {
            //connect= ConnectBD.conectar();
            stm=ConnectBD.Connect().createStatement();
            stm.execute(sql);
            eliminar=true;
        } catch (SQLException e) {
            System.out.println("Error: Clase libroDaoImple, método eliminar");
            e.printStackTrace();
        }
        //return eliminar;
    }
}

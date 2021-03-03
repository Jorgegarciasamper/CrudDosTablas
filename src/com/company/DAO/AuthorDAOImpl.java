package com.company.DAO;

import com.company.ConnectionBD.ClientDB;
import com.company.ConnectionBD.DataBase;
import com.company.DAOException.DAOException;
import com.company.Model.Author;
import com.company.ConnectionBD.ConnectBD;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Creamos la implementacion de la interface de autor
 */
public class AuthorDAOImpl implements AuthorDAO {
    final String ERROR_TRANSACTION = "TRANSACCION EXCEPTION!!";
    /**
     * Bloque de Querys
     * */
    String INSERT = "INSERT INTO autor(nombre,apellidos,fechan,fechaf, genero, paisorigen, estudios, observaciones) values (?,?,?,?,?,?,?,?);";
    String SELECT = "SELECT * FROM autor ORDER BY codautor";
    String UPDATE = "UPDATE autor SET nombre = ?, apellidos = ?, fechan = ?, fechaf = ?, genero = ?, paisorigen= ?, estudios  = ?, observaciones = ? " +
            "WHERE codautor = ?;";
    String DELETE = " DELETE FROM autor WHERE codautor = ?;";
    /**
    * Methods
    * */
    //private Connection con = null;
    DataBase clienDB = new ClientDB();
    // package level access
    //AuthorDAOImpl() {
    //    //Antiguo
    //    //String password = "000000";
    //    //String username = "postgres";
    //    //String url = "jdbc:postgresql://localhost:5432/libreriasPerez?useServerPrepStmts=true";
    //    //try {
    //    //    con = DriverManager.getConnection(url, username, password);
    //    //    con.setAutoCommit(false);
    //    //} catch (SQLException se) {
    //    //    System.out.println("Error obtaining connection with the database: " + se);
    //    //    System.exit(-1);
    //    //}
    //
    //}

    @Override
    public void create(Author author) throws DAOException {
        //Connection connection = ConnectBD.Connect();
        Connection con=clienDB.getConnection();
        try {
                PreparedStatement psInsert = clienDB.createStatement(INSERT);
                //psInsert = connection.prepareStatement(INSERT);
                psInsert.setString(1, author.getNombre());
                psInsert.setString(2, author.getApellidos());
                psInsert.setDate(3, (Date) author.getFechan());
                psInsert.setDate(4, (Date) author.getFechaf());
                psInsert.setString(5, author.getGenero());
                psInsert.setString(6, author.getPaisorigen());
                psInsert.setString(7, author.getEstudios());
                psInsert.setString(8, author.getObservaciones());
                psInsert.executeUpdate();
                //connection.commit();
                clienDB.Commit();
                //con.commit();

        } catch (SQLException e) {
            //dispathRollback(connection);
            //dispathRollback(con);
            clienDB.RollBlack();
            throw new DAOException(ERROR_TRANSACTION+ " " + this.getClass().getSimpleName() + " " ,"Metodo create",e);
            //throw  new DAOException("Error: %s, %s%n", this.getClass().getSimpleName(), "Create");
        } finally {
            //closeConection(psInsert);
            clienDB.Close(con);
        }
    }
    @Override
    public List<Author> read() throws DAOException{
        Connection con=clienDB.getConnection();
        //PreparedStatement psRead = null;
        ResultSet rs = null;
        //Connection connection = ConnectBD.Connect();
        List<Author> listaautor = new ArrayList<Author>();
        try {
            //psRead = connection.prepareStatement(SELECT);
            PreparedStatement psRead = clienDB.createStatement(SELECT);
            rs = psRead.executeQuery(SELECT);
            while (rs.next()) {
                Author c = new Author();
                c.setCodautor(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellidos(rs.getString(3));
                c.setFechan(rs.getDate(4));
                c.setFechaf(rs.getDate(5));
                c.setGenero(rs.getString(6));
                c.setPaisorigen(rs.getString(7));
                c.setEstudios(rs.getString(8));
                c.setObservaciones(rs.getString(9));
                listaautor.add(c);
            }
        } catch (SQLException e) {
            //dispathRollback(connection);
            //dispathRollback(con);
            clienDB.RollBlack();
            throw new DAOException(ERROR_TRANSACTION+ " " + this.getClass().getSimpleName() + " " ,"Metodo create",e);
            //throw  new DAOException("Error: %s, %s%n", this.getClass().getSimpleName(), "Create");
        }// finally {
        //    closeConection(psRead);
        //}
        return listaautor;
    }

    @Override
    public boolean update(Author author) throws DAOException {
        Connection con=clienDB.getConnection();
        //Connection connection = ConnectBD.Connect();
        //PreparedStatement psUpdate = null;;
        boolean updated=false;

        //try (PreparedStatement psUpdate = con.prepareStatement(UPDATE)){
        try{
            PreparedStatement psUpdate = clienDB.createStatement(UPDATE);
            //if(!buscarAuthorById(author.getCodautor()))
            //{
            //    throw new DAOException(ERROR_TRANSACTION+ " " + this.getClass().getSimpleName() + " " ," El author ya no existe");
            //}
            //else {//si aun existe se modifica
                //psUpdate = connection.prepareStatement(UPDATE);
                psUpdate.setString(1, author.getNombre());
                psUpdate.setString(2, author.getApellidos());
                psUpdate.setDate(3, (Date) author.getFechan());
                psUpdate.setDate(4, (Date) author.getFechaf());
                psUpdate.setString(5, author.getGenero());
                psUpdate.setString(6, author.getPaisorigen());
                psUpdate.setString(7, author.getEstudios());
                psUpdate.setString(8, author.getObservaciones());
                psUpdate.setInt(9, author.getCodautor());//Va en orden de como se tiene la query
                updated = psUpdate.executeUpdate() > 0;
                //if (psUpdate.executeUpdate() != 1) {
                //    throw new SQLException("Error updating department");
                //}
                //connection.commit();
                //con.commit();
            clienDB.Commit();
        } catch (SQLException e) {
            //dispathRollback(connection);
            //dispathRollback(con);
            clienDB.RollBlack();
            throw new DAOException(ERROR_TRANSACTION+ " " + this.getClass().getSimpleName() + " " ,"Metodo create",e);
            //throw  new DAOException("Error: %s, %s%n", this.getClass().getSimpleName(), "Create");
        } finally {
            //closeConection(psUpdate);
            clienDB.Close(con);
        }
        return updated;
    }

    @Override
    public void delete(Author author) throws DAOException {
        Connection con=clienDB.getConnection();
        //Connection connection = ConnectBD.Connect();
        //PreparedStatement psDelete = null;
        try (PreparedStatement psDelete = con.prepareStatement(DELETE)) {
            //psDelete = connection.prepareStatement(DELETE);
            psDelete.setInt(1, author.getCodautor());
            psDelete.executeUpdate();
            //connection.commit();
            //con.commit();
            clienDB.Commit();
        } catch (SQLException e) {
            //dispathRollback(connection);
            dispathRollback(con);
            throw new DAOException(ERROR_TRANSACTION+ " " + this.getClass().getSimpleName() + " " ,"Metodo Delete",e);
            //throw  new DAOException("Error: %s, %s%n", this.getClass().getSimpleName(), "Update");
        } finally {
            //Opcion A
            clienDB.Close(con);
            //Opcion B
            //closeConection(con); //si descomentar tb descomentar l.179 a l.186

            //closeConection(psDelete);
        }
    }

    //public void closeConection(Connection con) {
    //        try {
    //            con.close();
    //        } catch(SQLException e) {
    //            System.out.println("Error al cierre");
    //            //throw new DAOException(ERROR_TRANSACTION+ " in method " + this.getClass().getSimpleName());
    //        }
    //}
    public void dispathRollback(Connection con){
        try {
            con.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean buscarAuthorById(int codAuthor) throws SQLException {
        boolean existe=false;

        PreparedStatement psRead = null;
        ResultSet rs = null;
        Connection connection = ConnectBD.Connect();

        psRead = connection.prepareStatement(SELECT);
        rs = psRead.executeQuery();
        while (rs.next()) {
            if(rs.getInt(1)==codAuthor){
                existe = true;
            }
        }
        return existe;
    }

    //public void insertSeveral (HashMap<String, Integer> salesForWeek) throws SQLException {
    //    ConnectBD con = null;
//
    //    String updateString =
    //            "update COFFEES set SALES =? where COF_NAME =?";
    //    String updateStatement =
    //            "update COFFEES set TOTAL = TOTAL +? where COF_NAME =?";
//
    //    try (PreparedStatement updateSales = con.getCon().prepareStatement(updateString);
    //         PreparedStatement updateTotal = con.getCon().prepareStatement(updateStatement))
//
    //    {
//
    //        con.getCon().setAutoCommit(false);
    //        for (Map.Entry <String, Integer> e: salesForWeek.entrySet ())
    //        {
    //            updateSales.setInt (1, e.getValue().intValue());
    //            updateSales.setString (2, e.getKey ());
    //            updateSales.executeUpdate ();
//
    //            updateTotal.setInt (1, e.getValue().intValue());
    //            updateTotal.setString (2, e.getKey());
    //            updateTotal.executeUpdate ();
    //            con.getCon().commit();
    //        }
    //    } catch (SQLException e)
    //    {
    //        System.out.printf("Error: %s, %s%n", this.getClass().getSimpleName(), "Delete");
    //        e.printStackTrace();
    //        if (con!= null)
    //        {
    //            try {
    //                System.err.print ("La transacción se está revirtiendo");
    //                con.getCon().rollback();
    //            }catch (SQLException ex)
    //            {
    //                System.out.printf("Error: %s, %s%n", this.getClass().getSimpleName(), "Delete");
    //                ex.printStackTrace();
    //            }
    //        }
    //    }
    //}
}

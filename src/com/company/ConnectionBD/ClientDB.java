package com.company.ConnectionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDB implements DataBase{
    private static Connection con;
    //Aqui podriamos tener metodos de prepared statement genericos
    @Override
    public void initialise(String user, String password){
        if (con == null) {
            String url = "jdbc:postgresql://localhost:5432/libreriasPerez?useServerPrepStmts=true";
            try {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection(url, user, password);
                con.setAutoCommit(false);
                setConnection(con);
                System.out.println(con);
            } catch (SQLException e) {
                System.out.println("No se pudo conectar a la base de datos");
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
        }
    }
    @Override
    public void setConnection(Connection con) {
        ClientDB.con = con;
    }

    @Override
    public Connection getConnection() {

        //    if (con==null) {//the  if zone l.14 and l.
        //        String password = "000000";
        //        String user = "postgres";
        //        String url = "jdbc:postgresql://localhost:5432/libreriasPerez?useServerPrepStmts=true";

        //Connection con = null;
        //        try {
        //            Class.forName("org.postgresql.Driver");
        //            con = DriverManager.getConnection(url, user, password);
        //            con.setAutoCommit(false);

        //        } catch (SQLException e) {
        //            System.out.println("No se pudo conectar a la base de datos");
        //            e.printStackTrace();
        //        } catch (ClassNotFoundException ex) {
        //            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        //        }
        //    }
        return con;
    }

    @Override
    public PreparedStatement createStatement(String sql) throws SQLException {//Este si que tiene el SQLException pq asi lo podemos ver el error en caso que falle por el otro lado
        Connection con = getConnection();
        PreparedStatement ps = null;

        ps = con.prepareStatement(sql);

        return ps;
    }

    @Override
    public void Close() {
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void Commit() throws SQLException {
        con.commit();
    }

    @Override
    public void RollBlack() {

        try {
            con.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
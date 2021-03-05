package com.company.ConnectionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
/**
 * Conexión básica a la base de datos PostgreSQL.
 *
 * @author Jordi
 */
public class ConnectBD {
    //private String password;
    //private String user;
//
    //public ConnectBD(String password, String user) {
    //    this.password = password;
    //    this.user = user;
    //}

    /**
     * This method makes each sql statement have its own transaction.
     * @author Jordi
     * **/

    public static Connection Connect()
    {
        String password = "000000";
        String user = "postgres";
        String url = "jdbc:postgresql://localhost:5432/libreriasPerez?useServerPrepStmts=true";

        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        }
        return con;
    }

    //public static Connection conectar() throws SQLException {
    //    Connection con = null;
//
    //    String password = "000000";
    //    String usuario = "postgres";
    //    //String url = "jdbc:postgresql://localhost:5432/libreriasPerez?user=" + usuario
    //    //        + "&password=" + password;
    //    String url = "jdbc:postgresql://localhost:5432/libreriasPerez?useServerPrepStmts=true";
//
    //    try {
//
    //        Class.forName("org.postgresql.Driver");
    //        con = DriverManager.getConnection(url,
    //                usuario, password);
    //    } catch (SQLException e) {
    //        System.out.println("No se pudo conectar a la base de datos");
    //        e.printStackTrace();
    //    } catch (ClassNotFoundException ex) {
    //        System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
    //    }
    //    return con;
    //}

    /**
     //     * Establecemos la conexión con la base de datos <b>libreriasperez</b>.
     //     */
    //public void connectDatabase() {
    //    try {
    //        try {
    //            Class.forName("org.postgresql.Driver");
    //        } catch (ClassNotFoundException ex) {
    //            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
    //        }
    //        Connection connection = null;
    //        // Database connect
    //        // Conectamos con la base de datos
    //        connection = DriverManager.getConnection(
    //                "jdbc:postgresql://localhost:5432/libreriasPerez",
    //                "postgres", "000000");
    //        boolean valid = connection.isValid(50000);
    //        System.out.println(valid ? "TEST OK" : "TEST FAIL");
    //    } catch (java.sql.SQLException sqle) {
    //        System.out.println("Error: " + sqle);
    //    }
    //}
}
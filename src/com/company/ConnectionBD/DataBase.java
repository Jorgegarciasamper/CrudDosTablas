package com.company.ConnectionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface DataBase {
    Connection getConnection();
    void setConnection(Connection con);
    PreparedStatement createStatement(String sql) throws SQLException;
    void Close();
    void Commit() throws SQLException;
    void RollBlack() ;

    void initialise(String usuario, String password);
}
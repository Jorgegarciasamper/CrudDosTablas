package com.company.ConnectionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface DataBase {
    Connection getConnection();
    PreparedStatement createStatement(String sql) throws SQLException;
    void Close(Connection con);
    void Commit() throws SQLException;
    void RollBlack() ;
}

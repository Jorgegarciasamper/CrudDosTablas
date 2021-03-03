package com.company.DAOException;

import java.sql.SQLException;

public class DAOException extends Exception {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DAOException(String code, String message, Throwable cause) {
        super(message,cause);
        this.setCode(code);
    }

    public DAOException(String code, String message) {
        super(message);
        this.setCode(code);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }

    public DAOException(String message) {
        super(message);
    }

}

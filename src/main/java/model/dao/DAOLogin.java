/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import start.Routes;


/**
 *
 * @author Estudio-Trabajo
 */
public class DAOLogin implements IDAOLogin {
    
       private final String SQL_SELECT = "SELECT * FROM people.users WHERE username = ? AND password = ?";

    @Override
    public boolean validate(String username, String password) throws SQLException {
    Connection conn;
    PreparedStatement instruction;
    ResultSet rs;
    conn = DriverManager.getConnection(
    Routes.DB.getDbServerAddress() + Routes.DB.getDbServerComOpt(),
    Routes.DB.getDbServerUser(),
    Routes.DB.getDbServerPassword()
);
    instruction = conn.prepareStatement(SQL_SELECT);
    instruction.setString(1, username);
    instruction.setString(2, password);
    rs = instruction.executeQuery();
    boolean valid = rs.next();
    rs.close();
    instruction.close();
    conn.close();
    return valid;
}
   
}

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
import model.entity.User;
import model.entity.UserExceptionDAO;
import start.Routes;

/**
 *
 * @author Estudio-Trabajo
 */
public class DAOLogin implements IDAOLogin {

    private final String SQL_SELECT = "SELECT * FROM people.users WHERE username = ? AND user_password = ?";
    private final String SQL_SELECT_ADMIN = "SELECT isAdmin FROM people.users WHERE username = ? ";

    @Override
    public User validate(String username, String password) throws SQLException, UserExceptionDAO {
        User uReturn = null;
        Connection conn = DriverManager.getConnection(
                Routes.DB.getDbServerAddress() + Routes.DB.getDbServerComOpt(),
                Routes.DB.getDbServerUser(),
                Routes.DB.getDbServerPassword());

        PreparedStatement instruction;

        ResultSet rs;

        instruction = conn.prepareStatement(SQL_SELECT);
        instruction.setString(1, username);
        instruction.setString(2, password);

        rs = instruction.executeQuery();
        while (rs.next()) {
            String passwor = rs.getString("user_password");
            boolean admin = rs.getBoolean("isAdmin");
            uReturn = new User(username, passwor, admin);
        }
        rs.close();
        instruction.close();
        return uReturn;
    }

    @Override
    public boolean isAdmin(String username) throws SQLException {
        boolean valid = false;

        Connection conn = DriverManager.getConnection(
                Routes.DB.getDbServerAddress() + Routes.DB.getDbServerComOpt(),
                Routes.DB.getDbServerUser(),
                Routes.DB.getDbServerPassword()
        );

        PreparedStatement instruction;

        ResultSet rs;

        instruction = conn.prepareStatement(SQL_SELECT_ADMIN);
        instruction.setString(1, username);
        rs = instruction.executeQuery();

        if (rs.next()) {
            valid = rs.getBoolean("isAdmin");
        }

        rs.close();
        instruction.close();
        conn.close();
        return valid;
    }

}

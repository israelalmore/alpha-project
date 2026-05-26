/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.SQLException;
import model.entity.User;
import model.entity.UserExceptionDAO;

/**
 *
 * @author Estudio-Trabajo
 */
public interface IDAOLogin {
     User validate(String username, String password) throws SQLException, UserExceptionDAO;
     boolean isAdmin(String username) throws SQLException;
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.SQLException;

/**
 *
 * @author Estudio-Trabajo
 */
public interface IDAOLogin {
     boolean validate(String username, String password) throws SQLException;
    
}
